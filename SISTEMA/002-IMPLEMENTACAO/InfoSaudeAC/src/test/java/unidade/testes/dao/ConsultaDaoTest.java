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
 * Testes unitários da classe ConsultaDao.
 * 
 * @author wilde <wildearruda@gmail.com>
 */
public class ConsultaDaoTest {

    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static ConsultaDao consultaDao;

    public ConsultaDaoTest() {
    }

    /**
     * Antes da classe de testes iniciar a conexão com o banco de dados as
     * variáveis abaixo serão iniciadas e será creado o entity manager com a 
     * unidade de persistência do banco de testes hsqldb.
     */
    @BeforeClass
    public static void setUpClass() {

        consultaDao = new ConsultaDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        consultaDao.setEntityManager(entityManager);
    }

    /**
     * Método que testa se cadastro de Consulta está sendo salvo nulo. 
     * Caso isso aconteça uma exceção deve ser lançada.
     */
    @Test(expected = Exception.class)
    public void testSalvarConsultaNull() {

        Consulta consulta = new Consulta();

        consultaDao.getEntityManager().getTransaction().begin();
        consultaDao.salvar(consulta);
        consultaDao.getEntityManager().getTransaction().commit();

    }

    /**
     * Método que testa a busca por um campo que está nulo.
     * Caso isso aconteça uma exceção deve ser lançada.
     * 
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException {

        Consulta consulta = new Consulta();

        consultaDao.buscarPorCampo(null, consulta);

    }

    /**
     * Método que testa a a busca de um registro com ID inexistente.
     */
    @Test
    public void testFindByIdInexistente() {

        Consulta consulta = new Consulta();
        assertNull(consulta = consultaDao.findById(0L));
    }
}
