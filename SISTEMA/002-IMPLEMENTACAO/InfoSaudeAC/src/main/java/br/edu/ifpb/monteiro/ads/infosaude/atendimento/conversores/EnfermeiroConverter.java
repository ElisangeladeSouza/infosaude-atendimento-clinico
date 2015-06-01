package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.EnfermeiroService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Enfermeiro.class)
public class EnfermeiroConverter implements Converter {

    private final EnfermeiroService enfermeiroService;

    public EnfermeiroConverter() throws UBSException {
        this.enfermeiroService = CDIServiceLocator.getBean(EnfermeiroService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Enfermeiro objectToReturn = null;

        if (value != null) {
            objectToReturn = this.enfermeiroService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Enfermeiro) value).getId();
            String objectToReturn = (code == null ? null : code.toString());
            return objectToReturn;
        }
        return "";
    }
}
