package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Odontologo;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.OdontologoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Esta classe representa o conversor de Odontologo, cujo objetivo é converter
 * um valor enviando pela View em objeto ou retornar o ID do objeto. 
 * Ao implementar a interface Converter dois métodos são implementados, 
 * getAsObject e getAsString.
 * 
 * @author cassio <cassio@cassioliveira.com.br>
 */
@FacesConverter(forClass = Odontologo.class)
public class OdontologoConverter implements Converter {

    private final OdontologoService odontologoService;

    /**
     * Enquanto a versão atual do JSF (2.2) não suporta injeção com dentro de
     * conversores, essa classe utilitária CDIServiceLocator, faz esse papel.
     */
    public OdontologoConverter() {
        this.odontologoService = CDIServiceLocator.getBean(OdontologoService.class);
    }

    /**
     * Este método recebe a String e devolve o Object. Quando um Odontologo
     * for mostrado na tela será seu ID que estará sendo exibido.
     * 
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Odontologo objectToReturn = null;

        if (value != null) {
            objectToReturn = this.odontologoService.findById(new Long(value));
        }
        return objectToReturn;
    }

    /**
     * Este método recebe o Object e devolve a String. Apartir dessa String 
     * recuperamos o Object que esta ligado ao modelo.
     * 
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Odontologo) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
