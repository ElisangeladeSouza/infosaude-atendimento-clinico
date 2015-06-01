package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Administrador;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.AdministradorService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela
 */
@FacesConverter(forClass = Administrador.class)
public class AdministradorConverter implements Converter {

    private final AdministradorService administradorService;

    public AdministradorConverter() throws UBSException {
        this.administradorService = CDIServiceLocator.getBean(AdministradorService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Administrador objectToReturn = null;

        if (value != null) {
            objectToReturn = this.administradorService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Administrador) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }

}
