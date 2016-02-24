package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.ContaDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Conta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class ContaDaoTest {

    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static ContaDao contaDao;
    private static DateTimeUtilBean dateTimeUtilBean;
    private static List<Conta> listaContas;
    private static Long id;

    public ContaDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        contaDao = new ContaDao();
        dateTimeUtilBean = new DateTimeUtilBean();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        contaDao.setEntityManager(entityManager);
    }

    @Test(expected = Exception.class)
    public void testSalvarContaNull() {

        Conta conta = new Conta();

        contaDao.getEntityManager().getTransaction().begin();
        contaDao.salvar(conta);
        contaDao.getEntityManager().getTransaction().commit();

    }

    @Test
    public void testSalvarContaCamposObrigatorios() {

        Conta conta = new Conta();

        conta.setPassword("default");
        conta.setUserName("default");
        conta.setEmail("default@gmail.com");
        conta.setUserRoles("Administradores");

        contaDao.getEntityManager().getTransaction().begin();
        contaDao.salvar(conta);
        contaDao.getEntityManager().getTransaction().commit();

        listaContas = (List<Conta>) new ArrayList<Conta>();
        listaContas = contaDao.findAll();

        for (Conta conta1 : listaContas) {

            if (conta1.getUserName().equals(conta.getUserName())) {
                id = conta1.getId();
            }
        }

        Conta novaConta = new Conta();
        novaConta = contaDao.findById(id);

        assertEquals(conta.getPassword(), novaConta.getPassword());
    }

    //Teste comentado para decisão junto com o administrador para resolução de regra de negócio
//    @Test(expected = Exception.class)
//    public void testSalvarContaDuplicada() {
//
//        Conta conta = new Conta();
//        
//        conta.setPassword("default1");
//        conta.setPermissao(Permissao.ADMIN);
//        conta.setUserName("default1");
//
//        contaDao.getEntityManager().getTransaction().begin();
//        contaDao.salvar(conta);
//        contaDao.getEntityManager().getTransaction().commit();
//        
//        contaDao.getEntityManager().getTransaction().begin();
//        contaDao.salvar(conta);
//        contaDao.getEntityManager().getTransaction().commit();
//
//    }
}
