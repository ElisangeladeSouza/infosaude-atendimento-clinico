package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Odontologo;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.OdontologoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Odontologo.class)
public class OdontologoConverter implements Converter {

    private final OdontologoService odontologoService;

    public OdontologoConverter() {
        this.odontologoService = CDIServiceLocator.getBean(OdontologoService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Odontologo objectToReturn = null;

        if (value != null) {
            objectToReturn = this.odontologoService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Odontologo) value).getId();
            String objectToReturn = (code == null ? null : code.toString());
            return objectToReturn;
        }
        return "";
    }
}
