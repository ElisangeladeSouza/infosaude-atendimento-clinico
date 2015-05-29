package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.TecnicoEnfermagem;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.TecnicoEnfermagemService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela
 */
@FacesConverter(forClass = TecnicoEnfermagem.class)
public class TecnicoEnfermagemConverter implements Converter {

    private final TecnicoEnfermagemService tecnicoEnfermagemService;

    public TecnicoEnfermagemConverter() {
        this.tecnicoEnfermagemService = CDIServiceLocator.getBean(TecnicoEnfermagemService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        TecnicoEnfermagem objectToReturn = null;

        if (value != null) {
            objectToReturn = this.tecnicoEnfermagemService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((TecnicoEnfermagem) value).getId();
            String objectToReturn = (code == null ? null : code.toString());
            return objectToReturn;
        }
        return "";
    }
}
