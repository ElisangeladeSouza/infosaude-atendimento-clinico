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
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class FichaPreNatalDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static FichaPreNatalDao fichaPreNatalDao;
    
    public FichaPreNatalDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        fichaPreNatalDao = new FichaPreNatalDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        fichaPreNatalDao.setEntityManager(entityManager);
    }
    
    @Test(expected = Exception.class)
    public void testSalvarFichaPreNatalNull() {
        
        FichaPreNatal fichaPreNatal = new FichaPreNatal();
        
        fichaPreNatalDao.getEntityManager().getTransaction().begin();
        fichaPreNatalDao.salvar(fichaPreNatal);
        fichaPreNatalDao.getEntityManager().getTransaction().commit();
    }
    
    @Test(expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException {
        
        FichaPreNatal fichaPreNatal = new FichaPreNatal();
        
        fichaPreNatalDao.buscarPorCampo(null, fichaPreNatal);
    }
    
    @Test
    public void testFindByIdInexistente() {
        FichaPreNatal fichaPreNatal = new FichaPreNatal();
        
        assertNull(fichaPreNatal = fichaPreNatalDao.findById(0L));
    }
    
}
