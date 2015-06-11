package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Triagem;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.TriagemService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela
 */
@FacesConverter(forClass = Triagem.class)
public class TriagemConverter implements Converter {

    private final TriagemService triagemService;

    public TriagemConverter() throws UBSException {
        this.triagemService = CDIServiceLocator.getBean(TriagemService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Triagem objectToReturn = null;

        if (value != null) {
            objectToReturn = this.triagemService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Triagem) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }

}
