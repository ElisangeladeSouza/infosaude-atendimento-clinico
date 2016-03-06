package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Recepcionista;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.RecepcionistaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.PessoaServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.RecepcionistaServiceIF;
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
 * Managed bean usado pela página de cadastro de recepcionista. 
 * É responsável por ligar a classe de modelo Recepcionista à página de visualização 
 * processando as solicitações do usuário e retornando os dados à visualização.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class RecepcionistaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(RecepcionistaBean.class);

    @Inject
    private Recepcionista recepcionista;

    @Inject
    private RecepcionistaServiceIF recepcionistaService;

    @Inject
    private Recepcionista recepcionistaSelecionado;

    @Inject
    private PessoaServiceIF pessoaService;

    private transient List<Recepcionista> recepcionistas;

    /**
     * Construtor da classe
     */
    public RecepcionistaBean() {
    }

    @PostConstruct
    public void init() {
        this.recepcionistas = recepcionistaService.findAll();
    }

    /**
     * Método responsável por carregar uma lista com todas as cidades cadastradas.
     * Esta lista será usada para preencher o respectivo campo de cidade na view.
     */
    public void carregarCidades() {
        pessoaService.retornaCidades(recepcionista.getEndereco().getEnderecoEstado(), recepcionista.getEndereco().getEnderecoEstado().getCodigo());
    }

    /**
     * Lista de Recepcionistas cadastradas na UBS.
     * @return
     */
    public List<Recepcionista> getRecepcionistas() {
        return recepcionistas;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do tipo
     * Recepcionista e salvar. Se algum erro ocorrer, deve-se fazer rollback e 
     * apresentar uma mensagem de erro.
     * 
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        try {
            this.recepcionistaService.save(recepcionista);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Cadastro do(a) recepcionista '" + recepcionista.getNome() + "' atualizado com sucesso!");
                FacesUtil.redirecionaPara("PesquisaRecepcionista.xhtml");
            } else {
                FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
            }
            recepcionista = new Recepcionista();
        } catch (RollbackException rollback) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
            LOGGER.warn(rollback);
        }
    }

    /**
     * Método responsável por excluir um objeto do tipo Recepcionista e exibir
     * ao final do processo uma mensagem informativa.
     * 
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.recepcionistaService.delete(recepcionistaSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaRecepcionista.xhtml");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.recepcionista.getId() != null;
    }

    public Recepcionista getRecepcionistaSelecionado() {
        return recepcionistaSelecionado;
    }

    public void setRecepcionistaSelecionado(Recepcionista recepcionistaSelecionado) {
        this.recepcionistaSelecionado = recepcionistaSelecionado;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public RecepcionistaService getRecepcionistaService() {
        return (RecepcionistaService) recepcionistaService;
    }

    public void setRecepcionistaService(RecepcionistaService recepcionistaService) {
        this.recepcionistaService = (RecepcionistaServiceIF) recepcionistaService;
    }
}
