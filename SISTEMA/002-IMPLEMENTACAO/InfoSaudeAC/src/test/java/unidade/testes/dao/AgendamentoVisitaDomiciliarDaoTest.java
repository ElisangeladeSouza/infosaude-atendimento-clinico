package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.AgendamentoVisitaDomiciliarDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.AgendamentoVisitaDomiciliar;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class AgendamentoVisitaDomiciliarDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static AgendamentoVisitaDomiciliarDao agendamentoVisitaDomiciliarDao;
    
    public AgendamentoVisitaDomiciliarDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        agendamentoVisitaDomiciliarDao = new AgendamentoVisitaDomiciliarDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        agendamentoVisitaDomiciliarDao.setEntityManager(entityManager);
    }
    
    @Test(expected = Exception.class)
    public void testSalvarAgendamentoVisitaDomiciliarNull() {
        
        AgendamentoVisitaDomiciliar agendamentoVisitaDomiciliar = new AgendamentoVisitaDomiciliar();
        
        agendamentoVisitaDomiciliarDao.getEntityManager().getTransaction().begin();
        agendamentoVisitaDomiciliarDao.salvar(agendamentoVisitaDomiciliar);
        agendamentoVisitaDomiciliarDao.getEntityManager().getTransaction().commit();
    }
    
    @Test(expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException {
        
        AgendamentoVisitaDomiciliar agendamentoVisitaDomiciliar = new AgendamentoVisitaDomiciliar();
        
        agendamentoVisitaDomiciliarDao.buscarPorCampo(null, agendamentoVisitaDomiciliar);
    }
    
    @Test
    public void testFindByIdInexistente() {
        AgendamentoVisitaDomiciliar agendamentoVisitaDomiciliar = new AgendamentoVisitaDomiciliar();
        
        assertNull(agendamentoVisitaDomiciliar = agendamentoVisitaDomiciliarDao.findById(0L));
    }
}
