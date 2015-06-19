package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.TecnicoEnfermagem;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class TecnicoEnfermagemDao extends DaoAbstrato<TecnicoEnfermagem> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public TecnicoEnfermagemDao() {
        super(TecnicoEnfermagem.class);
    }

}
