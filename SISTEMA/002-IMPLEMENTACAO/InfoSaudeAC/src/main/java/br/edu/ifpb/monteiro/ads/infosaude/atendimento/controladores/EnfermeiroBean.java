package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.EnfermeiroService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.RollbackException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elisangela
 */
@Named
@ViewScoped
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

    public EnfermeiroBean() {
    }

    public void carregarCidades() {
        PessoaBean.cidades.clear();
        for (String cidadesFiltradas : pessoaBean.retornaCidades(enfermeiro.getEnderecoEstado().getCodigo())) {
            PessoaBean.cidades.add(cidadesFiltradas);
        }
    }

    public List<Enfermeiro> getEnfermeiros() {
        if (enfermeiros == null) {
            this.enfermeiros = enfermeiroService.findAll();
            System.err.println("CHAMOU O GET ENFERMEIROS");
        }
        return enfermeiros;
    }

    public void salvar() throws UBSException {
        try {
            this.enfermeiroService.save(enfermeiro);
            enfermeiro = new Enfermeiro();
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        } catch (RollbackException rollback) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
            LOGGER.warn(rollback);
        }
    }

    public void excluir() throws UBSException {
        this.enfermeiroService.delete(enfermeiroSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
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
        return enfermeiroService;
    }

    public void setEnfermeiroService(EnfermeiroService enfermeiroService) {
        this.enfermeiroService = enfermeiroService;
    }

}
