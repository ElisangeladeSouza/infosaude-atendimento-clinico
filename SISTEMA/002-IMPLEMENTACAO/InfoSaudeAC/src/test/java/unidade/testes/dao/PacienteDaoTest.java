package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.PacienteDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Paciente;
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
public class PacienteDaoTest {

    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static PacienteDao pacienteDao;
    private static DateTimeUtilBean dateTimeUtilBean;
    private static List<Paciente> listaPacientes;
    private static Long id;

    /**
     *
     */
    public PacienteDaoTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        pacienteDao = new PacienteDao();
        dateTimeUtilBean = new DateTimeUtilBean();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        pacienteDao.setEntityManager(entityManager);
    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarPacienteNull() {

        Paciente paciente = new Paciente();

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

    }

    /**
     *
     */
    @Test
    public void testSalvarPacienteCamposObrigatorios() {

        Paciente paciente = new Paciente();

        paciente.setNome("PACIENTE SOBRENOME");
        paciente.setCpf("76167123802");
        paciente.setCartaoSus("898 0009 9999 5555");
        paciente.setEmail("paciente.sobrenome@domain.com");
        paciente.setCorOuRaca("");
        paciente.setEnderecoBairro("");
        paciente.setEnderecoCep("");
        paciente.setEnderecoCidade("");
        paciente.setEnderecoNumero("");
        paciente.setEnderecoRua("");
        paciente.setNomeDaMae("");
        paciente.setRg("");
        paciente.setTelefone1("");
        paciente.setTelefone2("");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

        listaPacientes = (List<Paciente>) new ArrayList<Paciente>();
        listaPacientes = pacienteDao.findAll();

        for (Paciente paciente1 : listaPacientes) {

            if (paciente1.getCpf().equals(paciente.getCpf())) {
                id = paciente1.getId();
            }
        }

        Paciente novoPaciente = new Paciente();
        novoPaciente = pacienteDao.findById(id);
        assertEquals(paciente.getCpf(), novoPaciente.getCpf());
    }

