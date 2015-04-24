package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Medico;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.MedicoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author elisangela
 */
@Model
public class MedicoBean {

    @Inject
    FacesUtil facesUtil;

    @Inject
    private Medico medico;

    @Inject
    private MedicoService medicoService;

    @Inject
    private Medico medicoSelecionado;

    private List<Medico> medicos;

    public List<Medico> getMedicos() {
        this.medicos = medicoService.findAll();
        return medicos;
    }

    public void salvar() throws UBSException {
        this.medicoService.save(medico);
        medico = new Medico();
        facesUtil.mensagemSucesso("Médico cadastrado com sucesso!");
    }

    public void excluir() throws UBSException {
        this.medicoService.delete(medicoSelecionado);
        facesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
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
