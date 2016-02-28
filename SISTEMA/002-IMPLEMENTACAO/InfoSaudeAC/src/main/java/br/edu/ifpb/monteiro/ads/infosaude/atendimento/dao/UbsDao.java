package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Ubs;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;

/**
 * Classe que contém métodos específicos que podem ser usados para fornecer 
 * serviços relacionados à comunicação com o banco de dados. Essa classe, ainda, 
 * herda todos os métodos abstratos da classe.
 * 
 * @see DaoAbstrato
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class UbsDao extends DaoAbstrato<Ubs> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public UbsDao() {
        super(Ubs.class);
    }
    
    /**
     * Método responsável por retornar a lista de cidades brasileiras.
     * Carrega a lista de cidades através de uma consulta personalizada.
     * @param codigoUF
     * @return
     */
    public List<String> retornaCidades(int codigoUF) {
        Query createQuery;
        createQuery = getEntityManager().createNativeQuery("SELECT c.nome FROM cidades c where c.estado = " + codigoUF);
        return createQuery.getResultList();
    }
}
