package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Recepcionista;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.RecepcionistaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
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
    private PessoaBean pessoaBean;

    private transient List<Recepcionista> recepcionistas;

    /**
     *
     */
    public RecepcionistaBean() {
    }

    /**
     *
     */
    public void carregarCidades() {
        PessoaBean.cidades.clear();
        for (String cidadesFiltradas : pessoaBean.retornaCidades(recepcionista.getEnderecoEstado().getCodigo())) {
            PessoaBean.cidades.add(cidadesFiltradas);
        }
    }

    /**
     *
     * @return
     */
    public List<Recepcionista> getRecepcionistas() {
        this.recepcionistas = recepcionistaService.findAll();
        return recepcionistas;
    }

    /**
     *
     * @throws UBSException
     */
    public void salvar() throws UBSException {
        try {
            this.recepcionistaService.save(recepcionista);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Atualização do cadastro efetuada com sucesso!");
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
     * @throws UBSException
     */
    public void excluir() throws UBSException {
        this.recepcionistaService.delete(recepcionistaSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */

    /**
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

    /**
     *
     * @param recepcionistaSelecionado
     */
    public void setRecepcionistaSelecionado(Recepcionista recepcionistaSelecionado) {
        this.recepcionistaSelecionado = recepcionistaSelecionado;
    }

    /**
     *
     * @return
     */
    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    /**
     *
     * @param recepcionista
     */
    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    /**
     *
     * @return
     */
    public RecepcionistaService getRecepcionistaService() {
        return recepcionistaService;
    }

    /**
     *
     * @param recepcionistaService
     */
    public void setRecepcionistaService(RecepcionistaService recepcionistaService) {
        this.recepcionistaService = recepcionistaService;
    }

}
