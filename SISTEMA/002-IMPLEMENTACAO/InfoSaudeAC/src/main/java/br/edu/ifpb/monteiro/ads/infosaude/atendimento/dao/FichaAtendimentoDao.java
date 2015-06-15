package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import java.io.Serializable;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class FichaAtendimentoDao extends DaoAbstrato<FichaAtendimento> implements Serializable {

    private static final long serialVersionUID = 1L;

    public FichaAtendimentoDao() {
        super(FichaAtendimento.class);
    }

}
