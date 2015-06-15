package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 *
 * @author cassio
 */
@Model
public class UtilBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Força a atualização do contexto do JSF.
     */
    public void atualizaTela() {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse();
    }

    public String redirecionarPara(String pagina) {
        return pagina + "?faces-redirect=true";
    }
}
