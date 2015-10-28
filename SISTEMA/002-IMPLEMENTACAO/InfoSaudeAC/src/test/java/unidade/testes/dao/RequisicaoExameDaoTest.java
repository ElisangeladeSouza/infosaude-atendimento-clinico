package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.RequisicaoExameDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.RequisicaoExame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class RequisicaoExameDaoTest {

    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static RequisicaoExameDao requisicaoExameDao;

    /**
     *
     */
    public RequisicaoExameDaoTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {

        requisicaoExameDao = new RequisicaoExameDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        requisicaoExameDao.setEntityManager(entityManager);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException {

        RequisicaoExame requisicaoExame = new RequisicaoExame();

        requisicaoExameDao.buscarPorCampo(null, requisicaoExame);

    }

    @Test
    public void testSave() {

        Exame exame = new Exame();

        exame.setId(1L);

        List listaExames = new ArrayList();
        listaExames.add(exame);
        List listaRequisicaoExames = new ArrayList();

        RequisicaoExame requisicaoExame = new RequisicaoExame();
        requisicaoExame.setExames(listaExames);

        requisicaoExameDao.getEntityManager().getTransaction().begin();
        requisicaoExameDao.salvar(requisicaoExame);
        requisicaoExameDao.getEntityManager().getTransaction().commit();

        listaRequisicaoExames = requisicaoExameDao.findAll();

        assertFalse(listaRequisicaoExames.isEmpty());

    }

    /**
     *
     */
    @Test
    public void testFindByIdInexistente() {

        RequisicaoExame requisicaoExame = new RequisicaoExame();
        assertNull(requisicaoExame = requisicaoExameDao.findById(0L));
    }

}
