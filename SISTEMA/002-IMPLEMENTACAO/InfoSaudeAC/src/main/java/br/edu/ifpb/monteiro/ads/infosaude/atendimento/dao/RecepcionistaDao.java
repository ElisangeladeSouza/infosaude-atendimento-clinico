package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Recepcionista;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class RecepcionistaDao extends DaoAbstrato<Recepcionista> implements Serializable {

    private static final long serialVersionUID = 1L;

    public RecepcionistaDao() {
        super(Recepcionista.class);
    }

}
