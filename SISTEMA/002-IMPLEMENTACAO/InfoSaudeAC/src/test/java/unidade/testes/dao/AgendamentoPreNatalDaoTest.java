package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.AgendamentoPreNatalDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.AgendamentoPreNatal;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com
 */
public class AgendamentoPreNatalDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static AgendamentoPreNatalDao agendamentoPreNatalDao;
    
    public AgendamentoPreNatalDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        agendamentoPreNatalDao = new AgendamentoPreNatalDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        agendamentoPreNatalDao.setEntityManager(entityManager);
    }
    
    @Test(expected = Exception.class)
    public void testSalvarAgendamentoPreNatalNull() {
        
        AgendamentoPreNatal agendamentoPreNatal = new AgendamentoPreNatal();
        
        agendamentoPreNatalDao.getEntityManager().getTransaction().begin();
        agendamentoPreNatalDao.salvar(agendamentoPreNatal);
        agendamentoPreNatalDao.getEntityManager().getTransaction().commit();
    }
    
    @Test(expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException {
        
        AgendamentoPreNatal agendamentoPreNatal = new AgendamentoPreNatal();
        
        agendamentoPreNatalDao.buscarPorCampo(null, agendamentoPreNatal);
    }
    
    @Test
    public void testFindByIdInexistente() {
        
        AgendamentoPreNatal agendamentoPreNatal = new AgendamentoPreNatal();
        assertNull(agendamentoPreNatal = agendamentoPreNatalDao.findById(0L));
    }
}
