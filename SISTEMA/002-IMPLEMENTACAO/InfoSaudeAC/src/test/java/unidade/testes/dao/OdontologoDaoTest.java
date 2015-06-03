package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.OdontologoDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Odontologo;
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
public class OdontologoDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static OdontologoDao odontologoDao;
    private static DateTimeUtilBean dateTimeUtilBean;
    private static List<Odontologo> listaOdontologos;
    private static Long id;
    
    public OdontologoDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        odontologoDao = new OdontologoDao();
        dateTimeUtilBean = new DateTimeUtilBean();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        odontologoDao.setEntityManager(entityManager);    
    }
    

    @Test (expected = Exception.class)
    public void testSalvarOdontologoNull() {
        
        Odontologo odontologo = new Odontologo();
        
        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test 
    public void testSalvarOdontologoCamposObrigatorios(){
    
        Odontologo odontologo = new Odontologo();
        
        odontologo.setNome("ODONTOLOGO SOBRENOME");
	odontologo.setCpf("80828988447");
	odontologo.setCro("20010");
	odontologo.setCartaoSus("898 0001 9999 5555");
	odontologo.setEmail("odontologo.sobrenome@domain.com");
	odontologo.setCorOuRaca("");
	odontologo.setEnderecoBairro("");
	odontologo.setEnderecoCep("");
	odontologo.setEnderecoCidade("");
	odontologo.setEnderecoNumero("");
	odontologo.setEnderecoRua("");
	odontologo.setRg("");
	odontologo.setTelefone1("");
	odontologo.setTelefone2("");
        
        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();

        listaOdontologos = (List<Odontologo>) new ArrayList<Odontologo>();
        listaOdontologos = odontologoDao.findAll();

        for (Odontologo odontologo1 : listaOdontologos) {

            if (odontologo1.getCpf().equals(odontologo.getCpf())) {
                id = odontologo1.getId();
            }
        }
        
        Odontologo novoOdontologo = new Odontologo();
        novoOdontologo = odontologoDao.findById(id);
        assertEquals(odontologo.getCpf(), novoOdontologo.getCpf());
        
    }

    @Test 
    public void testSalvarOdontologoTodosCampos(){
    
        Odontologo odontologo = new Odontologo();
        
        odontologo.setNome("ODONTOLOGO I SOBRENOME");
	odontologo.setCpf("86457937500");
	odontologo.setCro("15987");
	odontologo.setCartaoSus("898 0002 9999 5555");
	odontologo.setEmail("odontologo.isobrenome@domain.com");
	odontologo.setCorOuRaca("PARDA");
	odontologo.setDataNascimento(dateTimeUtilBean.getDateToday());
	odontologo.setEnderecoBairro("BAIRRO");
	odontologo.setEnderecoCep("58500-000");
	odontologo.setEnderecoCidade("MONTEIRO");
	odontologo.setEnderecoEstado(Estados.PB);
	odontologo.setEnderecoNumero("1");
	odontologo.setEnderecoRua("DAS FLORES");
	odontologo.setRg("88555741-x");
	odontologo.setTelefone1("(83)9988-7766");
	odontologo.setTelefone2("(83)3305-0001");
        
        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
     
        listaOdontologos = (List<Odontologo>) new ArrayList<Odontologo>();
        listaOdontologos = odontologoDao.findAll();

        for (Odontologo odontologo1 : listaOdontologos) {

            if (odontologo1.getCpf().equals(odontologo.getCpf())) {
                id = odontologo1.getId();
            }
        }
        
        Odontologo novoOdontologo = new Odontologo();
        novoOdontologo = odontologoDao.findById(id);
        assertEquals(odontologo.getCpf(), novoOdontologo.getCpf());
    }
    
    @Test (expected = Exception.class)
    public void testSalvarOdontologoDuplicado(){
    
        Odontologo odontologo = new Odontologo();
        
        odontologo.setNome("ODONTOLOGO II SOBRENOME");
	odontologo.setCpf("85463248400");
	odontologo.setCro("15789");
	odontologo.setCartaoSus("898 0003 9999 5555");
	odontologo.setEmail("odontologo.iisobrenome@domain.com");
	odontologo.setCorOuRaca("PARDA");
	odontologo.setDataNascimento(dateTimeUtilBean.getDateToday());
	odontologo.setEnderecoBairro("BAIRRO");
	odontologo.setEnderecoCep("58500-000");
	odontologo.setEnderecoCidade("MONTEIRO");
	odontologo.setEnderecoEstado(Estados.CE);
	odontologo.setEnderecoNumero("1");
	odontologo.setEnderecoRua("DAS FLORES");
	odontologo.setRg("88555741-x");
	odontologo.setTelefone1("(83)9988-7766");
	odontologo.setTelefone2("(83)3305-0001");				
				
	odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
        
        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarOdontologoNome(){
    
        Odontologo odontologo = new Odontologo();
        
        odontologo.setNome("ODONTOLOGO III SOBRENOME");
   
        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarOdontologoCpf(){
    
        Odontologo odontologo = new Odontologo();
        
        odontologo.setCpf("01281363596");
   
        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarOdontologoCro(){
    
        Odontologo odontologo = new Odontologo();
        
        odontologo.setCro("15111");
   
        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarOdontologoSus(){
    
        Odontologo odontologo = new Odontologo();
        
        odontologo.setCartaoSus("898 0004 9999 5555");
   
        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarOdontologoEmail(){
    
        Odontologo odontologo = new Odontologo();
        
        odontologo.setEmail("odontologo.iiisobrenome@domain.com");
   
        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarOdontologoNomeCpf(){
    
        Odontologo odontologo = new Odontologo();
        
        odontologo.setNome("ODONTOLOGO IV SOBRENOME");
	odontologo.setCpf("04747445820");
   
        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarOdontologoNomeCpfCro(){
    
        Odontologo odontologo = new Odontologo();
        
        odontologo.setNome("ODONTOLOGO V SOBRENOME");
	odontologo.setCpf("04747445820");
        odontologo.setCro("15111");
        
        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarOdontologoCpfDuplicado(){
    
        Odontologo odontologo = new Odontologo();
        Odontologo novoOdontologo = new Odontologo();
		
        odontologo.setNome("ODONTOLOGO VI SOBRENOME");
	odontologo.setCpf("24239270960");
	odontologo.setCro("15789");
	odontologo.setCartaoSus("898 0006 9999 5555");
	odontologo.setEmail("odontologo.iisobrenome@domain.com");
		
	novoOdontologo.setNome("ODONTOLOGO X SOBRENOME");
	novoOdontologo.setCpf("24239270960");
	novoOdontologo.setCro("15000");
	novoOdontologo.setCartaoSus("898 0007 9999 5555");
	novoOdontologo.setEmail("odontologo.xsobrenome@domain.com");
		
	odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
		
	odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(novoOdontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
    }
    
    @Test (expected = Exception.class)
    public void testSalvarOdontologoSusDuplicado(){
    
        Odontologo odontologo = new Odontologo();
        Odontologo novoOdontologo = new Odontologo();
		
        odontologo.setNome("ODONTOLOGO VII SOBRENOME");
	odontologo.setCpf("02890781135");
	odontologo.setCro("15789");
	odontologo.setCartaoSus("898 0008 9999 5555");
	odontologo.setEmail("odontologo.iisobrenome@domain.com");
		
	novoOdontologo.setNome("ODONTOLOGO X SOBRENOME");
	novoOdontologo.setCpf("12740714297");
	novoOdontologo.setCro("15000");
	novoOdontologo.setCartaoSus("898 0008 9999 5555");
	novoOdontologo.setEmail("odontologo.xsobrenome@domain.com");
		
	odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
		
	odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(novoOdontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
    }
    
    @Test 
    public void testSalvarCpfSusTodoSistema(){
    
        Odontologo odontologo = new Odontologo();
        
        odontologo.setNome("ENTIDADE VIII SOBRENOME");
	odontologo.setCpf("91184468680");
	odontologo.setCro("20011");
	odontologo.setCartaoSus("898 2221 0121 9994");
	odontologo.setEmail("entidade.sobrenome@domain.com");
        
        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();
    }
    
    @Test
    public void testFindAll() {

        Odontologo odontologo = new Odontologo();

        odontologo.setNome("ODONTOLOGO IX SOBRENOME");
        odontologo.setCpf("02171614218");
        odontologo.setCro("20014");
        odontologo.setCartaoSus("756 0000 0000 0030");
        odontologo.setEmail("odontologo.sobrenome@domain.com");

        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();

        listaOdontologos = (List<Odontologo>) new ArrayList<Odontologo>();
        listaOdontologos = odontologoDao.findAll();

        assertFalse(0 == listaOdontologos.size());
    }
 
    @Test
    public void testFindById() {

        Odontologo odontologo = new Odontologo();

        odontologo.setNome("ODONTOLOGO X SOBRENOME");
        odontologo.setCpf("33022384521");
        odontologo.setCro("20015");
        odontologo.setCartaoSus("756 0000 0000 0031");
        odontologo.setEmail("odontologo.sobrenome@domain.com");
        
        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();

        listaOdontologos = (List<Odontologo>) new ArrayList<Odontologo>();
        listaOdontologos = odontologoDao.findAll();

        for (Odontologo odontologo1 : listaOdontologos) {

            if (odontologo1.getCpf().equals(odontologo.getCpf())) {
                id = odontologo1.getId();
            }
        }
        
        Odontologo novoOdontologo = new Odontologo();
        novoOdontologo = odontologoDao.findById(id);
        assertEquals(odontologo.getCpf(), novoOdontologo.getCpf());
    }
    
    @Test
    public void testFindByIdInexistente() {

        Odontologo odontologo = new Odontologo();

        odontologo.setNome("ODONTOLOGO XI SOBRENOME");
        odontologo.setCpf("81516485467");
        odontologo.setCro("20016");
        odontologo.setCartaoSus("756 0000 0000 0035");
        odontologo.setEmail("odontologo.sobrenome@domain.com");
        
        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();

        Odontologo novoOdontologo = new Odontologo();
        
        assertNull(novoOdontologo = odontologoDao.findById(0L));
    }
    
    @Test
    public void testDelete() {

        Odontologo odontologo = new Odontologo();

        odontologo.setNome("ODONTOLOGO XII SOBRENOME");
        odontologo.setCpf("23646781963");
        odontologo.setCro("20017");
        odontologo.setCartaoSus("756 0000 0000 0034");
        odontologo.setEmail("odontologo.sobrenome@domain.com");

        odontologoDao.getEntityManager().getTransaction().begin();
        odontologoDao.salvar(odontologo);
        odontologoDao.getEntityManager().getTransaction().commit();

        listaOdontologos = (List<Odontologo>) new ArrayList<Odontologo>();
        listaOdontologos = odontologoDao.findAll();

        for (Odontologo odontologo1 : listaOdontologos) {

            if (odontologo1.getCpf().equals(odontologo.getCpf())) {
                id = odontologo1.getId();
                odontologo = odontologo1;
            }
        }
        odontologoDao.delete(odontologo);
        
        assertNull(odontologoDao.findById(id));
        
    }
    
}
