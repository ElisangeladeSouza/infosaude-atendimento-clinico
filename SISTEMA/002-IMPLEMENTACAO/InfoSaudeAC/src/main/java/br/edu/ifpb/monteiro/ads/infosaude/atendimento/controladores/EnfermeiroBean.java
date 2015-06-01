package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.EnfermeiroService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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

    private transient List<Estados> estados = new ArrayList<>();
    private transient List<String> cidades = new ArrayList<>();

    public EnfermeiroBean() {
        estados = Arrays.asList(Estados.values());
    }

    public List<Estados> getEstados() {
        return estados;
    }

    public void setEstados(List<Estados> estados) {
        this.estados = estados;
    }

    public List<String> getCidades() {
        return cidades;
    }

    public void setCidades(List<String> cidades) {
        this.cidades = cidades;
    }

    public void carregarCidades() {
        cidades.clear();
        for (String cidadesFiltradas : pessoaBean.retornaCidades(enfermeiro.getEnderecoEstado().getCodigo())) {
            cidades.add(cidadesFiltradas);
        }
    }

    public List<Enfermeiro> getEnfermeiros() {
        this.enfermeiros = enfermeiroService.findAll();
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
