package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.MedicoDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Medico;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class MedicoDaoTest {

    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static MedicoDao medicoDao;
    private static DateTimeUtilBean dateTimeUtilBean;
    private static List<Medico> listaMedicos;
    private static Long id;

    public MedicoDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        medicoDao = new MedicoDao();
        dateTimeUtilBean = new DateTimeUtilBean();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        medicoDao.setEntityManager(entityManager);
    }

    @Test(expected = Exception.class)
    public void testSalvarMedicoNull() {

        Medico medico = new Medico();

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

    }

    @Test
    public void testSalvarMedicoCamposObrigatorios() {

        Medico medico = new Medico();

        medico.setNome("MEDICO SOBRENOME");
        medico.setCpf("23676316380");
        medico.setCrm("17990");
        medico.setCartaoSus("898 2221 0121 0004");
        medico.setEmail("medico.sobrenome@domain.com");
        medico.setCorOuRaca("");
        medico.setEnderecoBairro("");
        medico.setEnderecoCep("");
        medico.setEnderecoCidade("");
        medico.setEnderecoNumero("");
        medico.setEnderecoRua("");
        medico.setRg("");
        medico.setTelefone1("");
        medico.setTelefone2("");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

        listaMedicos = (List<Medico>) new ArrayList<Medico>();
        listaMedicos = medicoDao.findAll();

        for (Medico medico1 : listaMedicos) {

            if (medico1.getCpf().equals(medico.getCpf())) {
                id = medico1.getId();
            }
        }

        Medico novoMedico = new Medico();
        novoMedico = medicoDao.findById(id);
        assertEquals(medico.getCpf(), novoMedico.getCpf());
    }

    @Test
    public void testSalvarMedicoTodosCampos() {

        Medico medico = new Medico();

        medico.setNome("MEDICO II SOBRENOME");
        medico.setCpf("12172667552");
        medico.setCrm("15987");
        medico.setCartaoSus("898 3301 0121 0009");
        medico.setEmail("medico.isobrenome@domain.com");
        medico.setCorOuRaca("PARDA");
        medico.setDataNascimento(dateTimeUtilBean.getDateToday());
        medico.setEnderecoBairro("BAIRRO");
        medico.setEnderecoCep("58500-000");
        medico.setEnderecoCidade("MONTEIRO");
        medico.setEnderecoEstado(Estados.PB);
        medico.setEnderecoNumero("1");
        medico.setEnderecoRua("DAS FLORES");
        medico.setRg("88555741-x");
        medico.setTelefone1("(83)9988-7766");
        medico.setTelefone2("(83)3305-0001");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

        listaMedicos = (List<Medico>) new ArrayList<Medico>();
        listaMedicos = medicoDao.findAll();

        for (Medico medico1 : listaMedicos) {

            if (medico1.getCpf().equals(medico.getCpf())) {
                id = medico1.getId();
            }
        }

        Medico novoMedico = new Medico();
        novoMedico = medicoDao.findById(id);
        assertEquals(medico.getCpf(), novoMedico.getCpf());
    }

    @Test(expected = Exception.class)
    public void testSalvarMedicoDuplicado() {

        Medico medico = new Medico();

        medico.setNome("MEDICO III SOBRENOME");
        medico.setCpf("52712865170");
        medico.setCrm("15789");
        medico.setCartaoSus("898 0001 2121 0099");
        medico.setEmail("medico.iisobrenome@domain.com");
        medico.setCorOuRaca("PARDA");
        medico.setDataNascimento(dateTimeUtilBean.getDateToday());
        medico.setEnderecoBairro("BAIRRO");
        medico.setEnderecoCep("58500-000");
        medico.setEnderecoCidade("MONTEIRO");
        medico.setEnderecoEstado(Estados.CE);
        medico.setEnderecoNumero("1");
        medico.setEnderecoRua("DAS FLORES");
        medico.setRg("88555741-x");
        medico.setTelefone1("(83)9988-7766");
        medico.setTelefone2("(83)3305-0001");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

    }

    @Test(expected = Exception.class)
    public void testSalvarMedicoNome() {

        Medico medico = new Medico();

        medico.setNome("MEDICO IV SOBRENOME");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

    }

    @Test(expected = Exception.class)
    public void testSalvarMedicoCpf() {

        Medico medico = new Medico();

        medico.setCpf("93730345451");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

    }

    @Test(expected = Exception.class)
    public void testSalvarMedicoCrm() {

        Medico medico = new Medico();

        medico.setCrm("15111");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

    }

    @Test(expected = Exception.class)
    public void testSalvarMedicoSus() {

        Medico medico = new Medico();

        medico.setCartaoSus("898 1101 0121 0099");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

    }

    @Test(expected = Exception.class)
    public void testSalvarMedicoEmail() {

        Medico medico = new Medico();

        medico.setEmail("medico.iiisobrenome@domain.com");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

    }

    @Test(expected = Exception.class)
    public void testSalvarMedicoNomeCpf() {

        Medico medico = new Medico();

        medico.setNome("MEDICO V SOBRENOME");
        medico.setCpf("85946691945");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

    }

    @Test(expected = Exception.class)
    public void testSalvarMedicoNomeCpfCrm() {

        Medico medico = new Medico();

        medico.setNome("MEDICO VI SOBRENOME");
        medico.setCpf("85946691945");
        medico.setCrm("15111");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

    }

    @Test(expected = Exception.class)
    public void testSalvarMedicoCpfDuplicado() {

        Medico medico = new Medico();
        Medico novoMedico = new Medico();

        medico.setNome("MEDICO VII SOBRENOME");
        medico.setCpf("67877347359");
        medico.setCrm("15789");
        medico.setCartaoSus("898 0451 0121 0099");
        medico.setEmail("medico.iisobrenome@domain.com");

        novoMedico.setNome("MEDICO VIII SOBRENOME");
        novoMedico.setCpf("67877347359");
        novoMedico.setCrm("15000");
        novoMedico.setCartaoSus("898 0071 0121 0901");
        novoMedico.setEmail("medico.xsobrenome@domain.com");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(novoMedico);
        medicoDao.getEntityManager().getTransaction().commit();
    }

    @Test(expected = Exception.class)
    public void testSalvarMedicoSusDuplicado() {

        Medico medico = new Medico();
        Medico novoMedico = new Medico();

        medico.setNome("MEDICO IX SOBRENOME");
        medico.setCpf("07246785736");
        medico.setCrm("15789");
        medico.setCartaoSus("700 0001 0121 0099");
        medico.setEmail("medico.iisobrenome@domain.com");

        novoMedico.setNome("MEDICO X SOBRENOME");
        novoMedico.setCpf("96331211403");
        novoMedico.setCrm("15000");
        novoMedico.setCartaoSus("700 0001 0121 0099");
        novoMedico.setEmail("medico.xsobrenome@domain.com");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(novoMedico);
        medicoDao.getEntityManager().getTransaction().commit();
    }

    @Test
    public void testSalvarCpfSusTodoSistema() {

        Medico medico = new Medico();

        medico.setNome("ENTIDADE X SOBRENOME");
        medico.setCpf("91184468680");
        medico.setCrm("17991");
        medico.setCartaoSus("898 2221 0121 9994");
        medico.setEmail("entidade.sobrenome@domain.com");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();
    }

    @Test
    public void testFindAll() {

        Medico medico = new Medico();

        medico.setNome("MEDICO XI SOBRENOME");
        medico.setCpf("27198569323");
        medico.setCrm("17996");
        medico.setCartaoSus("898 0099 0707 8778");
        medico.setEmail("medico.sobrenome@domain.com");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

        listaMedicos = (List<Medico>) new ArrayList<Medico>();
        listaMedicos = medicoDao.findAll();

        assertFalse(0 == listaMedicos.size());
    }

    @Test
    public void testFindById() {

        Medico medico = new Medico();

        medico.setNome("MEDICO XII SOBRENOME");
        medico.setCpf("50965876063");
        medico.setCrm("17997");
        medico.setCartaoSus("898 0099 0707 7887");
        medico.setEmail("medico.sobrenome@domain.com");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

        listaMedicos = (List<Medico>) new ArrayList<Medico>();
        listaMedicos = medicoDao.findAll();

        for (Medico medico1 : listaMedicos) {

            if (medico1.getCpf().equals(medico.getCpf())) {
                id = medico1.getId();
            }
        }

        Medico novoMedico = new Medico();
        novoMedico = medicoDao.findById(id);
        assertEquals(medico.getCpf(), novoMedico.getCpf());
    }

    @Test
    public void testFindByIdInexistente() {

        Medico medico = new Medico();

        medico.setNome("MEDICO XIII SOBRENOME");
        medico.setCpf("68843868438");
        medico.setCrm("17998");
        medico.setCartaoSus("898 9876 0707 7887");
        medico.setEmail("medico.sobrenome@domain.com");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

        Medico novoMedico = new Medico();

        assertNull(novoMedico = medicoDao.findById(0L));
    }

    @Test
    public void testDelete() {

        Medico medico = new Medico();

        medico.setNome("MEDICO XIV SOBRENOME");
        medico.setCpf("05982316920");
        medico.setCrm("17999");
        medico.setCartaoSus("898 1234 9999 9876");
        medico.setEmail("medico.sobrenome@domain.com");

        medicoDao.getEntityManager().getTransaction().begin();
        medicoDao.salvar(medico);
        medicoDao.getEntityManager().getTransaction().commit();

        listaMedicos = (List<Medico>) new ArrayList<Medico>();
        listaMedicos = medicoDao.findAll();

        for (Medico medico1 : listaMedicos) {

            if (medico1.getCpf().equals(medico.getCpf())) {
                id = medico1.getId();
                medico = medico1;
            }
        }
        medicoDao.delete(medico);

        assertNull(medicoDao.findById(id));

    }

}
