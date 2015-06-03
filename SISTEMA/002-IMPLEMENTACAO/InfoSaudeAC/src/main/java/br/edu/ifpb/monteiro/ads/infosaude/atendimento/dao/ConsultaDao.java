package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Consulta;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class ConsultaDao extends DaoAbstrato<Consulta> implements Serializable {

    private static final long serialVersionUID = 1L;

    public ConsultaDao() {
        super(Consulta.class);
    }
}
