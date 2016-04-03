package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Diretor;
import java.io.Serializable;

/**
 * Classe que contém métodos específicos que podem ser usados para fornecer 
 * serviços relacionados à comunicação com o banco de dados. Essa classe, ainda, 
 * herda todos os métodos abastratos da classe.
 * 
 * @see DaoAbstrato"
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class DiretorDao extends DaoAbstrato<Diretor> implements Serializable {

    private static final long serialVersionUID = 1L;

    public DiretorDao() {
        super(Diretor.class);
    }
}
