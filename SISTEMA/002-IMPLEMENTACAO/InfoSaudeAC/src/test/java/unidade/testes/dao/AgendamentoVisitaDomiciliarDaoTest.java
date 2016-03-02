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
 * Testes unitários da classe AgendamentoVisitaDomiciliarDao.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class AgendamentoVisitaDomiciliarDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static AgendamentoVisitaDomiciliarDao agendamentoVisitaDomiciliarDao;
    
    public AgendamentoVisitaDomiciliarDaoTest() {
    }
    
    /**
     * Antes da classe de testes iniciar a conexão com o banco de dados as
     * variáveis abaixo serão iniciadas e será creado o entity manager com a 
     * unidade de persistência do banco de testes hsqldb.
     */
    @BeforeClass
    public static void setUpClass() {
        
        agendamentoVisitaDomiciliarDao = new AgendamentoVisitaDomiciliarDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        agendamentoVisitaDomiciliarDao.setEntityManager(entityManager);
    }
    
    /**
     * Método que testa se cadastro de AgendamentoVisitaDomiciliar está sendo 
     * salvo nulo. 
     * Caso isso aconteça uma exceção deve ser lançada.
     */
    @Test(expected = Exception.class)
    public void testSalvarAgendamentoVisitaDomiciliarNull() {
        
        AgendamentoVisitaDomiciliar agendamentoVisitaDomiciliar = new AgendamentoVisitaDomiciliar();
        
        agendamentoVisitaDomiciliarDao.getEntityManager().getTransaction().begin();
        agendamentoVisitaDomiciliarDao.salvar(agendamentoVisitaDomiciliar);
        agendamentoVisitaDomiciliarDao.getEntityManager().getTransaction().commit();
    }
    
    /**
     * Método que testa a busca por um campo que está nulo.
     * Caso isso aconteça uma exceção deve ser lançada.
     * 
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException {
        
        AgendamentoVisitaDomiciliar agendamentoVisitaDomiciliar = new AgendamentoVisitaDomiciliar();
        
        agendamentoVisitaDomiciliarDao.buscarPorCampo(null, agendamentoVisitaDomiciliar);
    }
    
    /**
     * Método que testa a a busca de um registro com ID inexistente.
     */
    @Test
    public void testFindByIdInexistente() {
        AgendamentoVisitaDomiciliar agendamentoVisitaDomiciliar = new AgendamentoVisitaDomiciliar();
        
        assertNull(agendamentoVisitaDomiciliar = agendamentoVisitaDomiciliarDao.findById(0L));
    }
}
