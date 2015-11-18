package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Conta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ContaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela
 */
@FacesConverter(forClass = Conta.class)
public class ContaConverter implements Converter {

    private final ContaService contaService;

    public ContaConverter() throws UBSException {
        this.contaService = CDIServiceLocator.getBean(ContaService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Conta objectToReturn = null;

        if (value != null) {
            objectToReturn = this.contaService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Conta) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }

}
