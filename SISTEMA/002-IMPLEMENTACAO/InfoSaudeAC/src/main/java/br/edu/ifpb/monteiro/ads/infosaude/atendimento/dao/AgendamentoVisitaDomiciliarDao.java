package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.AgendamentoVisitaDomiciliar;
import java.io.Serializable;

/**
 * Classe que contém métodos específicos que podem ser usados para fornecer 
 * serviços relacionados à comunicação com o banco de dados. Essa classe, ainda, 
 * herda todos os métodos abstratos da classe.
 * 
 * @see DaoAbstrato
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class AgendamentoVisitaDomiciliarDao extends DaoAbstrato<AgendamentoVisitaDomiciliar> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public AgendamentoVisitaDomiciliarDao() {
        super(AgendamentoVisitaDomiciliar.class);
    }
}
