package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.RequisicaoExame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.RequisicaoExameService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = RequisicaoExame.class)
public class RequisicaoExameConverter implements Converter {

    private final RequisicaoExameService requisicaoExameService;

    /**
     *
     * @throws UBSException
     */
    public RequisicaoExameConverter() throws UBSException {
        this.requisicaoExameService = CDIServiceLocator.getBean(RequisicaoExameService.class);
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

        RequisicaoExame objectToReturn = null;

        if (value != null) {
            objectToReturn = this.requisicaoExameService.findById(new Long(value));
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
            Long code = ((RequisicaoExame) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
