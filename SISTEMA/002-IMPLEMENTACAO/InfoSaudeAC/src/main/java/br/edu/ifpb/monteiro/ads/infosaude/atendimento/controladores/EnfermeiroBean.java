package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.EnfermeiroService;
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
public class EnfermeiroBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(EnfermeiroBean.class);

    @Inject
    private Enfermeiro enfermeiro;

    @Inject
    private EnfermeiroService enfermeiroService;

    @Inject
    private Enfermeiro enfermeiroSelecionado;

    @Inject
    private PessoaBean pessoaBean;

    private transient List<Enfermeiro> enfermeiros;

    /**
     *
     */
    public EnfermeiroBean() {
    }

    /**
     *
     */
    public void carregarCidades() {
        PessoaBean.cidades.clear();
        for (String cidadesFiltradas : pessoaBean.retornaCidades(enfermeiro.getEnderecoEstado().getCodigo())) {
            PessoaBean.cidades.add(cidadesFiltradas);
        }
    }

    /**
     *
     * @return
     */
    public List<Enfermeiro> getEnfermeiros() {
        this.enfermeiros = enfermeiroService.findAll();
        return enfermeiros;
    }

    /**
     *
     * @throws UBSException
     */
    public void salvar() throws UBSException {
        try {
            this.enfermeiroService.save(enfermeiro);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Atualização do cadastro efetuada com sucesso!");
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
     *
     * @throws UBSException
     */
    public void excluir() throws UBSException {
        this.enfermeiroService.delete(enfermeiroSelecionado);
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
        return this.enfermeiro.getId() != null;
    }

    /**
     *
     * @return
     */
    public Enfermeiro getEnfermeiroSelecionado() {
        return enfermeiroSelecionado;
    }

    /**
     *
     * @param enfermeiroSelecionado
     */
    public void setEnfermeiroSelecionado(Enfermeiro enfermeiroSelecionado) {
        this.enfermeiroSelecionado = enfermeiroSelecionado;
    }

    /**
     *
     * @return
     */
    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    /**
     *
     * @param enfermeiro
     */
    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    /**
     *
     * @return
     */
    public EnfermeiroService getEnfermeiroService() {
        return enfermeiroService;
    }

    /**
     *
     * @param enfermeiroService
     */
    public void setEnfermeiroService(EnfermeiroService enfermeiroService) {
        this.enfermeiroService = enfermeiroService;
    }

}
