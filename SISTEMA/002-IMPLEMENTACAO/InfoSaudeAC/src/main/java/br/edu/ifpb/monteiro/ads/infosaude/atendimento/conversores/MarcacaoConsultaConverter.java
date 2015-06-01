package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.MarcacaoConsulta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.MarcacaoConsultaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = MarcacaoConsulta.class)
public class MarcacaoConsultaConverter implements Converter {

    private final MarcacaoConsultaService marcacaoConsultaService;

    public MarcacaoConsultaConverter() throws UBSException {
        this.marcacaoConsultaService = CDIServiceLocator.getBean(MarcacaoConsultaService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        MarcacaoConsulta objectToReturn = null;

        if (value != null) {
            objectToReturn = this.marcacaoConsultaService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((MarcacaoConsulta) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
