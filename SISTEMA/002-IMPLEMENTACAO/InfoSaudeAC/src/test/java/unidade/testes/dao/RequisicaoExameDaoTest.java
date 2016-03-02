package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.RequisicaoExameDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.RequisicaoExame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Testes unitários da classe RequisicaoExameDao.
 * 
 * @author wilde <wildearruda@gmail.com> 
 */
public class RequisicaoExameDaoTest {

    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static RequisicaoExameDao requisicaoExameDao;

    public RequisicaoExameDaoTest() {
    }

    /**
     * Antes da classe de testes iniciar a conexão com o banco de dados as
     * variáveis abaixo serão iniciadas e será creado o entity manager com a 
     * unidade de persistência do banco de testes hsqldb.
     */
    @BeforeClass
    public static void setUpClass() {

        requisicaoExameDao = new RequisicaoExameDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        requisicaoExameDao.setEntityManager(entityManager);
    }

    /**
     * Método que testa a busca por um campo que está nulo.
     * Caso isso aconteça uma exceção deve ser lançada.
     * 
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testBuscarPorCampoNull() throws UBSException {

        RequisicaoExame requisicaoExame = new RequisicaoExame();

        requisicaoExameDao.buscarPorCampo(null, requisicaoExame);

    }

    /**
     * Método que testa se RequisiccaoExame está salvando uma lista de exames.
     */
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
     * Método que testa a a busca de um registro com ID inexistente.
     */
    @Test
    public void testFindByIdInexistente() {

        RequisicaoExame requisicaoExame = new RequisicaoExame();
        assertNull(requisicaoExame = requisicaoExameDao.findById(0L));
    }

}
