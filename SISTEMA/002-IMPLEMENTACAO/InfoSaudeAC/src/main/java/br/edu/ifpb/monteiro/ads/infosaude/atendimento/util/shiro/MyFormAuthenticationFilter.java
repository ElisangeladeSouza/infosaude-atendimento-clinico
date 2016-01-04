package br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.shiro;

import javax.servlet.ServletRequest;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * Classe personalizada MyFormAuthenticationFilter. Filtro de autenticação. 
 * Seu papel é filtrar mensagens de erro. Qualquer erro na autenticação uma 
 * exceção é lançada.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        String message = ae.getMessage();
        request.setAttribute(getFailureKeyAttribute(), message);
    }
}
