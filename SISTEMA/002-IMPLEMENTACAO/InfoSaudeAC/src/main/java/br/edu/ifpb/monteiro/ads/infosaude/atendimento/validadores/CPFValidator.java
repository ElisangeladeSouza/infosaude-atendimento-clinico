package br.edu.ifpb.monteiro.ads.infosaude.atendimento.validadores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

/**
 *
 * @author cassio
 */
@FacesValidator(value = "cpfValidator")
public class CPFValidator implements Validator {

    @Inject
    FacesUtil facesUtil;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        if (value == null) {
            return;
        }
        String cpf = (String) value;

        if (cpf.length() != 11 || !calcularDigitoVerificador(cpf.substring(0, 9)).equals(cpf.substring(9, 11))) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF inválido.", "Favor informar um CPF válido."));
        }
    }

    //Créditos ao JavaFree.org pelo algoritmo de validação de CPF
    @SuppressWarnings({"UnnecessaryBoxing", "UnnecessaryUnboxing"})
    private String calcularDigitoVerificador(String num) {
            //if condicional para verificar se o CPF tem números iguais nos nove primeiros digitos. 
        if (num.substring(0, 3).equals(num.substring(3, 6))) {
            if (num.substring(0, 3).equals(num.substring(6, 9))) {
            }
        } else {
            //Calculo do 1º dígito
            Integer primDig, segDig;
            int soma = 0;
            int peso = 10;
            for (int i = 0; i < num.length(); i++) {
                soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
            }
            if (soma % 11 == 0 || soma % 11 == 1) {
                primDig = new Integer(0);
            } else {
                primDig = new Integer(11 - (soma % 11));
            }

            //Calculo do 2º dígito
            soma = 0;
            peso = 11;
            for (int i = 0; i < num.length(); i++) {
                soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
            }
            soma += primDig.intValue() * 2;
            if (soma % 11 == 0 || soma % 11 == 1) {
                segDig = new Integer(0);
            } else {
                segDig = new Integer(11 - (soma % 11));
            }
            System.out.println(primDig.toString() + segDig.toString());
            return primDig.toString() + segDig.toString();
        }
        return "Erro de validação desconhecido em: CPFValidator";
    }
}
