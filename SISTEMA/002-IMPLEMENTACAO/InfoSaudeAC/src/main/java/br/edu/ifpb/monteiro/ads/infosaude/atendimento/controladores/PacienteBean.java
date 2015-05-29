package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Paciente;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.PacienteService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.RollbackException;

/**
 *
 * @author elisangela
 */
@Model
public class PacienteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Paciente paciente;

    @Inject
    private PacienteService pacienteService;

    @Inject
    private Paciente pacienteSelecionado;

    @Inject
    private PessoaBean pessoaBean;

    private transient List<Paciente> pacientes;

    private transient List<Estados> estados = new ArrayList<>();
    private transient List<String> cidades = new ArrayList<>();

    public PacienteBean() {
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
        for (String cidadesFiltradas : pessoaBean.retornaCidades(paciente.getEnderecoEstado().getCodigo())) {
            cidades.add(cidadesFiltradas);
        }
    }

    public List<Paciente> getPacientes() {
        this.pacientes = pacienteService.findAll();
        return pacientes;
    }

    public void salvar() throws UBSException {
        try {
            this.pacienteService.save(paciente);
            paciente = new Paciente();
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        } catch (RollbackException ex) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
        }
    }

    public void excluir() throws UBSException {
        this.pacienteService.delete(pacienteSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditando() {
        return this.paciente.getId() != null;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public PacienteService getPacienteService() {
        return pacienteService;
    }

    public void setPacienteService(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public Paciente getPacienteSelecionado() {
        return pacienteSelecionado;
    }

    public void setPacienteSelecionado(Paciente pacienteSelecionado) {
        this.pacienteSelecionado = pacienteSelecionado;
    }

}
