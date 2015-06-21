package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.ProcedimentoDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Procedimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author elisangela
 */
public class ProcedimentoDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static ProcedimentoDao procedimentoDao;

    public ProcedimentoDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        procedimentoDao = new ProcedimentoDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        procedimentoDao.setEntityManager(entityManager);
    }
    
    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarProcedimentoNull() {

        Procedimento procedimento = new Procedimento();

        procedimentoDao.getEntityManager().getTransaction().begin();
        procedimentoDao.salvar(procedimento);
        procedimentoDao.getEntityManager().getTransaction().commit();

    }
    
    /**
     *
     * @throws UBSException
     */
    @Test (expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException{
        
        Procedimento procedimento = new Procedimento();
        
        procedimentoDao.buscarPorCampo(null, procedimento);
        
    }
    
    /**
     *
     */
    @Test
    public void testFindByIdInexistente() {

        Procedimento procedimento = new Procedimento();
        assertNull(procedimento = procedimentoDao.findById(0L));
    }
    
}
