package br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes;

/**
 * Classe destinada a servir de ponte para tratar exceções da camada de dados.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class DaoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DaoException(String message) {
        super(message);
    }
}
