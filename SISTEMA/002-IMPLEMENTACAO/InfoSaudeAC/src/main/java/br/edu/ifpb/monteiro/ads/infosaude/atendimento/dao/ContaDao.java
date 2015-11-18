package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Conta;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class ContaDao extends DaoAbstrato<Conta> implements Serializable {

    private static final long serialVersionUID = 1L;

    public ContaDao() {
        super(Conta.class);
    }

}
