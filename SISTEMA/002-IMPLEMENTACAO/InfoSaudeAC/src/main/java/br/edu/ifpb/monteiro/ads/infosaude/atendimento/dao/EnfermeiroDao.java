package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class EnfermeiroDao extends DaoAbstrato<Enfermeiro> implements Serializable {

    private static final long serialVersionUID = 1L;

    public EnfermeiroDao() {
        super(Enfermeiro.class);
    }

}
