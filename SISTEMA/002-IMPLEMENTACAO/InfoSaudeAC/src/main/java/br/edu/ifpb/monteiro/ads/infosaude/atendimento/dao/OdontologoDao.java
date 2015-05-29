package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Odontologo;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class OdontologoDao extends DaoAbstrato<Odontologo> implements Serializable {

    private static final long serialVersionUID = 1L;

    public OdontologoDao() {
        super(Odontologo.class);
    }

}
