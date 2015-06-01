package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Medico;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.MedicoService;
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
public class MedicoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private static final Log LOGGER = LogFactory.getLog(MedicoBean.class);

    @Inject
    private Medico medico;

    @Inject
    private MedicoService medicoService;

    @Inject
    private Medico medicoSelecionado;

    @Inject
    private PessoaBean pessoaBean;

    private transient List<Medico> medicos;

    private transient List<Estados> estados = new ArrayList<>();
    private final transient List<String> cidades = new ArrayList<>();

    public MedicoBean() {
        estados = Arrays.asList(Estados.values());
    }

    public List<Estados> getEstados() {
        return estados;
    }

    public List<String> getCidades() {
        return cidades;
    }

    public void carregarCidades() {
        cidades.clear();
        for (String cidadesFiltradas : pessoaBean.retornaCidades(medico.getEnderecoEstado().getCodigo())) {
            cidades.add(cidadesFiltradas);
        }
    }

    public List<Medico> getMedicos() {
        this.medicos = medicoService.findAll();
        return medicos;
    }

    public void salvar() throws UBSException {
        try {
            this.medicoService.save(medico);
            medico = new Medico();
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        } catch (RollbackException rollback) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
            LOGGER.warn(rollback);
        }
    }

    public void excluir() throws UBSException {
        this.medicoService.delete(medicoSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditando() {
        return this.medico.getId() != null;
    }

    public Medico getMedicoSelecionado() {
        return medicoSelecionado;
    }

    public void setMedicoSelecionado(Medico medicoSelecionado) {
        this.medicoSelecionado = medicoSelecionado;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public MedicoService getMedicoService() {
        return medicoService;
    }

    public void setMedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }
}
