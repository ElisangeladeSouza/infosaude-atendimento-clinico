package br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.validacoes;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 * Anotação para validar um número de CEP.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Pattern(regexp = "^$|[0-9]{1,5}-[0-9]{1,3}",
        message = "Digite um CEP no formato: 99999-999")
@Constraint(validatedBy = {})
public @interface CEP {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
