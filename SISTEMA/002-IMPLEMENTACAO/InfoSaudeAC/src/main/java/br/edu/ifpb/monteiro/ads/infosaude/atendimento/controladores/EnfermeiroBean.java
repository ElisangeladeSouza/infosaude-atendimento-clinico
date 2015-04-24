package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.EnfermeiroService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author elisangela
 */
@Model
public class EnfermeiroBean {

    @Inject
    FacesUtil facesUtil;

    @Inject
    private Enfermeiro enfermeiro;

    @Inject
    private EnfermeiroService enfermeiroService;
    
    @Inject
    private Enfermeiro enfermeiroSelecionado;

    private List<Enfermeiro> enfermeiros;

    public List<Enfermeiro> getEnfermeiros() {
        this.enfermeiros = enfermeiroService.findAll();
        return enfermeiros;
    }

    public void salvar() throws UBSException {
        this.enfermeiroService.save(enfermeiro);
        enfermeiro = new Enfermeiro();
        facesUtil.mensagemSucesso("Enfermeiro cadastrado com sucesso!");
    }
    
    public void excluir() throws UBSException{
        this.enfermeiroService.delete(enfermeiroSelecionado);
        facesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
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
