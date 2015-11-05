package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Procedimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ProcedimentoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela
 */
@FacesConverter(forClass = Procedimento.class)
public class ProcedimentoConverter implements Converter {

    private final ProcedimentoService procedimentoService;

    /**
     * Enquanto a versão atual do JSF (2.2) não suporta injeção com dentro de
     * conversores, essa classe utilitária CDIServiceLocator, faz esse papel.
     */
    public ProcedimentoConverter() {
        this.procedimentoService = CDIServiceLocator.getBean(ProcedimentoService.class);
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

        Procedimento objectToReturn = null;

        if (value != null) {
            objectToReturn = this.procedimentoService.findById(new Long(value));
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
            Long code = ((Procedimento) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }

}
