//package unidade.testes.dao;
//
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.DiretorDao;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Diretor;
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
// * Teste unitários da classe de DiretorDao.
// * 
// * @author wilde <wildearruda@gmail.com> 
// */
//public class DiretorDaoTest {
//
//    private static EntityManagerProducer entityManagerProducer;
//    private static EntityManager entityManager;
//    private static DiretorDao diretorDao;
//    private static DateTimeUtilBean dateTimeUtilBean;
//    private static List<Diretor> listaDiretores;
//    private static Long id;
//
//    public DiretorDaoTest() {
//    }
//
//    /**
//     * Antes da classe de testes iniciar a conexão com o banco de dados as
//     * variáveis abaixo serão iniciadas e será creado o entity manager com a 
//     * unidade de persistência do banco de testes hsqldb.
//     */
//    @BeforeClass
//    public static void setUpClass() {
//        diretorDao = new DiretorDao();
//        dateTimeUtilBean = new DateTimeUtilBean();
//        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
//        entityManager = entityManagerProducer.create();
//        diretorDao.setEntityManager(entityManager);
//    }
//    
//    /**
//     * Método que testa se cadastro de Diretor está sendo salvo nulo. 
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarDiretorNull() {
//
//        Diretor diretor = new Diretor();
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     * Método que testa se o cadastro salva com a inserção de informações apenas 
//     * nos campos obrigatórios.
//     */
//    @Test
//    public void testSalvarDiretorCamposObrigatorios() {
//
//        Diretor diretor = new Diretor();
//
//        diretor.setNome("ADMINISTRADOR SOBRENOME");
//        diretor.setCpfDiretor("52645149847");
//        diretor.setCartaoSusDiretor("898 0001 0121 0004");
//        diretor.setEmail("");
//        diretor.setCorOuRaca("");
//        diretor.setEnderecoBairro("");
//        diretor.setEnderecoCep("");
//        diretor.setEnderecoCidade("");
//        diretor.setEnderecoNumero("");
//        diretor.setEnderecoRua("");
//        diretor.setRg("");
//        diretor.setTelefone1("");
//        diretor.setTelefone2("");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//
//        listaDiretores = (List<Diretor>) new ArrayList<Diretor>();
//        listaDiretores = diretorDao.findAll();
//
//        for (Diretor diretor1 : listaDiretores) {
//
//            if (diretor1.getCpfDiretor().equals(diretor.getCpfDiretor())) {
//                id = diretor1.getId();
//            }
//        }
//
//        Diretor novoDiretor = new Diretor();
//        novoDiretor = diretorDao.findById(id);
//
//        assertEquals(diretor.getCpfDiretor(), novoDiretor.getCpfDiretor());
//    }
//
//    /**
//     * Método que testa o cadastro completo de Administrator, preenchimento de
//     * todos os campos.
//     */
//    @Test
//    public void testSalvarDiretorTodosCampos() {
//
//        Diretor diretor = new Diretor();
//
//        diretor.setNome("ADMINISTRADOR I SOBRENOME");
//        diretor.setCpfDiretor("23367341258");
//        diretor.setCartaoSusDiretor("898 0001 0121 0009");
//        diretor.setEmail("diretor.isobrenome@domain.com");
//        diretor.setCorOuRaca("PARDA");
//        diretor.setDataNascimento(dateTimeUtilBean.getDateToday());
//        diretor.setEnderecoBairro("BAIRRO");
//        diretor.setEnderecoCep("58500-000");
//        diretor.setEnderecoCidade("MONTEIRO");
//        diretor.setEnderecoEstado(Estados.PB);
//        diretor.setEnderecoNumero("1");
//        diretor.setEnderecoRua("DAS FLORES");
//        diretor.setRg("88555741-x");
//        diretor.setTelefone1("(83)9988-7766");
//        diretor.setTelefone2("(83)3305-0001");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//
//        listaDiretores = (List<Diretor>) new ArrayList<Diretor>();
//        listaDiretores = diretorDao.findAll();
//
//        for (Diretor diretor1 : listaDiretores) {
//
//            if (diretor1.getCpfDiretor().equals(diretor.getCpfDiretor())) {
//                id = diretor1.getId();
//            }
//        }
//
//        Diretor novoDiretor = new Diretor();
//        novoDiretor = diretorDao.findById(id);
//
//        assertEquals(diretor.getCpfDiretor(), novoDiretor.getCpfDiretor());
//    }
//
//    /**
//     * Método que testa o cadastro de um Diretor com as mesmas 
//     * informações de um cadastro já existente. 
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarDiretorDuplicado() {
//
//        Diretor diretor = new Diretor();
//
//        diretor.setNome("ADMINISTRADOR II SOBRENOME");
//        diretor.setCpfDiretor("17407400253");
//        diretor.setCartaoSusDiretor("898 0001 0121 0099");
//        diretor.setEmail("diretor.iisobrenome@domain.com");
//        diretor.setCorOuRaca("PARDA");
//        diretor.setDataNascimento(dateTimeUtilBean.getDateToday());
//        diretor.setEnderecoBairro("BAIRRO");
//        diretor.setEnderecoCep("58500-000");
//        diretor.setEnderecoCidade("MONTEIRO");
//        diretor.setEnderecoEstado(Estados.CE);
//        diretor.setEnderecoNumero("1");
//        diretor.setEnderecoRua("DAS FLORES");
//        diretor.setRg("88555741-x");
//        diretor.setTelefone1("(83)9988-7766");
//        diretor.setTelefone2("(83)3305-0001");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     * Método que testa um cadastro com apenas o campo nome preenchido.
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarDiretorNome() {
//
//        Diretor diretor = new Diretor();
//
//        diretor.setNome("ADMINISTRADOR III SOBRENOME");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     * Método que testa um cadastro com apenas o campo cpf preenchido.
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarDiretorCpf() {
//
//        Diretor diretor = new Diretor();
//
//        diretor.setCpfDiretor("53406305792");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     * Método que testa um cadastro com apenas o campo Cartão SUS preenchido.
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarDiretorSus() {
//
//        Diretor diretor = new Diretor();
//
//        diretor.setCartaoSusDiretor("898 0001 0121 0099");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     * Método que testa um cadastro com apenas o campo email preenchido.
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarDiretorEmail() {
//
//        Diretor diretor = new Diretor();
//
//        diretor.setEmail("diretor.iiisobrenome@domain.com");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     * Método que testa um cadastro com o preenchimento dos campos nome e cpf. 
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarDiretorNomeCpf() {
//
//        Diretor diretor = new Diretor();
//
//        diretor.setNome("ADMINISTRADOR IV SOBRENOME");
//        diretor.setCpfDiretor("53406305792");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     * Método que testa um cadastro com apenas o campo cpf preenchido.
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarDiretorCpfDuplicado() {
//
//        Diretor diretor = new Diretor();
//        Diretor novoDiretor = new Diretor();
//
//        diretor.setNome("ADMINISTRADOR V SOBRENOME");
//        diretor.setCpfDiretor("17407400253");
//        diretor.setCartaoSusDiretor("898 0001 0121 0099");
//        diretor.setEmail("diretor.iisobrenome@domain.com");
//
//        novoDiretor.setNome("ADMINISTRADOR X SOBRENOME");
//        novoDiretor.setCpfDiretor("17407400253");
//        novoDiretor.setCartaoSusDiretor("898 0001 0121 0901");
//        novoDiretor.setEmail("diretor.xsobrenome@domain.com");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(novoDiretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     * Método que testa o cadastro de um Diretor com um Cartão SUS já
//     * cadastrado no sistema. 
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarDiretorSusDuplicado() {
//
//        Diretor diretor = new Diretor();
//        Diretor novoDiretor = new Diretor();
//
//        diretor.setNome("ADMINISTRADOR VI SOBRENOME");
//        diretor.setCpfDiretor("17407400253");
//        diretor.setCartaoSusDiretor("898 0001 0121 0099");
//        diretor.setEmail("diretor.iisobrenome@domain.com");
//
//        novoDiretor.setNome("ADMINISTRADOR VII SOBRENOME");
//        novoDiretor.setCpfDiretor("43622448326");
//        novoDiretor.setCartaoSusDiretor("898 0001 0121 0099");
//        novoDiretor.setEmail("diretor.xsobrenome@domain.com");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(novoDiretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     * Método que testa o cadastro dos campos CPF e Cartão SUS de todo o 
//     * sistema.
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test
//    public void testSalvarCpfSusTodoSistema() {
//
//        Diretor diretor = new Diretor();
//
//        diretor.setNome("ENTIDADE SOBRENOME");
//        diretor.setCpfDiretor("91184468680");
//        diretor.setCartaoSusDiretor("898 2221 0121 9994");
//        diretor.setEmail("entidade.sobrenome@domain.com");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     * Método que testa a busca em uma lista com todos os resultados encontrados
//     * no banco de dados.
//     */
//    @Test
//    public void testFindAll() {
//
//        Diretor diretor = new Diretor();
//
//        diretor.setNome("ADMINISTRADOR VIII SOBRENOME ");
//        diretor.setCpfDiretor("55456713314");
//        diretor.setCartaoSusDiretor("756 0000 0000 0000");
//        diretor.setEmail("diretor.sobrenome@domain.com");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//
//        listaDiretores = (List<Diretor>) new ArrayList<Diretor>();
//        listaDiretores = diretorDao.findAll();
//
//        assertFalse(0 == listaDiretores.size());
//    }
//
//    /**
//     * Método que testa a busca de um registro no banco de dados para
//     * determinada entidade através da passagem do seu ID como parâmetro.
//     */
//    @Test
//    public void testFindById() {
//
//        Diretor diretor = new Diretor();
//
//        diretor.setNome("ADMINISTRADOR IX SOBRENOME");
//        diretor.setCpfDiretor("81574762591");
//        diretor.setCartaoSusDiretor("756 0000 0000 0001");
//        diretor.setEmail("diretor.sobrenome@domain.com");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//
//        listaDiretores = (List<Diretor>) new ArrayList<Diretor>();
//        listaDiretores = diretorDao.findAll();
//
//        for (Diretor diretor1 : listaDiretores) {
//
//            if (diretor1.getCpfDiretor().equals(diretor.getCpfDiretor())) {
//                id = diretor1.getId();
//            }
//        }
//
//        Diretor novoDiretor = new Diretor();
//        novoDiretor = diretorDao.findById(id);
//        assertEquals(diretor.getCpfDiretor(), novoDiretor.getCpfDiretor());
//    }
//
//    /**
//     * Método que testa a a busca de um registro com ID inexistente.
//     */
//    @Test
//    public void testFindByIdInexistente() {
//
//        Diretor diretor = new Diretor();
//
//        diretor.setNome("ADMINISTRADOR X SOBRENOME");
//        diretor.setCpfDiretor("82471569463");
//        diretor.setCartaoSusDiretor("756 0000 0000 0002");
//        diretor.setEmail("diretor.sobrenome@domain.com");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//
//        Diretor novoDiretor = new Diretor();
//
//        assertNull(novoDiretor = diretorDao.findById(0L));
//    }
//
//    /**
//     * Método que testa a exclusão de cadastros do banco de dados.
//     */
//    @Test
//    public void testDelete() {
//
//        Diretor diretor = new Diretor();
//
//        diretor.setNome("ADMINISTRADOR XI SOBRENOME");
//        diretor.setCpfDiretor("67338517177");
//        diretor.setCartaoSusDiretor("756 0000 0000 0003");
//        diretor.setEmail("diretor.sobrenome@domain.com");
//
//        diretorDao.getEntityManager().getTransaction().begin();
//        diretorDao.salvar(diretor);
//        diretorDao.getEntityManager().getTransaction().commit();
//
//        listaDiretores = (List<Diretor>) new ArrayList<Diretor>();
//        listaDiretores = diretorDao.findAll();
//
//        for (Diretor diretor1 : listaDiretores) {
//
//            if (diretor1.getCpfDiretor().equals(diretor.getCpfDiretor())) {
//                id = diretor1.getId();
//                diretor = diretor1;
//            }
//        }
//        diretorDao.delete(diretor);
//
//        assertNull(diretorDao.findById(id));
//    }
//}
