package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Diretor;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.DiretorService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.DiretorServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.PessoaServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.RollbackException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * * Managed bean usado pela página de cadastro de adminsitrador. É responsável
 * por ligar a classe de modelo Diretor à página de visualização
 * processando as solicitações do usuário e retornando os dados à visualização.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class DiretorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(DiretorBean.class);

    @Inject
    private Diretor diretor;

    @Inject
    private DiretorServiceIF diretorService;

    @Inject
    private Diretor diretorSelecionado;

    @Inject
    private PessoaServiceIF pessoaService;

    private transient List<Diretor> diretores;

    /**
     * Construtor da classe
     */
    public DiretorBean() {
    }

    @PostConstruct
    public void init() {
        this.diretores = diretorService.findAll();
    }

    /**
     * Método responsável por carregar uma lista com todas as cidades
     * cadastradas. Esta lista será usada para preencher o respectivo campo de
     * cidade na view.
     */
    public void carregarCidades() {
        pessoaService.retornaCidades(diretor.getEndereco().getEstado(), diretor.getEndereco().getEstado().getCodigo());
//        PessoaBean.cidades.clear();
//        if (diretor.getEndereco().getEnderecoEstado() != null) {
//            for (String cidadesFiltradas : pessoaService.retornaCidades(diretor.getEndereco().getEnderecoEstado().getCodigo())) {
//                PessoaBean.cidades.add(cidadesFiltradas);
//            }
//        }
    }

    /**
     * Lista de diretores da UBS.
     *
     * @return
     */
    public List<Diretor> getDiretores() {
        return diretores;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Diretor e salvar. Se algum erro ocorrer, deve-se fazer
     * rollback e apresentar uma mensagem de erro.
     *
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        try {
            this.diretorService.save(diretor);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Cadastro do diretor '" + diretor.getNome() + "' atualizado com sucesso!");
            } else {
                FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
            }
            FacesUtil.redirecionaPara("PesquisaDiretor.xhtml");
            diretor = new Diretor();
        } catch (RollbackException rollback) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
            LOGGER.warn(rollback);
        }
    }

    /**
     * Método responsável por excluir um objeto do tipo Diretor e exibir
     * ao final do processo uma mensagem informativa.
     *
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.diretorService.delete(diretorSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaDiretor.xhtml");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.diretor.getId() != null;
    }

    public Diretor getDiretorSelecionado() {
        return diretorSelecionado;
    }

    public void setDiretorSelecionado(Diretor diretorSelecionado) {
        this.diretorSelecionado = diretorSelecionado;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public DiretorService getDiretorService() {
        return (DiretorService) diretorService;
    }

    public void setDiretorService(DiretorService diretorService) {
        this.diretorService = diretorService;
    }
}
