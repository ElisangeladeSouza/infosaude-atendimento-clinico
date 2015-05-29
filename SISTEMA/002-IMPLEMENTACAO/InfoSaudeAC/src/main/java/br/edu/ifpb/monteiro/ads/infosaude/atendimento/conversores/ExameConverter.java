package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ExameService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author elisangela
 */
@FacesConverter(forClass = Exame.class)
public class ExameConverter implements Converter {
    
     private final ExameService exameService;

    public ExameConverter() {
        this.exameService = CDIServiceLocator.getBean(ExameService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Exame objectToReturn = null;

        if (value != null) {
            objectToReturn = this.exameService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Exame) value).getId();
            String objectToReturn = (code == null ? null : code.toString());
            return objectToReturn;
        }
        return "";
    }
    
}
