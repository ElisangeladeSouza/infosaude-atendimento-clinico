package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class ExameDao extends DaoAbstrato<Exame> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public ExameDao() {
        super(Exame.class);
    }
    
}
