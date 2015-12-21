package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.FichaAtendimentoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Esta classe representa o conversor de FichaAtendimento, cujo objetivo é converter
 * um valor enviando pela View em objeto ou retornar o ID do objeto. 
 * Ao implementar a interface Converter dois métodos são implementados, 
 * getAsObject e getAsString.
 * 
 * @author cassio <cassio@cassioliveira.com.br>
 */
@FacesConverter(forClass = FichaAtendimento.class)
public class FichaAtendimentoConverter implements Converter {

    private final FichaAtendimentoService fichaAtendimentoService;

    /**
     * Enquanto a versão atual do JSF (2.2) não suporta injeção com dentro de
     * conversores, essa classe utilitária CDIServiceLocator, faz esse papel.
     */
    public FichaAtendimentoConverter() {
        this.fichaAtendimentoService = CDIServiceLocator.getBean(FichaAtendimentoService.class);
    }

    /**
     * Este método recebe a String e devolve o Object. Quando uma FichaAtendimento
     * for mostrada na tela será seu ID que estará sendo exibido.
     * 
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        FichaAtendimento objectToReturn = null;

        if (value != null) {
            objectToReturn = this.fichaAtendimentoService.findById(new Long(value));
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
            Long code = ((FichaAtendimento) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
