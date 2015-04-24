package br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

    FacesContext facesContext = FacesContext.getCurrentInstance();

    public void mensagemSucesso(String mensagem) {
        facesContext.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        mensagem, mensagem));
    }

    public void mensagemAviso(String mensagem) {
        facesContext.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        mensagem, mensagem));
    }

    public void mensagemErro(String mensagem) {
        facesContext.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        mensagem, mensagem));
    }
}
