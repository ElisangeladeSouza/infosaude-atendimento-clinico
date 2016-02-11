package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaPreNatal;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.FichaPreNatalService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Esta classe representa o conversor de Ficha de pré-natal, cujo objetivo é converter
 * um valor enviando pela View em objeto ou retornar o ID do objeto. 
 * Ao implementar a interface Converter dois métodos são implementados, 
 * getAsObject e getAsString.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = FichaPreNatal.class)
public class FichaPreNatalConverter implements Converter {
    
    private FichaPreNatalService fichaPreNatalService;
    
    /**
     * Enquanto a versão atual do JSF (2.2) não suporta injeção com dentro de
     * conversores, essa classe utilitária CDIServiceLocator, faz esse papel.
     */
    public FichaPreNatalConverter() {
        this.fichaPreNatalService = CDIServiceLocator.getBean(FichaPreNatalService.class);
    }

    /**
     * Este método recebe a String e devolve o Object. Quando um FichaPreNatal
     * for mostrado na tela será seu ID que estará sendo exibido.
     * 
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        FichaPreNatal objectToReturn = null;

        if (value != null) {
            objectToReturn = this.fichaPreNatalService.findById(new Long(value));
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
            Long code = ((FichaPreNatal) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
    
    
}
