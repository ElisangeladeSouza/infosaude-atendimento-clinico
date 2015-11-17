//package unidade.testes.dao;
//
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.EnfermeiroDao;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.EntityManager;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNull;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// *
// * @author wilde
// */
//public class EnfermeiroDaoTest {
//
//    private static EntityManagerProducer entityManagerProducer;
//    private static EntityManager entityManager;
//    private static EnfermeiroDao enfermeiroDao;
//    private static DateTimeUtilBean dateTimeUtilBean;
//    private static List<Enfermeiro> listaEnfermeiros;
//    private static Long id;
//
//    /**
//     *
//     */
//    public EnfermeiroDaoTest() {
//    }
//
//    /**
//     *
//     */
//    @BeforeClass
//    public static void setUpClass() {
//        enfermeiroDao = new EnfermeiroDao();
//        dateTimeUtilBean = new DateTimeUtilBean();
//        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
//        entityManager = entityManagerProducer.create();
//        enfermeiroDao.setEntityManager(entityManager);
//    }
//
//    /**
//     *
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarEnfermeiroNull() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testSalvarEnfermeiroCamposObrigatorios() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setNome("ENFERMEIRO SOBRENOME");
//        enfermeiro.setCpfEnfermeiro("55183270562");
//        enfermeiro.setCorenEnfermeiro("19000");
//        enfermeiro.setCartaoSusEnfermeiro("898 1001 0121 0004");
//        enfermeiro.setEmail("enfermeiro.sobrenome@domain.com");
//        enfermeiro.setCorOuRaca("");
//        enfermeiro.setEnderecoBairro("");
//        enfermeiro.setEnderecoCep("");
//        enfermeiro.setEnderecoCidade("");
//        enfermeiro.setEnderecoNumero("");
//        enfermeiro.setEnderecoRua("");
//        enfermeiro.setRg("");
//        enfermeiro.setTelefone1("");
//        enfermeiro.setTelefone2("");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//        listaEnfermeiros = (List<Enfermeiro>) new ArrayList<Enfermeiro>();
//        listaEnfermeiros = enfermeiroDao.findAll();
//
//        for (Enfermeiro enfermeiro1 : listaEnfermeiros) {
//
//            if (enfermeiro1.getCpfEnfermeiro().equals(enfermeiro.getCpfEnfermeiro())) {
//                id = enfermeiro1.getId();
//            }
//        }
//
//        Enfermeiro novoEnfermeiro = new Enfermeiro();
//        novoEnfermeiro = enfermeiroDao.findById(id);
//
//        assertEquals(enfermeiro.getCpfEnfermeiro(), novoEnfermeiro.getCpfEnfermeiro());
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testSalvarEnfermeiroTodosCampos() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setNome("ENFERMEIRO I SOBRENOME");
//        enfermeiro.setCpfEnfermeiro("30257622411");
//        enfermeiro.setCorenEnfermeiro("15987");
//        enfermeiro.setCartaoSusEnfermeiro("898 0101 0121 0009");
//        enfermeiro.setEmail("enfermeiro.isobrenome@domain.com");
//        enfermeiro.setCorOuRaca("PARDA");
//        enfermeiro.setDataNascimento(dateTimeUtilBean.getDateToday());
//        enfermeiro.setEnderecoBairro("BAIRRO");
//        enfermeiro.setEnderecoCep("58500-000");
//        enfermeiro.setEnderecoCidade("MONTEIRO");
//        enfermeiro.setEnderecoEstado(Estados.PB);
//        enfermeiro.setEnderecoNumero("1");
//        enfermeiro.setEnderecoRua("DAS FLORES");
//        enfermeiro.setRg("88555741-x");
//        enfermeiro.setTelefone1("(83)9988-7766");
//        enfermeiro.setTelefone2("(83)3305-0001");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//        listaEnfermeiros = (List<Enfermeiro>) new ArrayList<Enfermeiro>();
//        listaEnfermeiros = enfermeiroDao.findAll();
//
//        for (Enfermeiro enfermeiro1 : listaEnfermeiros) {
//
//            if (enfermeiro1.getCpfEnfermeiro().equals(enfermeiro.getCpfEnfermeiro())) {
//                id = enfermeiro1.getId();
//            }
//        }
//
//        Enfermeiro novoEnfermeiro = new Enfermeiro();
//        novoEnfermeiro = enfermeiroDao.findById(id);
//
//        assertEquals(enfermeiro.getCpfEnfermeiro(), novoEnfermeiro.getCpfEnfermeiro());
//    }
//
//    /**
//     *
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarEnfermeiroDuplicado() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setNome("ENFERMEIRO II SOBRENOME");
//        enfermeiro.setCpfEnfermeiro("46557147862");
//        enfermeiro.setCorenEnfermeiro("15789");
//        enfermeiro.setCartaoSusEnfermeiro("898 0011 0121 0099");
//        enfermeiro.setEmail("enfermeiro.iisobrenome@domain.com");
//        enfermeiro.setCorOuRaca("PARDA");
//        enfermeiro.setDataNascimento(dateTimeUtilBean.getDateToday());
//        enfermeiro.setEnderecoBairro("BAIRRO");
//        enfermeiro.setEnderecoCep("58500-000");
//        enfermeiro.setEnderecoCidade("MONTEIRO");
//        enfermeiro.setEnderecoEstado(Estados.CE);
//        enfermeiro.setEnderecoNumero("1");
//        enfermeiro.setEnderecoRua("DAS FLORES");
//        enfermeiro.setRg("88555741-x");
//        enfermeiro.setTelefone1("(83)9988-7766");
//        enfermeiro.setTelefone2("(83)3305-0001");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     *
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarEnfermeiroNome() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setNome("ENFERMEIRO III SOBRENOME");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     *
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarEnfermeiroCpf() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setCpfEnfermeiro("13261684798");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     *
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarEnfermeiroCoren() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setCorenEnfermeiro("15111");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     *
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarEnfermeiroSus() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setCartaoSusEnfermeiro("898 0002 0121 0099");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     *
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarEnfermeiroEmail() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setEmail("enfermeiro.iiisobrenome@domain.com");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     *
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarEnfermeiroNomeCpf() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setNome("ENFERMEIRO IV SOBRENOME");
//        enfermeiro.setCpfEnfermeiro("13261684798");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     *
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarEnfermeiroNomeCpfCoren() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setNome("ENFERMEIRO V SOBRENOME");
//        enfermeiro.setCpfEnfermeiro("13261684798");
//        enfermeiro.setCorenEnfermeiro("15111");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     *
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarEnfermeiroCpfDuplicado() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//        Enfermeiro novoEnfermeiro = new Enfermeiro();
//
//        enfermeiro.setNome("ENFERMEIRO VI SOBRENOME");
//        enfermeiro.setCpfEnfermeiro("83381631632");
//        enfermeiro.setCorenEnfermeiro("15789");
//        enfermeiro.setCartaoSusEnfermeiro("898 0001 0121 0099");
//        enfermeiro.setEmail("enfermeiro.iisobrenome@domain.com");
//
//        novoEnfermeiro.setNome("ENFERMEIRO X SOBRENOME");
//        novoEnfermeiro.setCpfEnfermeiro("83381631632");
//        novoEnfermeiro.setCorenEnfermeiro("15000");
//        novoEnfermeiro.setCartaoSusEnfermeiro("898 0001 0121 0901");
//        novoEnfermeiro.setEmail("enfermeiro.xsobrenome@domain.com");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(novoEnfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     *
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarEnfermeiroSusDuplicado() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//        Enfermeiro novoEnfermeiro = new Enfermeiro();
//
//        enfermeiro.setNome("ENFERMEIRO VII SOBRENOME");
//        enfermeiro.setCpfEnfermeiro("03545217302");
//        enfermeiro.setCorenEnfermeiro("15789");
//        enfermeiro.setCartaoSusEnfermeiro("898 0001 1121 0099");
//        enfermeiro.setEmail("enfermeiro.iisobrenome@domain.com");
//
//        novoEnfermeiro.setNome("ENFERMEIRO VIII SOBRENOME");
//        novoEnfermeiro.setCpfEnfermeiro("13556845440");
//        novoEnfermeiro.setCorenEnfermeiro("15000");
//        novoEnfermeiro.setCartaoSusEnfermeiro("898 0001 1121 0099");
//        novoEnfermeiro.setEmail("enfermeiro.xsobrenome@domain.com");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(novoEnfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testSalvarCpfSusTodoSistema() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setNome("ENTIDADE IX SOBRENOME");
//        enfermeiro.setCpfEnfermeiro("91184468680");
//        enfermeiro.setCorenEnfermeiro("19987");
//        enfermeiro.setCartaoSusEnfermeiro("898 2221 0121 9994");
//        enfermeiro.setEmail("entidade.sobrenome@domain.com");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testFindAll() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setNome("ENFERMEIRO X SOBRENOME");
//        enfermeiro.setCpfEnfermeiro("03782681398");
//        enfermeiro.setCorenEnfermeiro("16000");
//        enfermeiro.setCartaoSusEnfermeiro("756 0000 0000 1010");
//        enfermeiro.setEmail("enfermeiro.sobrenome@domain.com");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//        listaEnfermeiros = (List<Enfermeiro>) new ArrayList<Enfermeiro>();
//        listaEnfermeiros = enfermeiroDao.findAll();
//
//        assertFalse(0 == listaEnfermeiros.size());
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testFindById() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setNome("ENFERMEIRO XI SOBRENOME");
//        enfermeiro.setCpfEnfermeiro("44198144540");
//        enfermeiro.setCorenEnfermeiro("16001");
//        enfermeiro.setCartaoSusEnfermeiro("756 0000 0000 1011");
//        enfermeiro.setEmail("enfermeiro.sobrenome@domain.com");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//        listaEnfermeiros = (List<Enfermeiro>) new ArrayList<Enfermeiro>();
//        listaEnfermeiros = enfermeiroDao.findAll();
//
//        for (Enfermeiro enfermeiro1 : listaEnfermeiros) {
//
//            if (enfermeiro1.getCpfEnfermeiro().equals(enfermeiro.getCpfEnfermeiro())) {
//                id = enfermeiro1.getId();
//            }
//        }
//
//        Enfermeiro novoEnfermeiro = new Enfermeiro();
//        novoEnfermeiro = enfermeiroDao.findById(id);
//        assertEquals(enfermeiro.getCpfEnfermeiro(), novoEnfermeiro.getCpfEnfermeiro());
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testFindByIdInexistente() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setNome("ENFERMEIRO XII SOBRENOME");
//        enfermeiro.setCpfEnfermeiro("70128316772");
//        enfermeiro.setCorenEnfermeiro("16002");
//        enfermeiro.setCartaoSusEnfermeiro("756 0000 0000 1012");
//        enfermeiro.setEmail("enfermeiro.sobrenome@domain.com");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//        Enfermeiro novoEnfermeiro = new Enfermeiro();
//
//        assertNull(novoEnfermeiro = enfermeiroDao.findById(0L));
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testDelete() {
//
//        Enfermeiro enfermeiro = new Enfermeiro();
//
//        enfermeiro.setNome("ENFERMEIRO XIII SOBRENOME");
//        enfermeiro.setCpfEnfermeiro("63434855033");
//        enfermeiro.setCorenEnfermeiro("16003");
//        enfermeiro.setCartaoSusEnfermeiro("756 0000 0000 1013");
//        enfermeiro.setEmail("enfermeiro.sobrenome@domain.com");
//
//        enfermeiroDao.getEntityManager().getTransaction().begin();
//        enfermeiroDao.salvar(enfermeiro);
//        enfermeiroDao.getEntityManager().getTransaction().commit();
//
//        listaEnfermeiros = (List<Enfermeiro>) new ArrayList<Enfermeiro>();
//        listaEnfermeiros = enfermeiroDao.findAll();
//
//        for (Enfermeiro enfermeiro1 : listaEnfermeiros) {
//
//            if (enfermeiro1.getCpfEnfermeiro().equals(enfermeiro.getCpfEnfermeiro())) {
//                id = enfermeiro1.getId();
//                enfermeiro = enfermeiro1;
//            }
//        }
//        enfermeiroDao.delete(enfermeiro);
//
//        assertNull(enfermeiroDao.findById(id));
//
//    }
//
//}
