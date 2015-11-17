//package unidade.testes.dao;
//
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.PessoaDao;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Pessoa;
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
// * @author elisangela
// */
//public class PessoaDaoTest {
//
//    private static EntityManagerProducer entityManagerProducer;
//    private static EntityManager entityManager;
//    private static PessoaDao pessoaDao;
//    private static DateTimeUtilBean dateTimeUtilBean;
//    private static List<Pessoa> listaPessoas;
//    private static Long id;
//
//    /**
//     *
//     */
//    public PessoaDaoTest() {
//    }
//
//    /**
//     *
//     */
//    @BeforeClass
//    public static void setUpClass() {
//        pessoaDao = new PessoaDao();
//        dateTimeUtilBean = new DateTimeUtilBean();
//        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
//        entityManager = entityManagerProducer.create();
//        pessoaDao.setEntityManager(entityManager);
//
//    }
//
//    /**
//     *
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarPessoaNull() {
//        Pessoa pessoa = new Pessoa();
//
//        pessoaDao.getEntityManager().getTransaction().begin();
//        pessoaDao.salvar(pessoa);
//        pessoaDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testSalvarPessoaCamposObrigatorios() {
//        Pessoa pessoa = new Pessoa();
//
//        pessoa.setNome("Jon Snow");
//        pessoa.setEmail("snow@gmail.com");
//        pessoa.setCorOuRaca("");
//        pessoa.setEnderecoBairro("");
//        pessoa.setEnderecoCep("");
//        pessoa.setEnderecoCidade("");
//        pessoa.setEnderecoNumero("");
//        pessoa.setEnderecoRua("");
//        pessoa.setRg("");
//        pessoa.setTelefone1("");
//        pessoa.setTelefone2("");
//
//        pessoaDao.getEntityManager().getTransaction().begin();
//        pessoaDao.salvar(pessoa);
//        pessoaDao.getEntityManager().getTransaction().commit();
//
//        listaPessoas = (List<Pessoa>) new ArrayList<Pessoa>();
//        listaPessoas = pessoaDao.findAll();
//
//        for (Pessoa pessoa1 : listaPessoas) {
//            if (pessoa1.getNome().equals(pessoa.getNome())) {
//                id = pessoa1.getId();
//            }
//        }
//
//        Pessoa novaPessoa = new Pessoa();
//        novaPessoa = pessoaDao.findById(id);
//
//        assertEquals(pessoa.getNome(), novaPessoa.getNome());
//
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testSalvarPessoaTodosCampos() {
//        Pessoa pessoa = new Pessoa();
//
//        pessoa.setNome("Maria Rita");
//        pessoa.setEmail("rita@gmail.com");
//        pessoa.setCorOuRaca("Branca");
//        pessoa.setEnderecoBairro("Centro");
//        pessoa.setEnderecoCep("58500-000");
//        pessoa.setEnderecoCidade("Monteiro");
//        pessoa.setEnderecoNumero("239");
//        pessoa.setEnderecoRua("Rua Dom Pedro II");
//        pessoa.setRg("9710264");
//        pessoa.setTelefone1("(83) 999371638");
//        pessoa.setTelefone2("(83) 999811986");
//
//        pessoaDao.getEntityManager().getTransaction().begin();
//        pessoaDao.salvar(pessoa);
//        pessoaDao.getEntityManager().getTransaction().commit();
//
//        listaPessoas = (List<Pessoa>) new ArrayList<Pessoa>();
//        listaPessoas = pessoaDao.findAll();
//
//        for (Pessoa pessoa1 : listaPessoas) {
//            if (pessoa1.getNome().equals(pessoa.getNome())) {
//                id = pessoa1.getId();
//            }
//        }
//
//        Pessoa novaPessoa = new Pessoa();
//        novaPessoa = pessoaDao.findById(id);
//
//        assertEquals(pessoa.getNome(), novaPessoa.getNome());
//    }
//
//    /**
//     *
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarPessoaEmail() {
//
//        Pessoa pessoa = new Pessoa();
//
//        pessoa.setEmail("miguel@gmail.com");
//
//        pessoaDao.getEntityManager().getTransaction().begin();
//        pessoaDao.salvar(pessoa);
//        pessoaDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testFindAll() {
//        Pessoa pessoa = new Pessoa();
//
//        pessoa.setNome("Pedro Henrique");
//        pessoa.setEmail("pedrinho@gmail.com");
//        pessoa.setCorOuRaca("NEGRA");
//        pessoa.setEnderecoBairro("Bela Vista");
//        pessoa.setEnderecoCep("01311-000");
//        pessoa.setEnderecoCidade("São Paulo");
//        pessoa.setEnderecoNumero("1402");
//        pessoa.setEnderecoRua("Av. Paulista");
//        pessoa.setRg("0948572");
//        pessoa.setTelefone1("(41) 994893718");
//        pessoa.setTelefone2("(41) 380289317");
//
//        pessoaDao.getEntityManager().getTransaction().begin();
//        pessoaDao.salvar(pessoa);
//        pessoaDao.getEntityManager().getTransaction().commit();
//
//        listaPessoas = (List<Pessoa>) new ArrayList<Pessoa>();
//        listaPessoas = pessoaDao.findAll();
//
//        for (Pessoa pessoa1 : listaPessoas) {
//            if (pessoa1.getNome().equals(pessoa.getNome())) {
//                id = pessoa1.getId();
//            }
//        }
//
//        Pessoa novaPessoa = new Pessoa();
//        novaPessoa = pessoaDao.findById(id);
//
//        assertFalse(0 == listaPessoas.size());
//
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testFindById() {
//        Pessoa pessoa = new Pessoa();
//
//        pessoa.setNome("Cássio Oliveira");
//        pessoa.setEmail("cassioliveira@gmail.com");
//        pessoa.setCorOuRaca("BRANCA");
//        pessoa.setEnderecoBairro("Várzea");
//        pessoa.setEnderecoCep("56580-000");
//        pessoa.setEnderecoCidade("Sumé");
//        pessoa.setEnderecoNumero("02");
//        pessoa.setEnderecoRua("Av. Treze de Maio");
//        pessoa.setRg("9825672");
//        pessoa.setTelefone1("(83) 999783624");
//        pessoa.setTelefone2("(41) 999129645");
//
//        pessoaDao.getEntityManager().getTransaction().begin();
//        pessoaDao.salvar(pessoa);
//        pessoaDao.getEntityManager().getTransaction().commit();
//
//        listaPessoas = (List<Pessoa>) new ArrayList<Pessoa>();
//        listaPessoas = pessoaDao.findAll();
//
//        for (Pessoa pessoa1 : listaPessoas) {
//            if (pessoa1.getNome().equals(pessoa.getNome())) {
//                id = pessoa1.getId();
//            }
//        }
//
//        Pessoa novaPessoa = new Pessoa();
//        novaPessoa = pessoaDao.findById(id);
//
//        assertEquals(pessoa.getNome(), novaPessoa.getNome());
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testFindByIdInexistente() {
//        Pessoa pessoa = new Pessoa();
//
//        pessoa.setNome("Adalgiza Maranhão");
//        pessoa.setEmail("adalgiza@gmail.com");
//        pessoa.setCorOuRaca("NEGRA");
//        pessoa.setEnderecoBairro("Moéma");
//        pessoa.setEnderecoCep("1340-000");
//        pessoa.setEnderecoCidade("São Paulo");
//        pessoa.setEnderecoNumero("0276");
//        pessoa.setEnderecoRua("Av. Garrastazu Médici");
//        pessoa.setRg("2814278");
//        pessoa.setTelefone1("(41) 836475869");
//        pessoa.setTelefone2("(41) 920456573");
//
//        pessoaDao.getEntityManager().getTransaction().begin();
//        pessoaDao.salvar(pessoa);
//        pessoaDao.getEntityManager().getTransaction().commit();
//
//        Pessoa novaPessoa = new Pessoa();
//
//        assertNull(novaPessoa = pessoaDao.findById(0L));
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testDelete() {
//        Pessoa pessoa = new Pessoa();
//
//        pessoa.setNome("Ricardo");
//        pessoa.setEmail("ricardo@gmail.com");
//        pessoa.setCorOuRaca("BRANCA");
//        pessoa.setEnderecoBairro("Centro");
//        pessoa.setEnderecoCep("54500-000");
//        pessoa.setEnderecoCidade("Prata");
//        pessoa.setEnderecoNumero("71");
//        pessoa.setEnderecoRua("Rua 01 de Maio");
//        pessoa.setRg("9274816");
//        pessoa.setTelefone1("(83) 830946782");
//        pessoa.setTelefone2("(41) 184658456");
//
//        pessoaDao.getEntityManager().getTransaction().begin();
//        pessoaDao.salvar(pessoa);
//        pessoaDao.getEntityManager().getTransaction().commit();
//
//        listaPessoas = (List<Pessoa>) new ArrayList<Pessoa>();
//        listaPessoas = pessoaDao.findAll();
//
//        for (Pessoa pessoa1 : listaPessoas) {
//
//            if (pessoa1.getNome().equals(pessoa.getNome())) {
//                id = pessoa1.getId();
//                pessoa = pessoa1;
//            }
//        }
//        pessoaDao.delete(pessoa);
//
//        assertNull(pessoaDao.findById(id));
//    }
//
//}
