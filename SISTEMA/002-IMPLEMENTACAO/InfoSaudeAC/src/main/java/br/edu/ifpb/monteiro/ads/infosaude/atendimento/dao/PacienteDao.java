package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Paciente;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class PacienteDao extends DaoAbstrato<Paciente> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public PacienteDao() {
        super(Paciente.class);
    }

}
