package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Medico;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.MedicoService;
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

    /**
     *
     */
    public MedicoBean() {
    }

    /**
     *
     */
    public void carregarCidades() {
        PessoaBean.cidades.clear();
        for (String cidadesFiltradas : pessoaBean.retornaCidades(medico.getEnderecoEstado().getCodigo())) {
            PessoaBean.cidades.add(cidadesFiltradas);
        }
    }

    /**
     *
     * @return
     */
    public List<Medico> getMedicos() {
        this.medicos = medicoService.findAll();
        return medicos;
    }

    /**
     *
     * @throws UBSException
     */
    public void salvar() throws UBSException {
        try {
            this.medicoService.save(medico);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Atualização do cadastro efetuada com sucesso!");
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
     *
     * @throws UBSException
     */
    public void excluir() throws UBSException {
        this.medicoService.delete(medicoSelecionado);
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
        return this.medico.getId() != null;
    }

    /**
     *
     * @return
     */
    public Medico getMedicoSelecionado() {
        return medicoSelecionado;
    }

    /**
     *
     * @param medicoSelecionado
     */
    public void setMedicoSelecionado(Medico medicoSelecionado) {
        this.medicoSelecionado = medicoSelecionado;
    }

    /**
     *
     * @return
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     *
     * @param medico
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     *
     * @return
     */
    public MedicoService getMedicoService() {
        return medicoService;
    }

    /**
     *
     * @param medicoService
     */
    public void setMedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }
}
