package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.TecnicoEnfermagem;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.TecnicoEnfermagemService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Esta classe representa o conversor de TecnicoEnfermagem, cujo objetivo é converter
 * um valor enviando pela View em objeto ou retornar o ID do objeto. 
 * Ao implementar a interface Converter dois métodos são implementados, 
 * getAsObject e getAsString.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = TecnicoEnfermagem.class)
public class TecnicoEnfermagemConverter implements Converter {

    private final TecnicoEnfermagemService tecnicoEnfermagemService;

    /**
     * Enquanto a versão atual do JSF (2.2) não suporta injeção com dentro de
     * conversores, essa classe utilitária CDIServiceLocator, faz esse papel.
     */
    public TecnicoEnfermagemConverter() {
        this.tecnicoEnfermagemService = CDIServiceLocator.getBean(TecnicoEnfermagemService.class);
    }

    /**
     * Este método recebe a String e devolve o Object. Quando um TecnicoEnfermagem
     * for mostrado na tela será seu ID que estará sendo exibido.
     * 
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        TecnicoEnfermagem objectToReturn = null;

        if (value != null) {
            objectToReturn = this.tecnicoEnfermagemService.findById(new Long(value));
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
            Long code = ((TecnicoEnfermagem) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
