package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Procedimento;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class ProcedimentoDao extends DaoAbstrato<Procedimento> implements Serializable {

    private static final long serialVersionUID = 1L;

    public ProcedimentoDao() {
        super(Procedimento.class);
    }

}
