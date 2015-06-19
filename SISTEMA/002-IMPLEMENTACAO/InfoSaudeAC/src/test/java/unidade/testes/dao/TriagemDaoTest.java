package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.TriagemDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Triagem;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class TriagemDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static TriagemDao triagemDao;
    
    /**
     *
     */
    public TriagemDaoTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        
        triagemDao = new TriagemDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        triagemDao.setEntityManager(entityManager);    
    }
    
    /**
     *
     */
    @Test (expected = Exception.class)
    public void testSalvarTriagemNull() {

        Triagem triagem = new Triagem();
        
        triagemDao.getEntityManager().getTransaction().begin();
        triagemDao.salvar(triagem);
        triagemDao.getEntityManager().getTransaction().commit();
        
    }
    
    /**
     *
     * @throws UBSException
     */
    @Test (expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException{
        
        Triagem triagem = new Triagem();
        
        triagemDao.buscarPorCampo(null, triagem);
        
    }
    
    /**
     *
     */
    @Test
    public void testFindByIdInexistente() {

        Triagem triagem = new Triagem();
        assertNull(triagem = triagemDao.findById(0L));
    }
    
}
