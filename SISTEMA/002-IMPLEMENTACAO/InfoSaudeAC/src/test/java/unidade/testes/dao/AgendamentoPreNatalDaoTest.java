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
 * Testes unitários da classe AgendamentoPreNatal.
 * 
 * @author elisangela <elysangeladesouza@gmail.com
 */
public class AgendamentoPreNatalDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static AgendamentoPreNatalDao agendamentoPreNatalDao;
    
    public AgendamentoPreNatalDaoTest() {
    }
    
    /**
     * Antes da classe de testes iniciar a conexão com o banco de dados as
     * variáveis abaixo serão iniciadas e será creado o entity manager com a 
     * unidade de persistência do banco de testes hsqldb.
     */
    @BeforeClass
    public static void setUpClass() {
        
        agendamentoPreNatalDao = new AgendamentoPreNatalDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        agendamentoPreNatalDao.setEntityManager(entityManager);
    }
    
    /**
     * Método que testa se cadastro de AgendamentoPreNatal está sendo salvo nulo. 
     * Caso isso aconteça uma exceção deve ser lançada.
     */
    @Test(expected = Exception.class)
    public void testSalvarAgendamentoPreNatalNull() {
        
        AgendamentoPreNatal agendamentoPreNatal = new AgendamentoPreNatal();
        
        agendamentoPreNatalDao.getEntityManager().getTransaction().begin();
        agendamentoPreNatalDao.salvar(agendamentoPreNatal);
        agendamentoPreNatalDao.getEntityManager().getTransaction().commit();
    }
    
    /**
     * Método que testa a busca por um campo que está nulo.
     * Caso isso aconteça uma exceção deve ser lançada.
     * 
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException {
        
        AgendamentoPreNatal agendamentoPreNatal = new AgendamentoPreNatal();
        
        agendamentoPreNatalDao.buscarPorCampo(null, agendamentoPreNatal);
    }
    
    /**
     * Método que testa a a busca de um registro com ID inexistente.
     */
    @Test
    public void testFindByIdInexistente() {
        
        AgendamentoPreNatal agendamentoPreNatal = new AgendamentoPreNatal();
        assertNull(agendamentoPreNatal = agendamentoPreNatalDao.findById(0L));
    }
}
