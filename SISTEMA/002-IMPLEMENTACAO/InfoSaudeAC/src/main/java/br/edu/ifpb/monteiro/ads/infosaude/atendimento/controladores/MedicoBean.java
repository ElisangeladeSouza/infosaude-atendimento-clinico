package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Medico;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.MedicoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.MedicoServiceIF;
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
 * Managed bean usado pela página de cadastro de médico. 
 * É responsável por ligar a classe de modelo Medico à página de visualização 
 * processando as solicitações do usuário e retornando os dados à visualização.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class MedicoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(MedicoBean.class);

    @Inject
    private Medico medico;

    @Inject
    private MedicoServiceIF medicoService;

    @Inject
    private Medico medicoSelecionado;

    @Inject
    private PessoaServiceIF pessoaService;
    
    private transient List<Medico> medicos;

    /**
    * Construtor da classe
    */
    public MedicoBean() {
    }

    @PostConstruct
    public void init() {
        this.medicos = medicoService.findAll();
    }

    /**
     * Método responsável por carregar uma lista com todas as cidades cadastradas.
     * Esta lista será usada para preencher o respectivo campo de cidade na view.
     */
    public void carregarCidades() {
       pessoaService.retornaCidades(medico.getEndereco().getEnderecoEstado(), medico.getEndereco().getEnderecoEstado().getCodigo());
    }

    /**
     * Lista de médicos cadastrados na UBS.
     * 
     * @return 
     */
    public List<Medico> getMedicos() {
        return medicos;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do tipo
     * Medico e salvar. Se algum erro ocorrer, deve-se fazer rollback e 
     * apresentar uma mensagem de erro. 
     * 
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        try {
            this.medicoService.save(medico);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Cadastro do médico '" + medico.getNome() + "' atualizado com sucesso!");
                FacesUtil.redirecionaPara("PesquisaMedico.xhtml");
            } else {
                FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
            }
            medico = new Medico();
        } catch (RollbackException rollback) {
            LOGGER.warn(rollback);
            throw new NegocioException("O CPF informado já está cadastrado. Informe outro CPF.");
        }
    }

    /**
     * Método responsável por excluir um objeto do tipo Medico e exibir
     * ao final do processo uma mensagem informativa.
     * 
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.medicoService.delete(medicoSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaMedico.xhtml");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro e retorna true, senao refere-se a um produto
     * a ser editado, retornando false.
     *
     * @return
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
        return (MedicoService) medicoService;
    }

    public void setMedicoService(MedicoService medicoService) {
        this.medicoService = (MedicoServiceIF) medicoService;
    }
}
