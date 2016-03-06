package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.EnfermeiroService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.EnfermeiroServiceIF;
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
 * Managed bean usado pela página de cadastro de enfermeiro. 
 * É responsável por ligar a classe de modelo Enfermeiro à página de visualização 
 * processando as solicitações do usuário e retornando os dados à visualização.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class EnfermeiroBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(EnfermeiroBean.class);

    @Inject
    private Enfermeiro enfermeiro;

    @Inject
    private EnfermeiroServiceIF enfermeiroService;

    @Inject
    private Enfermeiro enfermeiroSelecionado;

    @Inject
    private PessoaServiceIF pessoaService;

    private transient List<Enfermeiro> enfermeiros;

    /**
     * Construtor da classe
     */
    public EnfermeiroBean() {
    }

    @PostConstruct
    public void init() {
        this.enfermeiros = enfermeiroService.findAll();
    }

    /**
     * Método responsável por carregar uma lista com todas as cidades cadastradas.
     * Esta lista será usada para preencher o respectivo campo de cidade na view.
     */
    public void carregarCidades() {
        pessoaService.retornaCidades(enfermeiro.getEndereco().getEnderecoEstado(), enfermeiro.getEndereco().getEnderecoEstado().getCodigo());
    }

    /**
     * Lista de enfermeiros cadastrados na UBS.
     * @return
     */
    public List<Enfermeiro> getEnfermeiros() {
        return enfermeiros;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do tipo
     * Enfermeiro e salvar. Se algum erro ocorrer, deve-se fazer rollback e 
     * apresentar uma mensagem de erro. 
     * 
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        try {
            this.enfermeiroService.save(enfermeiro);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Cadastro do enfermeiro '" + enfermeiro.getNome() + "' atualizado com sucesso!");
                FacesUtil.redirecionaPara("PesquisaEnfermeiro.xhtml");
            } else {
                FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
            }
            enfermeiro = new Enfermeiro();
        } catch (RollbackException rollback) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
            LOGGER.warn(rollback);
        }
    }

    /**
     * Método responsável por excluir um objeto do tipo Enfermeiro e exibir
     * ao final do processo uma mensagem informativa.
     * 
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.enfermeiroService.delete(enfermeiroSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaEnfermeiro.xhtml");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.enfermeiro.getId() != null;
    }

    public Enfermeiro getEnfermeiroSelecionado() {
        return enfermeiroSelecionado;
    }

    public void setEnfermeiroSelecionado(Enfermeiro enfermeiroSelecionado) {
        this.enfermeiroSelecionado = enfermeiroSelecionado;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public EnfermeiroService getEnfermeiroService() {
        return (EnfermeiroService) enfermeiroService;
    }

    public void setEnfermeiroService(EnfermeiroService enfermeiroService) {
        this.enfermeiroService = (EnfermeiroServiceIF) enfermeiroService;
    }
}
