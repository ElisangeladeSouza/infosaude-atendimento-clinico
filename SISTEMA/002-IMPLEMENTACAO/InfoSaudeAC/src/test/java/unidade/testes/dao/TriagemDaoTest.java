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
 * Testes unitários da classe TriagemDao.
 * 
 * @author wilde <wildearruda@gmail.com>
 */
public class TriagemDaoTest {

    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static TriagemDao triagemDao;

    public TriagemDaoTest() {
    }

    /**
     * Antes da classe de testes iniciar a conexão com o banco de dados as
     * variáveis abaixo serão iniciadas e será creado o entity manager com a 
     * unidade de persistência do banco de testes hsqldb.
     */
    @BeforeClass
    public static void setUpClass() {

        triagemDao = new TriagemDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        triagemDao.setEntityManager(entityManager);
    }

    /**
     * Método que testa se cadastro de Triagem está sendo salvo nulo. 
     * Caso isso aconteça uma exceção deve ser lançada.
     */
    @Test(expected = Exception.class)
    public void testSalvarTriagemNull() {

        Triagem triagem = new Triagem();

        triagemDao.getEntityManager().getTransaction().begin();
        triagemDao.salvar(triagem);
        triagemDao.getEntityManager().getTransaction().commit();

    }

    /**
     * Método que testa a busca por um campo que está nulo.
     * Caso isso aconteça uma exceção deve ser lançada.
     * 
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException {

        Triagem triagem = new Triagem();

        triagemDao.buscarPorCampo(null, triagem);

    }

    /**
     * Método que testa a a busca de um registro com ID inexistente.
     */
    @Test
    public void testFindByIdInexistente() {

        Triagem triagem = new Triagem();
        assertNull(triagem = triagemDao.findById(0L));
    }
}
