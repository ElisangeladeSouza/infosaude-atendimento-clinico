package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Administrador;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class AdministradorDao extends DaoAbstrato<Administrador> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public AdministradorDao() {
        super(Administrador.class);
    }

}
