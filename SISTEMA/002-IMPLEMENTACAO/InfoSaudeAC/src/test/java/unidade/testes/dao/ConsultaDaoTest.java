package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.ConsultaDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Consulta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class ConsultaDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static ConsultaDao consultaDao;
    
    public ConsultaDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        consultaDao = new ConsultaDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        consultaDao.setEntityManager(entityManager);    
    }
    

    @Test (expected = Exception.class)
    public void testSalvarConsultaNull() {

        Consulta consulta = new Consulta();
        
        consultaDao.getEntityManager().getTransaction().begin();
        consultaDao.salvar(consulta);
        consultaDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException{
        
        Consulta consulta = new Consulta();
        
        consultaDao.buscarPorCampo(null, consulta);
        
    }
    
    @Test
    public void testFindByIdInexistente() {

        Consulta consulta = new Consulta();
        assertNull(consulta = consultaDao.findById(0L));
    }
    
}
