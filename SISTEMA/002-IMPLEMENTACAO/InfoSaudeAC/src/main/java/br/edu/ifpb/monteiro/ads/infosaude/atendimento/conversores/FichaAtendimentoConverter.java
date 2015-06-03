package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.FichaAtendimentoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = FichaAtendimento.class)
public class FichaAtendimentoConverter implements Converter {

    private final FichaAtendimentoService fichaAtendimentoService;

    public FichaAtendimentoConverter() throws UBSException {
        this.fichaAtendimentoService = CDIServiceLocator.getBean(FichaAtendimentoService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        FichaAtendimento objectToReturn = null;

        if (value != null) {
            objectToReturn = this.fichaAtendimentoService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((FichaAtendimento) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
