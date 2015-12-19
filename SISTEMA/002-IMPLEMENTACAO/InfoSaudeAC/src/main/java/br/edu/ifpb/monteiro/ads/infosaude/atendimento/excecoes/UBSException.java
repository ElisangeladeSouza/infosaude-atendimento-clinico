package br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes;

/**
 * A classe UBSException representa um tipo de exceção usado para 
 * representar erros gerais que não pertencem a lógica de negócio.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class UBSException extends Exception {

    /**
     * Classe destinada a servir de ponte para tratar exceções gerais.
     * 
     * @param message
     */
    public UBSException(String message) {
        super(message);
    }
}
