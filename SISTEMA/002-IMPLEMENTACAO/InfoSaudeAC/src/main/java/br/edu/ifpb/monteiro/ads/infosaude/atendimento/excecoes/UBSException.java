package br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes;

/**
 *
 * @author elisangela
 */
public class UBSException extends Exception {

    public UBSException(String message, Exception exception) {
        super(message);
    }
}
