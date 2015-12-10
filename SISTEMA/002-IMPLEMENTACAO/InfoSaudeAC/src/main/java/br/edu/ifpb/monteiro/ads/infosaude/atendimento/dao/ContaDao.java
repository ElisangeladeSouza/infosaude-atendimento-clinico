package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Conta;
import java.io.Serializable;

/**
 * Esta classe representa um DAO genérico de Conta e extende todos os métodos contidos
 * na classe DAOAbstrato.
 * 
 * @author elisangela
 */
public class ContaDao extends DaoAbstrato<Conta> implements Serializable {

    private static final long serialVersionUID = 1L;

    public ContaDao() {
        super(Conta.class);
    }

}
