package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.EnfermeiroDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wilde
 */
public class EnfermeiroDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static EnfermeiroDao enfermeiroDao;
    private static DateTimeUtilBean dateTimeUtilBean;
    private static List<Enfermeiro> listaEnfermeiros;
    private static Long id;
    
    
    public EnfermeiroDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        enfermeiroDao = new EnfermeiroDao();
        dateTimeUtilBean = new DateTimeUtilBean();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        enfermeiroDao.setEntityManager(entityManager);    
    }
    

    @Test (expected = Exception.class)
    public void testSalvarEnfermeiroNull() {
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test 
    public void testSalvarEnfermeiroCamposObrigatorios(){
    
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("ENFERMEIRO SOBRENOME");
	enfermeiro.setCpf("55183270562");
	enfermeiro.setCoren("19000");
	enfermeiro.setCartaoSus("898 1001 0121 0004");
	enfermeiro.setEmail("enfermeiro.sobrenome@domain.com");
	enfermeiro.setCorOuRaca("");
	enfermeiro.setEnderecoBairro("");
	enfermeiro.setEnderecoCep("");
	enfermeiro.setEnderecoCidade("");
	enfermeiro.setEnderecoNumero("");
	enfermeiro.setEnderecoRua("");
	enfermeiro.setRg("");
	enfermeiro.setTelefone1("");
	enfermeiro.setTelefone2("");
        
        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
     
        listaEnfermeiros = (List<Enfermeiro>) new ArrayList<Enfermeiro>();
        listaEnfermeiros = enfermeiroDao.findAll();

        for (Enfermeiro enfermeiro1 : listaEnfermeiros) {

            if (enfermeiro1.getCpf().equals(enfermeiro.getCpf())) {
                id = enfermeiro1.getId();
            }
        }
        
        Enfermeiro novoEnfermeiro = new Enfermeiro();
        novoEnfermeiro = enfermeiroDao.findById(id);
        
        assertEquals(enfermeiro.getCpf(), novoEnfermeiro.getCpf());
    }

    @Test 
    public void testSalvarEnfermeiroTodosCampos(){
    
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("ENFERMEIRO I SOBRENOME");
	enfermeiro.setCpf("30257622411");
	enfermeiro.setCoren("15987");
	enfermeiro.setCartaoSus("898 0101 0121 0009");
	enfermeiro.setEmail("enfermeiro.isobrenome@domain.com");
	enfermeiro.setCorOuRaca("PARDA");
	enfermeiro.setDataNascimento(dateTimeUtilBean.getDateToday());
	enfermeiro.setEnderecoBairro("BAIRRO");
	enfermeiro.setEnderecoCep("58500-000");
	enfermeiro.setEnderecoCidade("MONTEIRO");
	enfermeiro.setEnderecoEstado(Estados.PB);
	enfermeiro.setEnderecoNumero("1");
	enfermeiro.setEnderecoRua("DAS FLORES");
	enfermeiro.setRg("88555741-x");
	enfermeiro.setTelefone1("(83)9988-7766");
	enfermeiro.setTelefone2("(83)3305-0001");
        
        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
     
        listaEnfermeiros = (List<Enfermeiro>) new ArrayList<Enfermeiro>();
        listaEnfermeiros = enfermeiroDao.findAll();

        for (Enfermeiro enfermeiro1 : listaEnfermeiros) {

            if (enfermeiro1.getCpf().equals(enfermeiro.getCpf())) {
                id = enfermeiro1.getId();
            }
        }
        
        Enfermeiro novoEnfermeiro = new Enfermeiro();
        novoEnfermeiro = enfermeiroDao.findById(id);
        
        assertEquals(enfermeiro.getCpf(), novoEnfermeiro.getCpf());
    }
    
    @Test (expected = Exception.class)
    public void testSalvarEnfermeiroDuplicado(){
    
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("ENFERMEIRO II SOBRENOME");
	enfermeiro.setCpf("46557147862");
	enfermeiro.setCoren("15789");
	enfermeiro.setCartaoSus("898 0011 0121 0099");
	enfermeiro.setEmail("enfermeiro.iisobrenome@domain.com");
	enfermeiro.setCorOuRaca("PARDA");
	enfermeiro.setDataNascimento(dateTimeUtilBean.getDateToday());
	enfermeiro.setEnderecoBairro("BAIRRO");
	enfermeiro.setEnderecoCep("58500-000");
	enfermeiro.setEnderecoCidade("MONTEIRO");
	enfermeiro.setEnderecoEstado(Estados.CE);
	enfermeiro.setEnderecoNumero("1");
	enfermeiro.setEnderecoRua("DAS FLORES");
	enfermeiro.setRg("88555741-x");
	enfermeiro.setTelefone1("(83)9988-7766");
	enfermeiro.setTelefone2("(83)3305-0001");				
				
	enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
        
        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarEnfermeiroNome(){
    
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("ENFERMEIRO III SOBRENOME");
   
        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarEnfermeiroCpf(){
    
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setCpf("13261684798");
   
        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarEnfermeiroCoren(){
    
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setCoren("15111");
   
        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarEnfermeiroSus(){
    
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setCartaoSus("898 0002 0121 0099");
   
        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarEnfermeiroEmail(){
    
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setEmail("enfermeiro.iiisobrenome@domain.com");
   
        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarEnfermeiroNomeCpf(){
    
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("ENFERMEIRO IV SOBRENOME");
	enfermeiro.setCpf("13261684798");
   
        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarEnfermeiroNomeCpfCoren(){
    
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("ENFERMEIRO V SOBRENOME");
	enfermeiro.setCpf("13261684798");
        enfermeiro.setCoren("15111");
        
        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarEnfermeiroCpfDuplicado(){
    
        Enfermeiro enfermeiro = new Enfermeiro();
        Enfermeiro novoEnfermeiro = new Enfermeiro();
		
        enfermeiro.setNome("ENFERMEIRO VI SOBRENOME");
	enfermeiro.setCpf("83381631632");
	enfermeiro.setCoren("15789");
	enfermeiro.setCartaoSus("898 0001 0121 0099");
	enfermeiro.setEmail("enfermeiro.iisobrenome@domain.com");
		
	novoEnfermeiro.setNome("ENFERMEIRO X SOBRENOME");
	novoEnfermeiro.setCpf("83381631632");
	novoEnfermeiro.setCoren("15000");
	novoEnfermeiro.setCartaoSus("898 0001 0121 0901");
	novoEnfermeiro.setEmail("enfermeiro.xsobrenome@domain.com");
		
	enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
		
	enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(novoEnfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
    }
    
    @Test (expected = Exception.class)
    public void testSalvarEnfermeiroSusDuplicado(){
    
        Enfermeiro enfermeiro = new Enfermeiro();
        Enfermeiro novoEnfermeiro = new Enfermeiro();
		
        enfermeiro.setNome("ENFERMEIRO VII SOBRENOME");
	enfermeiro.setCpf("03545217302");
	enfermeiro.setCoren("15789");
	enfermeiro.setCartaoSus("898 0001 1121 0099");
	enfermeiro.setEmail("enfermeiro.iisobrenome@domain.com");
		
	novoEnfermeiro.setNome("ENFERMEIRO VIII SOBRENOME");
	novoEnfermeiro.setCpf("13556845440");
	novoEnfermeiro.setCoren("15000");
	novoEnfermeiro.setCartaoSus("898 0001 1121 0099");
	novoEnfermeiro.setEmail("enfermeiro.xsobrenome@domain.com");
		
	enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
		
	enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(novoEnfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
    }
    
    @Test 
    public void testSalvarCpfSusTodoSistema(){
    
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("ENTIDADE IX SOBRENOME");
	enfermeiro.setCpf("91184468680");
	enfermeiro.setCoren("19987");
	enfermeiro.setCartaoSus("898 2221 0121 9994");
	enfermeiro.setEmail("entidade.sobrenome@domain.com");
        
        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();
    }
    
    @Test
    public void testFindAll() {

        Enfermeiro enfermeiro = new Enfermeiro();

        enfermeiro.setNome("ENFERMEIRO X SOBRENOME");
        enfermeiro.setCpf("03782681398");
        enfermeiro.setCoren("16000");
        enfermeiro.setCartaoSus("756 0000 0000 1010");
        enfermeiro.setEmail("enfermeiro.sobrenome@domain.com");

        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();

        listaEnfermeiros = (List<Enfermeiro>) new ArrayList<Enfermeiro>();
        listaEnfermeiros = enfermeiroDao.findAll();

        assertFalse(0 == listaEnfermeiros.size());
    }
 
    @Test
    public void testFindById() {

        Enfermeiro enfermeiro = new Enfermeiro();

        enfermeiro.setNome("ENFERMEIRO XI SOBRENOME");
        enfermeiro.setCpf("44198144540");
        enfermeiro.setCoren("16001");
        enfermeiro.setCartaoSus("756 0000 0000 1011");
        enfermeiro.setEmail("enfermeiro.sobrenome@domain.com");
        
        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();

        listaEnfermeiros = (List<Enfermeiro>) new ArrayList<Enfermeiro>();
        listaEnfermeiros = enfermeiroDao.findAll();

        for (Enfermeiro enfermeiro1 : listaEnfermeiros) {

            if (enfermeiro1.getCpf().equals(enfermeiro.getCpf())) {
                id = enfermeiro1.getId();
            }
        }
        
        Enfermeiro novoEnfermeiro = new Enfermeiro();
        novoEnfermeiro = enfermeiroDao.findById(id);
        assertEquals(enfermeiro.getCpf(), novoEnfermeiro.getCpf());
    }
    
    @Test
    public void testFindByIdInexistente() {

        Enfermeiro enfermeiro = new Enfermeiro();

        enfermeiro.setNome("ENFERMEIRO XII SOBRENOME");
        enfermeiro.setCpf("70128316772");
        enfermeiro.setCoren("16002");
        enfermeiro.setCartaoSus("756 0000 0000 1012");
        enfermeiro.setEmail("enfermeiro.sobrenome@domain.com");
        
        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();

        Enfermeiro novoEnfermeiro = new Enfermeiro();
        
        assertNull(novoEnfermeiro = enfermeiroDao.findById(0L));
    }
    
    @Test
    public void testDelete() {

        Enfermeiro enfermeiro = new Enfermeiro();

        enfermeiro.setNome("ENFERMEIRO XIII SOBRENOME");
        enfermeiro.setCpf("63434855033");
        enfermeiro.setCoren("16003");
        enfermeiro.setCartaoSus("756 0000 0000 1013");
        enfermeiro.setEmail("enfermeiro.sobrenome@domain.com");

        enfermeiroDao.getEntityManager().getTransaction().begin();
        enfermeiroDao.salvar(enfermeiro);
        enfermeiroDao.getEntityManager().getTransaction().commit();

        listaEnfermeiros = (List<Enfermeiro>) new ArrayList<Enfermeiro>();
        listaEnfermeiros = enfermeiroDao.findAll();

        for (Enfermeiro enfermeiro1 : listaEnfermeiros) {

            if (enfermeiro1.getCpf().equals(enfermeiro.getCpf())) {
                id = enfermeiro1.getId();
                enfermeiro = enfermeiro1;
            }
        }
        enfermeiroDao.delete(enfermeiro);
        
        assertNull(enfermeiroDao.findById(id));
        
    }
    
}
