package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.FichaAtendimentoDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class FichaAtendimentoDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static FichaAtendimentoDao fichaAtendimentoDao;
    
    public FichaAtendimentoDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
       fichaAtendimentoDao = new FichaAtendimentoDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
       fichaAtendimentoDao.setEntityManager(entityManager);    
    }
    

    @Test (expected = Exception.class)
    public void testSalvarFichaAtendimentoNull() {

        FichaAtendimento fichaAtendimento = new FichaAtendimento();
        
       fichaAtendimentoDao.getEntityManager().getTransaction().begin();
       fichaAtendimentoDao.salvar(fichaAtendimento);
       fichaAtendimentoDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException{
        
        FichaAtendimento fichaAtendimento = new FichaAtendimento();
        
       fichaAtendimentoDao.buscarPorCampo(null,fichaAtendimento);
        
    }
    
    @Test
    public void testFindByIdInexistente() {

        FichaAtendimento fichaAtendimento = new FichaAtendimento();
        assertNull(fichaAtendimento = fichaAtendimentoDao.findById(0L));
    }
    
}
