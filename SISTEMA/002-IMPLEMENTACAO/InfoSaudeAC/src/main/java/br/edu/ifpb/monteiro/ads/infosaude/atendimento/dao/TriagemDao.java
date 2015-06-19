package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Triagem;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class TriagemDao extends DaoAbstrato<Triagem> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public TriagemDao() {
        super(Triagem.class);
    }

}
