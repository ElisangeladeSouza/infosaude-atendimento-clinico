package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Pessoa;
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
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class PessoaDao extends DaoAbstrato<Pessoa> implements Serializable {

    private static final long serialVersionUID = 1L;

    public PessoaDao() {
        super(Pessoa.class);
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
