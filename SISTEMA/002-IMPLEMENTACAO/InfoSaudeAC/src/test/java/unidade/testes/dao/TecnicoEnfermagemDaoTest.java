package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.TecnicoEnfermagemDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.TecnicoEnfermagem;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wilde
 */
public class TecnicoEnfermagemDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static TecnicoEnfermagemDao tecnicoEnfermagemDao;
    private static DateTimeUtilBean dateTimeUtilBean;
    private static List<TecnicoEnfermagem> listaTecnicosEnfermagem;
    private static Long id;
    
    public TecnicoEnfermagemDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        tecnicoEnfermagemDao = new TecnicoEnfermagemDao();
        dateTimeUtilBean = new DateTimeUtilBean();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        tecnicoEnfermagemDao.setEntityManager(entityManager);    
    }
    

    @Test (expected = Exception.class)
    public void testSalvarTecnicoEnfermagemNull() {
        
        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
        
        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test 
    public void testSalvarTecnicoEnfermagemCamposObrigatorios(){
    
        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
        
        tecnicoEnfermagem.setNome("TECENFERMAGEM SOBRENOME");
	tecnicoEnfermagem.setCpf("48354414434");
	tecnicoEnfermagem.setCoren("20001");
	tecnicoEnfermagem.setCartaoSus("898 5020 9999 5555");
	tecnicoEnfermagem.setEmail("tecenfermagem.sobrenome@domain.com");
	tecnicoEnfermagem.setCorOuRaca("");
	tecnicoEnfermagem.setEnderecoBairro("");
	tecnicoEnfermagem.setEnderecoCep("");
	tecnicoEnfermagem.setEnderecoCidade("");
	tecnicoEnfermagem.setEnderecoNumero("");
	tecnicoEnfermagem.setEnderecoRua("");
	tecnicoEnfermagem.setRg("");
	tecnicoEnfermagem.setTelefone1("");
	tecnicoEnfermagem.setTelefone2("");
        
        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
     
        listaTecnicosEnfermagem = (List<TecnicoEnfermagem>) new ArrayList<TecnicoEnfermagem>();
        listaTecnicosEnfermagem = tecnicoEnfermagemDao.findAll();

        for (TecnicoEnfermagem tecnicoEnfermagem1 : listaTecnicosEnfermagem) {

            if (tecnicoEnfermagem1.getCpf().equals(tecnicoEnfermagem.getCpf())) {
                id = tecnicoEnfermagem1.getId();
            }
        }
        
        TecnicoEnfermagem novoTecnicoEnfermagem = new TecnicoEnfermagem();
        novoTecnicoEnfermagem = tecnicoEnfermagemDao.findById(id);
        assertEquals(tecnicoEnfermagem.getCpf(), novoTecnicoEnfermagem.getCpf());
        
    }

    @Test 
    public void testSalvarTecnicoEnfermagemTodosCampos(){
    
        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
        
        tecnicoEnfermagem.setNome("TECENFERMAGEM I SOBRENOME");
	tecnicoEnfermagem.setCpf("37226576449");
	tecnicoEnfermagem.setCoren("15987");
	tecnicoEnfermagem.setCartaoSus("898 4020 9999 5555");
	tecnicoEnfermagem.setEmail("tecenfermagem.isobrenome@domain.com");
	tecnicoEnfermagem.setCorOuRaca("PARDA");
	tecnicoEnfermagem.setDataNascimento(dateTimeUtilBean.getDateToday());
	tecnicoEnfermagem.setEnderecoBairro("BAIRRO");
	tecnicoEnfermagem.setEnderecoCep("58500-000");
	tecnicoEnfermagem.setEnderecoCidade("MONTEIRO");
	tecnicoEnfermagem.setEnderecoEstado(Estados.PB);
	tecnicoEnfermagem.setEnderecoNumero("1");
	tecnicoEnfermagem.setEnderecoRua("DAS FLORES");
	tecnicoEnfermagem.setRg("88555741-x");
	tecnicoEnfermagem.setTelefone1("(83)9988-7766");
	tecnicoEnfermagem.setTelefone2("(83)3305-0001");
        
        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
     
        listaTecnicosEnfermagem = (List<TecnicoEnfermagem>) new ArrayList<TecnicoEnfermagem>();
        listaTecnicosEnfermagem = tecnicoEnfermagemDao.findAll();

        for (TecnicoEnfermagem tecnicoEnfermagem1 : listaTecnicosEnfermagem) {

            if (tecnicoEnfermagem1.getCpf().equals(tecnicoEnfermagem.getCpf())) {
                id = tecnicoEnfermagem1.getId();
            }
        }
        
        TecnicoEnfermagem novoTecnicoEnfermagem = new TecnicoEnfermagem();
        novoTecnicoEnfermagem = tecnicoEnfermagemDao.findById(id);
        assertEquals(tecnicoEnfermagem.getCpf(), novoTecnicoEnfermagem.getCpf());
    }
    
    @Test (expected = Exception.class)
    public void testSalvarTecnicoEnfermagemDuplicado(){
    
        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
        
        tecnicoEnfermagem.setNome("TECENFERMAGEM II SOBRENOME");
	tecnicoEnfermagem.setCpf("85044155381");
	tecnicoEnfermagem.setCoren("15789");
	tecnicoEnfermagem.setCartaoSus("898 3020 9999 5555");
	tecnicoEnfermagem.setEmail("tecenfermagem.iisobrenome@domain.com");
	tecnicoEnfermagem.setCorOuRaca("PARDA");
	tecnicoEnfermagem.setDataNascimento(dateTimeUtilBean.getDateToday());
	tecnicoEnfermagem.setEnderecoBairro("BAIRRO");
	tecnicoEnfermagem.setEnderecoCep("58500-000");
	tecnicoEnfermagem.setEnderecoCidade("MONTEIRO");
	tecnicoEnfermagem.setEnderecoEstado(Estados.CE);
	tecnicoEnfermagem.setEnderecoNumero("1");
	tecnicoEnfermagem.setEnderecoRua("DAS FLORES");
	tecnicoEnfermagem.setRg("88555741-x");
	tecnicoEnfermagem.setTelefone1("(83)9988-7766");
	tecnicoEnfermagem.setTelefone2("(83)3305-0001");				
				
	tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
        
        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarTecnicoEnfermagemNome(){
    
        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
        
        tecnicoEnfermagem.setNome("TECENFERMAGEM III SOBRENOME");
   
        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarTecnicoEnfermagemCpf(){
    
        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
        
        tecnicoEnfermagem.setCpf("59764883745");
   
        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarTecnicoEnfermagemCoren(){
    
        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
        
        tecnicoEnfermagem.setCoren("15111");
   
        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarTecnicoEnfermagemSus(){
    
        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
        
        tecnicoEnfermagem.setCartaoSus("898 2020 9999 5555");
   
        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarTecnicoEnfermagemEmail(){
    
        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
        
        tecnicoEnfermagem.setEmail("tecenfermagem.iiisobrenome@domain.com");
   
        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarTecnicoEnfermagemNomeCpf(){
    
        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
        
        tecnicoEnfermagem.setNome("TECENFERMAGEM III SOBRENOME");
	tecnicoEnfermagem.setCpf("60227394038");
   
        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarTecnicoEnfermagemNomeCpfCoren(){
    
        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
        
        tecnicoEnfermagem.setNome("TECENFERMAGEM III SOBRENOME");
	tecnicoEnfermagem.setCpf("60227394038");
        tecnicoEnfermagem.setCoren("15111");
        
        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarTecnicoEnfermagemCpfDuplicado(){
    
        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
        TecnicoEnfermagem novoTecnicoEnfermagem = new TecnicoEnfermagem();
		
        tecnicoEnfermagem.setNome("TECENFERMAGEM II SOBRENOME");
	tecnicoEnfermagem.setCpf("64109694574");
	tecnicoEnfermagem.setCoren("15789");
	tecnicoEnfermagem.setCartaoSus("898 1021 9999 5555");
	tecnicoEnfermagem.setEmail("tecenfermagem.iisobrenome@domain.com");
		
	novoTecnicoEnfermagem.setNome("TECENFERMAGEM X SOBRENOME");
	novoTecnicoEnfermagem.setCpf("64109694574");
	novoTecnicoEnfermagem.setCoren("15000");
	novoTecnicoEnfermagem.setCartaoSus("898 1025 9999 5555");
	novoTecnicoEnfermagem.setEmail("tecenfermagem.xsobrenome@domain.com");
		
	tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
		
	tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(novoTecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
    }
    
    @Test (expected = Exception.class)
    public void testSalvarTecnicoEnfermagemSusDuplicado(){
    
        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
        TecnicoEnfermagem novoTecnicoEnfermagem = new TecnicoEnfermagem();
		
        tecnicoEnfermagem.setNome("TECENFERMAGEM II SOBRENOME");
	tecnicoEnfermagem.setCpf("52943283720");
	tecnicoEnfermagem.setCoren("15789");
	tecnicoEnfermagem.setCartaoSus("898 1030 9999 5555");
	tecnicoEnfermagem.setEmail("tecenfermagem.iisobrenome@domain.com");
		
	novoTecnicoEnfermagem.setNome("TECENFERMAGEM X SOBRENOME");
	novoTecnicoEnfermagem.setCpf("80553213377");
	novoTecnicoEnfermagem.setCoren("15000");
	novoTecnicoEnfermagem.setCartaoSus("898 1030 9999 5555");
	novoTecnicoEnfermagem.setEmail("tecenfermagem.xsobrenome@domain.com");
		
	tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
		
	tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(novoTecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
    }
    
    @Test 
    public void testSalvarCpfSusTodoSistema(){
    
        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();
        
        tecnicoEnfermagem.setNome("ENTIDADE SOBRENOME");
	tecnicoEnfermagem.setCpf("91184468680");
	tecnicoEnfermagem.setCoren("20002");
	tecnicoEnfermagem.setCartaoSus("898 2221 0121 9994");
	tecnicoEnfermagem.setEmail("entidade.sobrenome@domain.com");
        
        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();
    }
    
    @Test
    public void testFindAll() {

        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();

        tecnicoEnfermagem.setNome("TECENFERMAGEM SOBRENOME");
        tecnicoEnfermagem.setCpf("54010384298");
        tecnicoEnfermagem.setCoren("20005");
        tecnicoEnfermagem.setCartaoSus("756 0000 0000 0040");
        tecnicoEnfermagem.setEmail("tecnicoEnfermagem.sobrenome@domain.com");

        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();

        listaTecnicosEnfermagem = (List<TecnicoEnfermagem>) new ArrayList<TecnicoEnfermagem>();
        listaTecnicosEnfermagem = tecnicoEnfermagemDao.findAll();

        assertFalse(0 == listaTecnicosEnfermagem.size());
    }
 
    @Test
    public void testFindById() {

        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();

        tecnicoEnfermagem.setNome("TECENFERMAGEM SOBRENOME");
        tecnicoEnfermagem.setCpf("42663305537");
        tecnicoEnfermagem.setCoren("20006");
        tecnicoEnfermagem.setCartaoSus("756 0000 0000 0041");
        tecnicoEnfermagem.setEmail("tecnicoEnfermagem.sobrenome@domain.com");
        
        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();

        listaTecnicosEnfermagem = (List<TecnicoEnfermagem>) new ArrayList<TecnicoEnfermagem>();
        listaTecnicosEnfermagem = tecnicoEnfermagemDao.findAll();

        for (TecnicoEnfermagem tecnicoEnfermagem1 : listaTecnicosEnfermagem) {

            if (tecnicoEnfermagem1.getCpf().equals(tecnicoEnfermagem.getCpf())) {
                id = tecnicoEnfermagem1.getId();
            }
        }
        
        TecnicoEnfermagem novoTecnicoEnfermagem = new TecnicoEnfermagem();
        novoTecnicoEnfermagem = tecnicoEnfermagemDao.findById(id);
        assertEquals(tecnicoEnfermagem.getCpf(), novoTecnicoEnfermagem.getCpf());
    }
    
    @Test
    public void testFindByIdInexistente() {

        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();

        tecnicoEnfermagem.setNome("TECENFERMAGEM SOBRENOME");
        tecnicoEnfermagem.setCpf("33473652164");
        tecnicoEnfermagem.setCoren("20007");
        tecnicoEnfermagem.setCartaoSus("756 0000 0000 0042");
        tecnicoEnfermagem.setEmail("tecnicoEnfermagem.sobrenome@domain.com");
        
        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();

        TecnicoEnfermagem novoTecnicoEnfermagem = new TecnicoEnfermagem();
        
        assertNull(novoTecnicoEnfermagem = tecnicoEnfermagemDao.findById(0L));
    }
    
    @Test
    public void testDelete() {

        TecnicoEnfermagem tecnicoEnfermagem = new TecnicoEnfermagem();

        tecnicoEnfermagem.setNome("TECENFERMAGEM SOBRENOME");
        tecnicoEnfermagem.setCpf("22911472420");
        tecnicoEnfermagem.setCoren("20000");
        tecnicoEnfermagem.setCartaoSus("756 0000 0000 0045");
        tecnicoEnfermagem.setEmail("tecnicoEnfermagem.sobrenome@domain.com");

        tecnicoEnfermagemDao.getEntityManager().getTransaction().begin();
        tecnicoEnfermagemDao.salvar(tecnicoEnfermagem);
        tecnicoEnfermagemDao.getEntityManager().getTransaction().commit();

        listaTecnicosEnfermagem = (List<TecnicoEnfermagem>) new ArrayList<TecnicoEnfermagem>();
        listaTecnicosEnfermagem = tecnicoEnfermagemDao.findAll();

        for (TecnicoEnfermagem tecnicoEnfermagem1 : listaTecnicosEnfermagem) {

            if (tecnicoEnfermagem1.getCpf().equals(tecnicoEnfermagem.getCpf())) {
                id = tecnicoEnfermagem1.getId();
                tecnicoEnfermagem = tecnicoEnfermagem1;
            }
        }
        tecnicoEnfermagemDao.delete(tecnicoEnfermagem);
        
        assertNull(tecnicoEnfermagemDao.findById(id));
        
    }
    
}
