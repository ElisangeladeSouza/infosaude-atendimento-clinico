package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Login;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.LoginService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela
 */
@FacesConverter(forClass = Login.class)
public class LoginConverter implements Converter {

    private final LoginService loginService;

    public LoginConverter() throws UBSException {
        this.loginService = CDIServiceLocator.getBean(LoginService.class);
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Login objectToReturn = null;

        if (value != null) {
            objectToReturn = this.loginService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Login) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
}
