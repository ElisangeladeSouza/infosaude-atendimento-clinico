package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Odontologo;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.OdontologoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author elisangela
 */
@Model
public class OdontologoBean {

    @Inject
    FacesUtil facesUtil;

    @Inject
    private Odontologo odontologo;

    @Inject
    private OdontologoService odontologoService;

    @Inject
    private Odontologo odontologoSelecionado;

    private List<Odontologo> odontologos;

    public List<Odontologo> getOdontologos() {
        this.odontologos = odontologoService.findAll();
        return odontologos;
    }

    public void salvar() throws UBSException {
        this.odontologoService.save(odontologo);
        odontologo = new Odontologo();
        facesUtil.mensagemSucesso("Odontólogo cadastrado com sucesso!");
    }

    public void excluir() throws UBSException {
        this.odontologoService.delete(odontologoSelecionado);
        facesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    public Odontologo getOdontologoSelecionado() {
        return odontologoSelecionado;
    }

    public void setOdontologoSelecionado(Odontologo odontologoSelecionado) {
        this.odontologoSelecionado = odontologoSelecionado;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public OdontologoService getOdontologoService() {
        return odontologoService;
    }

    public void setOdontologoService(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

}
