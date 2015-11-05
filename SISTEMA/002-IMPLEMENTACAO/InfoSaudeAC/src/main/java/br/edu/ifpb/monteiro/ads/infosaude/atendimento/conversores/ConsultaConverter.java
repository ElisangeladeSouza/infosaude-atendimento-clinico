package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Consulta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ConsultaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Consulta.class)
public class ConsultaConverter implements Converter {

    private final ConsultaService consultaService;

    /**
     * Enquanto a versão atual do JSF (2.2) não suporta injeção com dentro de
     * conversores, essa classe utilitária CDIServiceLocator, faz esse papel.
     */
    public ConsultaConverter() {
        this.consultaService = CDIServiceLocator.getBean(ConsultaService.class);
    }

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Consulta objectToReturn = null;

        if (value != null) {
            objectToReturn = this.consultaService.findById(new Long(value));
        }
        return objectToReturn;
    }

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Consulta) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
