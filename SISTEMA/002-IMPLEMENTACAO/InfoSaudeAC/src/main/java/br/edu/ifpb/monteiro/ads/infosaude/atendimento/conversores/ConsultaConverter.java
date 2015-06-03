package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Consulta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ConsultaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Consulta.class)
public class ConsultaConverter implements Converter {

    private final ConsultaService consultaService;

    public ConsultaConverter() throws UBSException {
        this.consultaService = CDIServiceLocator.getBean(ConsultaService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Consulta objectToReturn = null;

        if (value != null) {
            objectToReturn = this.consultaService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Consulta) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
