package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.RequisicaoExame;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class RequisicaoExameDao extends DaoAbstrato<RequisicaoExame> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public RequisicaoExameDao() {
        super(RequisicaoExame.class);
    }

}
