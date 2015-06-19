package br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes;

/**
 *
 * @author elisangela
 */
public class NegocioException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @param message
     */
    public NegocioException(String message) {
        super(message);
    }
}
