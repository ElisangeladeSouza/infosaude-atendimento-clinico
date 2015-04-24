package br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */

@FacesConverter(value = "cpfConverter")
public class CPFConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        // Convertendo CPF com máscara (111.111.111-11)
        // em CPF sem máscara (11111111111).
        String cpf = value;
        if (value != null && !"".equals(value)) {
            cpf = value.replaceAll("\\.", "").replaceAll("\\-", "");
        }
        return cpf;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        // Converter CPF sem máscara (11111111111)
        // em CPF com máscara (111.111.111-11)
        String cpf = (String) value;
        if (cpf != null && cpf.length() == 11) {
            cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
        }

        return cpf;
    }
}
