package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Recepcionista;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.RecepcionistaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela
 */
@FacesConverter(forClass = Recepcionista.class)
public class RecepcionistaConverter implements Converter {
    
    private final RecepcionistaService recepcionistaService;

    public RecepcionistaConverter() {
        this.recepcionistaService = CDIServiceLocator.getBean(RecepcionistaService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Recepcionista objectToReturn = null;

        if (value != null) {
            objectToReturn = this.recepcionistaService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Recepcionista) value).getId();
            String objectToReturn = (code == null ? null : code.toString());
            return objectToReturn;
        }
        return "";
    }
    
}
