package br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * Classe que cria uma fábrica de Exception Handlers
 * @author Cassio Oliveira <cassio@cassioliveira.com.br>
 */
public class JsfExceptionHandlerFactory  extends ExceptionHandlerFactory{

    private final ExceptionHandlerFactory exceptionHandlerFactory;

    public JsfExceptionHandlerFactory(ExceptionHandlerFactory exceptionHandlerFactory) {
        this.exceptionHandlerFactory = exceptionHandlerFactory;
    }
    
    @Override
    public ExceptionHandler getExceptionHandler() {
        return new JsfExceptionHandler(exceptionHandlerFactory.getExceptionHandler());
    }
    
}
