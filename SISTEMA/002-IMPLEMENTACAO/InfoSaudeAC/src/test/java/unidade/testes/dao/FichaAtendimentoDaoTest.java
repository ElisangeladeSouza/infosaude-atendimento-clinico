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
 * Testes unitários da classe FichaAtendimentoDao.
 * 
 * @author wilde <wildearruda@gmail.com>
 */
public class FichaAtendimentoDaoTest {

    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static FichaAtendimentoDao fichaAtendimentoDao;

    public FichaAtendimentoDaoTest() {
    }

    /**
     * Antes da classe de testes iniciar a conexão com o banco de dados as
     * variáveis abaixo serão iniciadas e será creado o entity manager com a 
     * unidade de persistência do banco de testes hsqldb.
     */
    @BeforeClass
    public static void setUpClass() {

        fichaAtendimentoDao = new FichaAtendimentoDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        fichaAtendimentoDao.setEntityManager(entityManager);
    }

    /**
     * Método que testa se cadastro de FichaAtendimento está sendo salvo nulo. 
     * Caso isso aconteça uma exceção deve ser lançada.
     */
    @Test(expected = Exception.class)
    public void testSalvarFichaAtendimentoNull() {

        FichaAtendimento fichaAtendimento = new FichaAtendimento();

        fichaAtendimentoDao.getEntityManager().getTransaction().begin();
        fichaAtendimentoDao.salvar(fichaAtendimento);
        fichaAtendimentoDao.getEntityManager().getTransaction().commit();

    }

    /**
     * Método que testa a busca por um campo que está nulo.
     * Caso isso aconteça uma exceção deve ser lançada.
     * 
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException {

        FichaAtendimento fichaAtendimento = new FichaAtendimento();

        fichaAtendimentoDao.buscarPorCampo(null, fichaAtendimento);

    }

    /**
     * Método que testa a a busca de um registro com ID inexistente.
     */
    @Test
    public void testFindByIdInexistente() {

        FichaAtendimento fichaAtendimento = new FichaAtendimento();
        assertNull(fichaAtendimento = fichaAtendimentoDao.findById(0L));
    }
}
