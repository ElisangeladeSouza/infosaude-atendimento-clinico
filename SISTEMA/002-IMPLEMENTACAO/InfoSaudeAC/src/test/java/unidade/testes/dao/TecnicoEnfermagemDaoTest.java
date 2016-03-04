//package unidade.testes.dao;
//
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.TecnicoEnfermagemDao;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.TecnicoEnfermagem;
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
// * Testes unitários da classe TecnicoEnfermagemDao.
// * 
// * @author wilde <wildearruda@gmail.com>
// */
//public class TecnicoEnfermagemDaoTest {
//
//    private static EntityManagerProducer entityManagerProducer;
//    private static EntityManager entityManager;
//    private static TecnicoEnfermagemDao tecnicoEnfermagemDao;
//    private static DateTimeUtilBean dateTimeUtilBean;
//    private static List<TecnicoEnfermagem> listaTecnicosEnfermagem;
//    private static Long id;
//
//    public TecnicoEnfermagemDaoTest() {
//    }
//
//    /**
//     * Antes da classe de testes iniciar a conexão com o banco de dados as
//     * variáveis abaixo serão iniciadas e será creado o entity manager com a 
//     * unidade de persistência do banco de testes hsqldb.
//     */
//    @BeforeClass
//    public static void setUpClass() {
//        tecnicoEnfermagemDao = new TecnicoEnfermagemDao();
//        dateTimeUtilBean = new DateTimeUtilBean();
//        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
//        entityManager = entityManagerProducer.create();
//        tecnicoEnfermagemDao.setEntityManager(entityManager);
//    }
//
//    /**
//     * Método que testa se cadastro de TecnicoEnfermagem está sendo salvo nulo. 
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarTecnicoEnfermagemNull() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     * Método que testa se o cadastro salva com a inserção de informações apenas 
//     * nos campos obrigatórios.
//     */
//    @Test
//    public void testSalvarTecnicoEnfermagemCamposObrigatorios() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setNome("TECENFERMAGEM SOBRENOME");
//        tecnicoEnfermagem.setCpfTecnicoEnfermagem("48354414434");
//        tecnicoEnfermagem.setCorenTecnicoEnfermagem("20001");
//        tecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("898 5020 9999 5555");
//        tecnicoEnfermagem.setEmail("tecenfermagem.sobrenome@domain.com");
//        tecnicoEnfermagem.setCorOuRaca("");
//        tecnicoEnfermagem.setEnderecoBairro("");
//        tecnicoEnfermagem.setEnderecoCep("");
//        tecnicoEnfermagem.setEnderecoCidade("");
//        tecnicoEnfermagem.setEnderecoNumero("");
//        tecnicoEnfermagem.setEnderecoRua("");
//        tecnicoEnfermagem.setRg("");
//        tecnicoEnfermagem.setTelefone1("");
//        tecnicoEnfermagem.setTelefone2("");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//        listaTecnicosEnfermagem = (List<TecnicoEnfermagem>) new ArrayList<TecnicoEnfermagem>();
//        listaTecnicosEnfermagem = tecnicoEnfermagemDao.findAll();
//
//        for (TecnicoEnfermagem tecnicoEnfermagem1 : listaTecnicosEnfermagem) {
//
//            if (tecnicoEnfermagem1.getCpfTecnicoEnfermagem().equals(tecnicoEnfermagem.getCpfTecnicoEnfermagem())) {
//                id = tecnicoEnfermagem1.getId();
//            }
//        }
//
//        TecnicoEnfermagem novoTecnicoEnfermagem = new TecnicoEnfermagem();
//        novoTecnicoEnfermagem = tecnicoEnfermagemDao.findById(id);
//        assertEquals(tecnicoEnfermagem.getCpfTecnicoEnfermagem(), novoTecnicoEnfermagem.getCpfTecnicoEnfermagem());
//
//    }
//
//    /**
//     * Método que testa o cadastro completo de TecnicoEnfermagem, preenchimento de
//     * todos os campos.
//     */
//    @Test
//    public void testSalvarTecnicoEnfermagemTodosCampos() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setNome("TECENFERMAGEM I SOBRENOME");
//        tecnicoEnfermagem.setCpfTecnicoEnfermagem("37226576449");
//        tecnicoEnfermagem.setCorenTecnicoEnfermagem("15987");
//        tecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("898 4020 9999 5555");
//        tecnicoEnfermagem.setEmail("tecenfermagem.isobrenome@domain.com");
//        tecnicoEnfermagem.setCorOuRaca("PARDA");
//        tecnicoEnfermagem.setDataNascimento(dateTimeUtilBean.getDateToday());
//        tecnicoEnfermagem.setEnderecoBairro("BAIRRO");
//        tecnicoEnfermagem.setEnderecoCep("58500-000");
//        tecnicoEnfermagem.setEnderecoCidade("MONTEIRO");
//        tecnicoEnfermagem.setEnderecoEstado(Estados.PB);
//        tecnicoEnfermagem.setEnderecoNumero("1");
//        tecnicoEnfermagem.setEnderecoRua("DAS FLORES");
//        tecnicoEnfermagem.setRg("88555741-x");
//        tecnicoEnfermagem.setTelefone1("(83)9988-7766");
//        tecnicoEnfermagem.setTelefone2("(83)3305-0001");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//        listaTecnicosEnfermagem = (List<TecnicoEnfermagem>) new ArrayList<TecnicoEnfermagem>();
//        listaTecnicosEnfermagem = tecnicoEnfermagemDao.findAll();
//
//        for (TecnicoEnfermagem tecnicoEnfermagem1 : listaTecnicosEnfermagem) {
//
//            if (tecnicoEnfermagem1.getCpfTecnicoEnfermagem().equals(tecnicoEnfermagem.getCpfTecnicoEnfermagem())) {
//                id = tecnicoEnfermagem1.getId();
//            }
//        }
//
//        TecnicoEnfermagem novoTecnicoEnfermagem = new TecnicoEnfermagem();
//        novoTecnicoEnfermagem = tecnicoEnfermagemDao.findById(id);
//        assertEquals(tecnicoEnfermagem.getCpfTecnicoEnfermagem(), novoTecnicoEnfermagem.getCpfTecnicoEnfermagem());
//    }
//
//    /**
//     * Método que testa o cadastro de um TecnicoEnfermagem com as mesmas 
//     * informações de um cadastro já existente. 
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarTecnicoEnfermagemDuplicado() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setNome("TECENFERMAGEM II SOBRENOME");
//        tecnicoEnfermagem.setCpfTecnicoEnfermagem("85044155381");
//        tecnicoEnfermagem.setCorenTecnicoEnfermagem("15789");
//        tecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("898 3020 9999 5555");
//        tecnicoEnfermagem.setEmail("tecenfermagem.iisobrenome@domain.com");
//        tecnicoEnfermagem.setCorOuRaca("PARDA");
//        tecnicoEnfermagem.setDataNascimento(dateTimeUtilBean.getDateToday());
//        tecnicoEnfermagem.setEnderecoBairro("BAIRRO");
//        tecnicoEnfermagem.setEnderecoCep("58500-000");
//        tecnicoEnfermagem.setEnderecoCidade("MONTEIRO");
//        tecnicoEnfermagem.setEnderecoEstado(Estados.CE);
//        tecnicoEnfermagem.setEnderecoNumero("1");
//        tecnicoEnfermagem.setEnderecoRua("DAS FLORES");
//        tecnicoEnfermagem.setRg("88555741-x");
//        tecnicoEnfermagem.setTelefone1("(83)9988-7766");
//        tecnicoEnfermagem.setTelefone2("(83)3305-0001");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     * Método que testa um cadastro com apenas o campo nome preenchido.
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarTecnicoEnfermagemNome() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setNome("TECENFERMAGEM III SOBRENOME");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     * Método que testa um cadastro com apenas o campo cpf preenchido.
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarTecnicoEnfermagemCpf() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setCpfTecnicoEnfermagem("59764883745");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     * Método que testa um cadastro com apenas o campo coren preenchido.
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarTecnicoEnfermagemCoren() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setCorenTecnicoEnfermagem("15111");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     * Método que testa um cadastro com apenas o campo Cartão SUS preenchido.
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarTecnicoEnfermagemSus() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("898 2020 9999 5555");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     * Método que testa um cadastro com apenas o campo email preenchido.
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarTecnicoEnfermagemEmail() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setEmail("tecenfermagem.iiisobrenome@domain.com");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     * Método que testa um cadastro com o preenchimento dos campos nome e cpf. 
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarTecnicoEnfermagemNomeCpf() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setNome("TECENFERMAGEM IV SOBRENOME");
//        tecnicoEnfermagem.setCpfTecnicoEnfermagem("60227394038");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     * Método que testa um cadastro com o preenchimento dos campos nome, cpf e coren. 
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarTecnicoEnfermagemNomeCpfCoren() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setNome("TECENFERMAGEM V SOBRENOME");
//        tecnicoEnfermagem.setCpfTecnicoEnfermagem("60227394038");
//        tecnicoEnfermagem.setCorenTecnicoEnfermagem("15111");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//    }
//
//    /**
//     * Método que testa um cadastro com apenas o campo cpf preenchido.
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarTecnicoEnfermagemCpfDuplicado() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//        TecnicoEnfermagem novoTecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setNome("TECENFERMAGEM VI SOBRENOME");
//        tecnicoEnfermagem.setCpfTecnicoEnfermagem("64109694574");
//        tecnicoEnfermagem.setCorenTecnicoEnfermagem("15789");
//        tecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("898 1021 9999 5555");
//        tecnicoEnfermagem.setEmail("tecenfermagem.iisobrenome@domain.com");
//
//        novoTecnicoEnfermagem.setNome("TECENFERMAGEM VII SOBRENOME");
//        novoTecnicoEnfermagem.setCpfTecnicoEnfermagem("64109694574");
//        novoTecnicoEnfermagem.setCorenTecnicoEnfermagem("15000");
//        novoTecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("898 1025 9999 5555");
//        novoTecnicoEnfermagem.setEmail("tecenfermagem.xsobrenome@domain.com");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(novoTecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     * Método que testa o cadastro de um Administrador com um Cartão SUS já
//     * cadastrado no sistema. 
//     * Caso isso aconteça uma exceção deve ser lançada.
//     */
//    @Test(expected = Exception.class)
//    public void testSalvarTecnicoEnfermagemSusDuplicado() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//        TecnicoEnfermagem novoTecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setNome("TECENFERMAGEM VIII SOBRENOME");
//        tecnicoEnfermagem.setCpfTecnicoEnfermagem("52943283720");
//        tecnicoEnfermagem.setCorenTecnicoEnfermagem("15789");
//        tecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("898 1030 9999 5555");
//        tecnicoEnfermagem.setEmail("tecenfermagem.iisobrenome@domain.com");
//
//        novoTecnicoEnfermagem.setNome("TECENFERMAGEM IX SOBRENOME");
//        novoTecnicoEnfermagem.setCpfTecnicoEnfermagem("80553213377");
//        novoTecnicoEnfermagem.setCorenTecnicoEnfermagem("15000");
//        novoTecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("898 1030 9999 5555");
//        novoTecnicoEnfermagem.setEmail("tecenfermagem.xsobrenome@domain.com");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(novoTecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
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
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setNome("ENTIDADE X SOBRENOME");
//        tecnicoEnfermagem.setCpfTecnicoEnfermagem("91184468680");
//        tecnicoEnfermagem.setCorenTecnicoEnfermagem("20002");
//        tecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("898 2221 0121 9994");
//        tecnicoEnfermagem.setEmail("entidade.sobrenome@domain.com");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//    }
//
//    /**
//     * Método que testa a busca em uma lista com todos os resultados encontrados
//     * no banco de dados.
//     */
//    @Test
//    public void testFindAll() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setNome("TECENFERMAGEM XI SOBRENOME");
//        tecnicoEnfermagem.setCpfTecnicoEnfermagem("54010384298");
//        tecnicoEnfermagem.setCorenTecnicoEnfermagem("20005");
//        tecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("756 0000 0000 0040");
//        tecnicoEnfermagem.setEmail("tecnicoEnfermagem.sobrenome@domain.com");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//        listaTecnicosEnfermagem = (List<TecnicoEnfermagem>) new ArrayList<TecnicoEnfermagem>();
//        listaTecnicosEnfermagem = tecnicoEnfermagemDao.findAll();
//
//        assertFalse(0 == listaTecnicosEnfermagem.size());
//    }
//
//    /**
//     * Método que testa a busca de um registro no banco de dados para
//     * determinada entidade através da passagem do seu ID como parâmetro.
//     */
//    @Test
//    public void testFindById() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setNome("TECENFERMAGEM XII SOBRENOME");
//        tecnicoEnfermagem.setCpfTecnicoEnfermagem("42663305537");
//        tecnicoEnfermagem.setCorenTecnicoEnfermagem("20006");
//        tecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("756 0000 0000 0041");
//        tecnicoEnfermagem.setEmail("tecnicoEnfermagem.sobrenome@domain.com");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//        listaTecnicosEnfermagem = (List<TecnicoEnfermagem>) new ArrayList<TecnicoEnfermagem>();
//        listaTecnicosEnfermagem = tecnicoEnfermagemDao.findAll();
//
//        for (TecnicoEnfermagem tecnicoEnfermagem1 : listaTecnicosEnfermagem) {
//
//            if (tecnicoEnfermagem1.getCpfTecnicoEnfermagem().equals(tecnicoEnfermagem.getCpfTecnicoEnfermagem())) {
//                id = tecnicoEnfermagem1.getId();
//            }
//        }
//
//        TecnicoEnfermagem novoTecnicoEnfermagem = new TecnicoEnfermagem();
//        novoTecnicoEnfermagem = tecnicoEnfermagemDao.findById(id);
//        assertEquals(tecnicoEnfermagem.getCpfTecnicoEnfermagem(), novoTecnicoEnfermagem.getCpfTecnicoEnfermagem());
//    }
//
//    /**
//     * Método que testa a a busca de um registro com ID inexistente.
//     */
//    @Test
//    public void testFindByIdInexistente() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setNome("TECENFERMAGEM XIII SOBRENOME");
//        tecnicoEnfermagem.setCpfTecnicoEnfermagem("33473652164");
//        tecnicoEnfermagem.setCorenTecnicoEnfermagem("20007");
//        tecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("756 0000 0000 0042");
//        tecnicoEnfermagem.setEmail("tecnicoEnfermagem.sobrenome@domain.com");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//        TecnicoEnfermagem novoTecnicoEnfermagem = new TecnicoEnfermagem();
//
//        assertNull(novoTecnicoEnfermagem = tecnicoEnfermagemDao.findById(0L));
//    }
//
//    /**
//     * Método que testa a exclusão de cadastros do banco de dados.
//     */
//    @Test
//    public void testDelete() {
//
//        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
//
//        tecnicoEnfermagem.setNome("TECENFERMAGEM XIV SOBRENOME");
//        tecnicoEnfermagem.setCpfTecnicoEnfermagem("22911472420");
//        tecnicoEnfermagem.setCorenTecnicoEnfermagem("20000");
//        tecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("756 0000 0000 0045");
//        tecnicoEnfermagem.setEmail("tecnicoEnfermagem.sobrenome@domain.com");
//
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
//        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
//        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
//
//        listaTecnicosEnfermagem = (List<TecnicoEnfermagem>) new ArrayList<TecnicoEnfermagem>();
//        listaTecnicosEnfermagem = tecnicoEnfermagemDao.findAll();
//
//        for (TecnicoEnfermagem tecnicoEnfermagem1 : listaTecnicosEnfermagem) {
//
//            if (tecnicoEnfermagem1.getCpfTecnicoEnfermagem().equals(tecnicoEnfermagem.getCpfTecnicoEnfermagem())) {
//                id = tecnicoEnfermagem1.getId();
//                tecnicoEnfermagem = tecnicoEnfermagem1;
//            }
//        }
//        tecnicoEnfermagemDao.delete(tecnicoEnfermagem);
//
//        assertNull(tecnicoEnfermagemDao.findById(id));
//
//    }
//
//}
