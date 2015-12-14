package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Recepcionista;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.PessoaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.RecepcionistaService;
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
 *
 * @author elisangela
 */
@Model
public class RecepcionistaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(RecepcionistaBean.class);

    @Inject
    private Recepcionista recepcionista;

    @Inject
    private RecepcionistaService recepcionistaService;

    @Inject
    private Recepcionista recepcionistaSelecionado;

    @Inject
    private PessoaService pessoaService;

    private transient List<Recepcionista> recepcionistas;

    /**
     *
     */
    public RecepcionistaBean() {
    }

    @PostConstruct
    public void init() {
        this.recepcionistas = recepcionistaService.findAll();
    }

    /**
     *
     */
    public void carregarCidades() {
        PessoaBean.cidades.clear();
        if (recepcionista.getEnderecoEstado() != null) {
            for (String cidadesFiltradas : pessoaService.retornaCidades(recepcionista.getEnderecoEstado().getCodigo())) {
                PessoaBean.cidades.add(cidadesFiltradas);
            }
        }
    }

    /**
     *
     * @return
     */
    public List<Recepcionista> getRecepcionistas() {
        return recepcionistas;
    }

    /**
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
     *
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.recepcionistaService.delete(recepcionistaSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
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

    /**
     *
     * @return
     */
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
        return recepcionistaService;
    }

    public void setRecepcionistaService(RecepcionistaService recepcionistaService) {
        this.recepcionistaService = recepcionistaService;
    }

}
