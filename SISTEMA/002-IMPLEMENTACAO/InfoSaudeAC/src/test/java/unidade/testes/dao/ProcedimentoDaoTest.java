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
 * Testes unitários da classe ProcedimentoDao.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class ProcedimentoDaoTest {

    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static ProcedimentoDao procedimentoDao;

    public ProcedimentoDaoTest() {
    }

    /**
     * Antes da classe de testes iniciar a conexão com o banco de dados as
     * variáveis abaixo serão iniciadas e será creado o entity manager com a 
     * unidade de persistência do banco de testes hsqldb.
     */
    @BeforeClass
    public static void setUpClass() {
        procedimentoDao = new ProcedimentoDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        procedimentoDao.setEntityManager(entityManager);
    }

    /**
     * Método que testa se cadastro de Procedimento está sendo salvo nulo. 
     * Caso isso aconteça uma exceção deve ser lançada.
     */
    @Test(expected = Exception.class)
    public void testSalvarProcedimentoNull() {

        Procedimento procedimento = new Procedimento();

        procedimentoDao.getEntityManager().getTransaction().begin();
        procedimentoDao.salvar(procedimento);
        procedimentoDao.getEntityManager().getTransaction().commit();

    }

    /**
     * Método que testa a busca por um campo que está nulo.
     * Caso isso aconteça uma exceção deve ser lançada.
     * 
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException {

        Procedimento procedimento = new Procedimento();

        procedimentoDao.buscarPorCampo(null, procedimento);

    }

    /**
     * Método que testa a a busca de um registro com ID inexistente.
     */
    @Test
    public void testFindByIdInexistente() {

        Procedimento procedimento = new Procedimento();
        assertNull(procedimento = procedimentoDao.findById(0L));
    }
}
