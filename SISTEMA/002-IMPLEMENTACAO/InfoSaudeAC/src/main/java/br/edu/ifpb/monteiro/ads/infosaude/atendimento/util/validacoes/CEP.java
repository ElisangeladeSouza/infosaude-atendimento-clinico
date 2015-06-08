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

/**
 * Anotação para validar um número de CEP
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Target({METHOD, FIELD,ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
public @interface CEP {
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
    
}
