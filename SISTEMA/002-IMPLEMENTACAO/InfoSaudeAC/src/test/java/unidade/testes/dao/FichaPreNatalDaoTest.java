package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.FichaPreNatalDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaPreNatal;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Testes unitários da classe FichaPreNatalDao.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class FichaPreNatalDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static FichaPreNatalDao fichaPreNatalDao;
    
    public FichaPreNatalDaoTest() {
    }
    
    /**
     * Antes da classe de testes iniciar a conexão com o banco de dados as
     * variáveis abaixo serão iniciadas e será creado o entity manager com a 
     * unidade de persistência do banco de testes hsqldb.
     */
    @BeforeClass
    public static void setUpClass() {
        
        fichaPreNatalDao = new FichaPreNatalDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        fichaPreNatalDao.setEntityManager(entityManager);
    }
    
    /**
     * Método que testa se cadastro de FichaPreNatal está sendo salvo nulo. 
     * Caso isso aconteça uma exceção deve ser lançada.
     */
    @Test(expected = Exception.class)
    public void testSalvarFichaPreNatalNull() {
        
        FichaPreNatal fichaPreNatal = new FichaPreNatal();
        
        fichaPreNatalDao.getEntityManager().getTransaction().begin();
        fichaPreNatalDao.salvar(fichaPreNatal);
        fichaPreNatalDao.getEntityManager().getTransaction().commit();
    }
    
    /**
     * Método que testa a busca por um campo que está nulo.
     * Caso isso aconteça uma exceção deve ser lançada.
     * 
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException {
        
        FichaPreNatal fichaPreNatal = new FichaPreNatal();
        
        fichaPreNatalDao.buscarPorCampo(null, fichaPreNatal);
    }
    
    /**
     * Método que testa a a busca de um registro com ID inexistente.
     */
    @Test
    public void testFindByIdInexistente() {
        FichaPreNatal fichaPreNatal = new FichaPreNatal();
        
        assertNull(fichaPreNatal = fichaPreNatalDao.findById(0L));
    }
    
}