    /**
     *
     */
    @Test
    public void testSalvarPacienteTodosCampos() {

        Paciente paciente = new Paciente();

        paciente.setNome("PACIENTE I SOBRENOME");
        paciente.setCpf("12881768644");
        paciente.setCartaoSus("898 0010 9999 5555");
        paciente.setEmail("paciente.isobrenome@domain.com");
        paciente.setCorOuRaca("PARDA");
        paciente.setDataNascimento(dateTimeUtilBean.getDateToday());
        paciente.setEnderecoBairro("BAIRRO");
        paciente.setEnderecoCep("58500-000");
        paciente.setEnderecoCidade("MONTEIRO");
        paciente.setEnderecoEstado(Estados.PB);
        paciente.setEnderecoNumero("1");
        paciente.setEnderecoRua("DAS FLORES");
        paciente.setNomeDaMae("MAE PACIENTE");
        paciente.setRg("88555741-x");
        paciente.setTelefone1("(83)9988-7766");
        paciente.setTelefone2("(83)3305-0001");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

        listaPacientes = (List<Paciente>) new ArrayList<Paciente>();
        listaPacientes = pacienteDao.findAll();

        for (Paciente paciente1 : listaPacientes) {

            if (paciente1.getCpf().equals(paciente.getCpf())) {
                id = paciente1.getId();
            }
        }

        Paciente novoPaciente = new Paciente();
        novoPaciente = pacienteDao.findById(id);
        assertEquals(paciente.getCpf(), novoPaciente.getCpf());
    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarPacienteDuplicado() {

        Paciente paciente = new Paciente();

        paciente.setNome("PACIENTE II SOBRENOME");
        paciente.setCpf("16634372543");
        paciente.setCartaoSus("898 0011 9999 5555");
        paciente.setEmail("paciente.iisobrenome@domain.com");
        paciente.setCorOuRaca("PARDA");
        paciente.setDataNascimento(dateTimeUtilBean.getDateToday());
        paciente.setEnderecoBairro("BAIRRO");
        paciente.setEnderecoCep("58500-000");
        paciente.setEnderecoCidade("MONTEIRO");
        paciente.setEnderecoEstado(Estados.CE);
        paciente.setEnderecoNumero("1");
        paciente.setEnderecoRua("DAS FLORES");
        paciente.setNomeDaMae("MAE PACIENTE");
        paciente.setRg("88555741-x");
        paciente.setTelefone1("(83)9988-7766");
        paciente.setTelefone2("(83)3305-0001");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarPacienteNome() {

        Paciente paciente = new Paciente();

        paciente.setNome("PACIENTE III SOBRENOME");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarPacienteCpf() {

        Paciente paciente = new Paciente();

        paciente.setCpf("82086859848");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarPacienteSus() {

        Paciente paciente = new Paciente();

        paciente.setCartaoSus("898 0013 9999 5555");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarPacienteEmail() {

        Paciente paciente = new Paciente();

        paciente.setEmail("paciente.iiisobrenome@domain.com");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarPacienteNomeCpf() {

        Paciente paciente = new Paciente();

        paciente.setNome("PACIENTE IV SOBRENOME");
        paciente.setCpf("82086859848");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarPacienteCpfDuplicado() {

        Paciente paciente = new Paciente();
        Paciente novoPaciente = new Paciente();

        paciente.setNome("PACIENTE V SOBRENOME");
        paciente.setCpf("17407400253");
        paciente.setCartaoSus("898 0015 9999 5555");
        paciente.setEmail("paciente.iisobrenome@domain.com");

        novoPaciente.setNome("PACIENTE VI SOBRENOME");
        novoPaciente.setCpf("17407400253");
        novoPaciente.setCartaoSus("898 0016 9999 5555");
        novoPaciente.setEmail("paciente.xsobrenome@domain.com");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(novoPaciente);
        pacienteDao.getEntityManager().getTransaction().commit();
    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarPacienteSusDuplicado() {

        Paciente paciente = new Paciente();
        Paciente novoPaciente = new Paciente();

        paciente.setNome("PACIENTE VII SOBRENOME");
        paciente.setCpf("93951258292");
        paciente.setCartaoSus("898 0014 9999 5555");
        paciente.setEmail("paciente.iisobrenome@domain.com");

        novoPaciente.setNome("PACIENTE VIII SOBRENOME");
        novoPaciente.setCpf("42183667648");
        novoPaciente.setCartaoSus("898 0014 9999 5555");
        novoPaciente.setEmail("paciente.xsobrenome@domain.com");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(novoPaciente);
        pacienteDao.getEntityManager().getTransaction().commit();
    }

    /**
     *
     */
    @Test
    public void testSalvarCpfSusTodoSistema() {

        Paciente paciente = new Paciente();

        paciente.setNome("ENTIDADE IX SOBRENOME");
        paciente.setCpf("91184468680");
        paciente.setCartaoSus("898 2221 0121 9994");
        paciente.setEmail("entidade.sobrenome@domain.com");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();
    }

    /**
     *
     */
    @Test
    public void testFindAll() {

        Paciente paciente = new Paciente();

        paciente.setNome("PACIENTE X SOBRENOME");
        paciente.setCpf("32955257303");
        paciente.setCartaoSus("756 0000 0000 0020");
        paciente.setEmail("paciente.sobrenome@domain.com");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

        listaPacientes = (List<Paciente>) new ArrayList<Paciente>();
        listaPacientes = pacienteDao.findAll();

        assertFalse(0 == listaPacientes.size());
    }

    /**
     *
     */
    @Test
    public void testFindById() {

        Paciente paciente = new Paciente();

        paciente.setNome("PACIENTE XI SOBRENOME");
        paciente.setCpf("91528363710");
        paciente.setCartaoSus("756 0000 0000 0021");
        paciente.setEmail("paciente.sobrenome@domain.com");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

        listaPacientes = (List<Paciente>) new ArrayList<Paciente>();
        listaPacientes = pacienteDao.findAll();

        for (Paciente paciente1 : listaPacientes) {

            if (paciente1.getCpf().equals(paciente.getCpf())) {
                id = paciente1.getId();
            }
        }

        Paciente novoPaciente = new Paciente();
        novoPaciente = pacienteDao.findById(id);
        assertEquals(paciente.getCpf(), novoPaciente.getCpf());
    }

    /**
     *
     */
    @Test
    public void testFindByIdInexistente() {

        Paciente paciente = new Paciente();

        paciente.setNome("PACIENTE XII SOBRENOME");
        paciente.setCpf("53381477420");
        paciente.setCartaoSus("756 0000 0000 0022");
        paciente.setEmail("paciente.sobrenome@domain.com");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

        Paciente novoPaciente = new Paciente();

        assertNull(novoPaciente = pacienteDao.findById(0L));
    }

    /**
     *
     */
    @Test
    public void testDelete() {

        Paciente paciente = new Paciente();

        paciente.setNome("PACIENTE XIII SOBRENOME");
        paciente.setCpf("83225445452");
        paciente.setCartaoSus("756 0000 0000 0023");
        paciente.setEmail("paciente.sobrenome@domain.com");

        pacienteDao.getEntityManager().getTransaction().begin();
        pacienteDao.salvar(paciente);
        pacienteDao.getEntityManager().getTransaction().commit();

        listaPacientes = (List<Paciente>) new ArrayList<Paciente>();
        listaPacientes = pacienteDao.findAll();

        for (Paciente paciente1 : listaPacientes) {

            if (paciente1.getCpf().equals(paciente.getCpf())) {
                id = paciente1.getId();
                paciente = paciente1;
            }
        }
        pacienteDao.delete(paciente);

        assertNull(pacienteDao.findById(id));

    }
}
