package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.RecepcionistaDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Recepcionista;
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
public class RecepcionistaDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static RecepcionistaDao recepcionistaDao;
    private static DateTimeUtilBean dateTimeUtilBean;
    private static List<Recepcionista> listaRecepcionistas;
    private static Long id;
    
    public RecepcionistaDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        recepcionistaDao = new RecepcionistaDao();
        dateTimeUtilBean = new DateTimeUtilBean();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        recepcionistaDao.setEntityManager(entityManager);    
    }
    

    @Test (expected = Exception.class)
    public void testSalvarRecepcionistaNull() {
        
        Recepcionista recepcionista = new Recepcionista();
        
        recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test 
    public void testSalvarRecepcionistaCamposObrigatorios(){
    
        Recepcionista recepcionista = new Recepcionista();
        
        recepcionista.setNome("RECEPCIONISTA SOBRENOME");
	recepcionista.setCpf("55845391040");
	recepcionista.setCartaoSus("898 0017 9999 5555");
	recepcionista.setEmail("recepcionista.sobrenome@domain.com");
	recepcionista.setCorOuRaca("");
	recepcionista.setEnderecoBairro("");
	recepcionista.setEnderecoCep("");
	recepcionista.setEnderecoCidade("");
	recepcionista.setEnderecoNumero("");
	recepcionista.setEnderecoRua("");
	recepcionista.setRg("");
	recepcionista.setTelefone1("");
	recepcionista.setTelefone2("");
        
        recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
     
        listaRecepcionistas = (List<Recepcionista>) new ArrayList<Recepcionista>();
        listaRecepcionistas = recepcionistaDao.findAll();

        for (Recepcionista recepcionista1 : listaRecepcionistas) {

            if (recepcionista1.getCpf().equals(recepcionista.getCpf())) {
                id = recepcionista1.getId();
            }
        }
        
        Recepcionista novoRecepcionista = new Recepcionista();
        novoRecepcionista = recepcionistaDao.findById(id);
        assertEquals(recepcionista.getCpf(), novoRecepcionista.getCpf());
    }

    @Test 
    public void testSalvarRecepcionistaTodosCampos(){
    
        Recepcionista recepcionista = new Recepcionista();
        
        recepcionista.setNome("RECEPCIONISTA I SOBRENOME");
	recepcionista.setCpf("00644365862");
	recepcionista.setCartaoSus("898 0018 9999 5555");
	recepcionista.setEmail("recepcionista.isobrenome@domain.com");
	recepcionista.setCorOuRaca("PARDA");
	recepcionista.setDataNascimento(dateTimeUtilBean.getDateToday());
	recepcionista.setEnderecoBairro("BAIRRO");
	recepcionista.setEnderecoCep("58500-000");
	recepcionista.setEnderecoCidade("MONTEIRO");
	recepcionista.setEnderecoEstado(Estados.PB);
	recepcionista.setEnderecoNumero("1");
	recepcionista.setEnderecoRua("DAS FLORES");
	recepcionista.setRg("88555741-x");
	recepcionista.setTelefone1("(83)9988-7766");
	recepcionista.setTelefone2("(83)3305-0001");
        
        recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
     
        listaRecepcionistas = (List<Recepcionista>) new ArrayList<Recepcionista>();
        listaRecepcionistas = recepcionistaDao.findAll();

        for (Recepcionista recepcionista1 : listaRecepcionistas) {

            if (recepcionista1.getCpf().equals(recepcionista.getCpf())) {
                id = recepcionista1.getId();
            }
        }
        
        Recepcionista novoRecepcionista = new Recepcionista();
        novoRecepcionista = recepcionistaDao.findById(id);
        assertEquals(recepcionista.getCpf(), novoRecepcionista.getCpf());
    }
    
    @Test (expected = Exception.class)
    public void testSalvarRecepcionistaDuplicado(){
    
        Recepcionista recepcionista = new Recepcionista();
        
        recepcionista.setNome("RECEPCIONISTA II SOBRENOME");
	recepcionista.setCpf("69553142621");
	recepcionista.setCartaoSus("898 0019 9999 5555");
	recepcionista.setEmail("recepcionista.iisobrenome@domain.com");
	recepcionista.setCorOuRaca("PARDA");
	recepcionista.setDataNascimento(dateTimeUtilBean.getDateToday());
	recepcionista.setEnderecoBairro("BAIRRO");
	recepcionista.setEnderecoCep("58500-000");
	recepcionista.setEnderecoCidade("MONTEIRO");
	recepcionista.setEnderecoEstado(Estados.CE);
	recepcionista.setEnderecoNumero("1");
	recepcionista.setEnderecoRua("DAS FLORES");
	recepcionista.setRg("88555741-x");
	recepcionista.setTelefone1("(83)9988-7766");
	recepcionista.setTelefone2("(83)3305-0001");				
				
	recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
        
        recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarRecepcionistaNome(){
    
        Recepcionista recepcionista = new Recepcionista();
        
        recepcionista.setNome("RECEPCIONISTA III SOBRENOME");
   
        recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarRecepcionistaCpf(){
    
        Recepcionista recepcionista = new Recepcionista();
        
        recepcionista.setCpf("53228328589");
   
        recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarRecepcionistaSus(){
    
        Recepcionista recepcionista = new Recepcionista();
        
        recepcionista.setCartaoSus("898 1120 9999 5555");
   
        recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarRecepcionistaEmail(){
    
        Recepcionista recepcionista = new Recepcionista();
        
        recepcionista.setEmail("recepcionista.iiisobrenome@domain.com");
   
        recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarRecepcionistaNomeCpf(){
    
        Recepcionista recepcionista = new Recepcionista();
        
        recepcionista.setNome("RECEPCIONISTA IV SOBRENOME");
	recepcionista.setCpf("95055773626");
   
        recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
        
    }
    
    
    @Test (expected = Exception.class)
    public void testSalvarRecepcionistaCpfDuplicado(){
    
        Recepcionista recepcionista = new Recepcionista();
        Recepcionista novoRecepcionista = new Recepcionista();
		
        recepcionista.setNome("RECEPCIONISTA V SOBRENOME");
	recepcionista.setCpf("48106254860");
	recepcionista.setCartaoSus("898 8020 9999 5555");
	recepcionista.setEmail("recepcionista.iisobrenome@domain.com");
		
	novoRecepcionista.setNome("RECEPCIONISTA VI SOBRENOME");
	novoRecepcionista.setCpf("48106254860");
	novoRecepcionista.setCartaoSus("898 7020 9999 5555");
	novoRecepcionista.setEmail("recepcionista.xsobrenome@domain.com");
		
	recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
		
	recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(novoRecepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
    }
    
    @Test (expected = Exception.class)
    public void testSalvarRecepcionistaSusDuplicado(){
    
        Recepcionista recepcionista = new Recepcionista();
        Recepcionista novoRecepcionista = new Recepcionista();
		
        recepcionista.setNome("RECEPCIONISTA VII SOBRENOME");
	recepcionista.setCpf("63237865249");
	recepcionista.setCartaoSus("898 6020 9999 5555");
	recepcionista.setEmail("recepcionista.iisobrenome@domain.com");
		
	novoRecepcionista.setNome("RECEPCIONISTA VIII SOBRENOME");
	novoRecepcionista.setCpf("64680771763");
	novoRecepcionista.setCartaoSus("898 6020 9999 5555");
	novoRecepcionista.setEmail("recepcionista.xsobrenome@domain.com");
		
	recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
		
	recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(novoRecepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
    }
    
    @Test 
    public void testSalvarCpfSusTodoSistema(){
    
        Recepcionista recepcionista = new Recepcionista();
        
        recepcionista.setNome("ENTIDADE IX SOBRENOME");
	recepcionista.setCpf("91184468680");
	recepcionista.setCartaoSus("898 2221 0121 9994");
	recepcionista.setEmail("entidade.sobrenome@domain.com");
        
        recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();
    }
 
    @Test
    public void testFindById() {

        Recepcionista recepcionista = new Recepcionista();

        recepcionista.setNome("RECEPCIONISTA X SOBRENOME");
        recepcionista.setCpf("86823499656");
        recepcionista.setCartaoSus("756 0000 0000 0008");
        recepcionista.setEmail("recepcionista.sobrenome@domain.com");
        
        recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();

        listaRecepcionistas = (List<Recepcionista>) new ArrayList<Recepcionista>();
        listaRecepcionistas = recepcionistaDao.findAll();

        for (Recepcionista recepcionista1 : listaRecepcionistas) {

            if (recepcionista1.getCpf().equals(recepcionista.getCpf())) {
                id = recepcionista1.getId();
            }
        }
        
        Recepcionista novoRecepcionista = new Recepcionista();
        novoRecepcionista = recepcionistaDao.findById(id);
        assertEquals(recepcionista.getCpf(), novoRecepcionista.getCpf());
    }
    
    @Test
    public void testFindByIdInexistente() {

        Recepcionista recepcionista = new Recepcionista();

        recepcionista.setNome("RECEPCIONISTA XI SOBRENOME");
        recepcionista.setCpf("48729885230");
        recepcionista.setCartaoSus("756 0000 0000 0010");
        recepcionista.setEmail("recepcionista.sobrenome@domain.com");
        
        recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();

        Recepcionista novoRecepcionista = new Recepcionista();
        
        assertNull(novoRecepcionista = recepcionistaDao.findById(0L));
    }
    
    @Test
    public void testDelete() {

        Recepcionista recepcionista = new Recepcionista();

        recepcionista.setNome("RECEPCIONISTA XII SOBRENOME");
        recepcionista.setCpf("34299885783");
        recepcionista.setCartaoSus("756 0000 0000 0011");
        recepcionista.setEmail("recepcionista.sobrenome@domain.com");

        recepcionistaDao.getEntityManager().getTransaction().begin();
        recepcionistaDao.salvar(recepcionista);
        recepcionistaDao.getEntityManager().getTransaction().commit();

        listaRecepcionistas = (List<Recepcionista>) new ArrayList<Recepcionista>();
        listaRecepcionistas = recepcionistaDao.findAll();

        for (Recepcionista recepcionista1 : listaRecepcionistas) {

            if (recepcionista1.getCpf().equals(recepcionista.getCpf())) {
                id = recepcionista1.getId();
                recepcionista = recepcionista1;
            }
        }
        recepcionistaDao.delete(recepcionista);
        
        assertNull(recepcionistaDao.findById(id));
        
    }
    
}
