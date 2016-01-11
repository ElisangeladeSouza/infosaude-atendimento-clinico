package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Paciente;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.PacienteService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.PacienteServiceIF;
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
 * Managed bean usado pela página de cadastro de paciente. 
 * É responsável por ligar a classe de modelo Paciente à página de visualização 
 * processando as solicitações do usuário e retornando os dados à visualização.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class PacienteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(PacienteBean.class);

    @Inject
    private Paciente paciente;

    @Inject
    private PacienteServiceIF pacienteService;

    @Inject
    private Paciente pacienteSelecionado;

    @Inject
    private PessoaServiceIF pessoaService;

    private transient List<Paciente> pacientes;

    /**
     * Construtor da classe
     */
    public PacienteBean() {
    }

    @PostConstruct
    public void init() {
        this.pacientes = pacienteService.findAll();
    }

    /**
     * Método responsável por carregar uma lista com todas as cidades cadastradas.
     * Esta lista será usada para preencher o respectivo campo de cidade na view.
     */
    public void carregarCidades() {
        PessoaBean.cidades.clear();
        if (paciente.getEnderecoEstado() != null) {
            for (String cidadesFiltradas : pessoaService.retornaCidades(paciente.getEnderecoEstado().getCodigo())) {
                PessoaBean.cidades.add(cidadesFiltradas);
            }
        }
    }

    /**
     * Lista de pacientes cadastrados na UBS.
     * 
     * @return 
     */
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do tipo
     * Paciente e salvar. Se algum erro ocorrer, deve-se fazer rollback e 
     * apresentar uma mensagem de erro.
     * 
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        try {
            this.pacienteService.save(paciente);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Cadastro do paciente '" + paciente.getNome() + "' atualizado com sucesso!");
                FacesUtil.redirecionaPara("PesquisaPaciente.xhtml");
            } else {
                FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
            }
            paciente = new Paciente();
        } catch (RollbackException rollback) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
            LOGGER.warn(rollback);
        }
    }

    /**
     * Método responsável por excluir um objeto do tipo Paciente e exibir
     * ao final do processo uma mensagem informativa.
     * 
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.pacienteService.delete(pacienteSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
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
        return (PacienteService) pacienteService;
    }

    public void setPacienteService(PacienteService pacienteService) {
        this.pacienteService = (PacienteServiceIF) pacienteService;
    }

    public Paciente getPacienteSelecionado() {
        return pacienteSelecionado;
    }

    public void setPacienteSelecionado(Paciente pacienteSelecionado) {
        this.pacienteSelecionado = pacienteSelecionado;
    }

}
