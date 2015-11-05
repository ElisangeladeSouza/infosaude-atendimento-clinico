package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Medico;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.MedicoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Medico.class)
public class MedicoConverter implements Converter {

    private final MedicoService medicoService;

    /**
     * Enquanto a versão atual do JSF (2.2) não suporta injeção com dentro de
     * conversores, essa classe utilitária CDIServiceLocator, faz esse papel.
     */
    public MedicoConverter() {
        this.medicoService = CDIServiceLocator.getBean(MedicoService.class);
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

        Medico objectToReturn = null;

        if (value != null) {
            objectToReturn = this.medicoService.findById(new Long(value));
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
            Long code = ((Medico) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
