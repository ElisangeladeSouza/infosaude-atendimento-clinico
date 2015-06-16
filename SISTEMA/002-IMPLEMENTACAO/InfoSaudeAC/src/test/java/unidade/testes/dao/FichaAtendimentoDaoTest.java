package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.FichaAtendimentoDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Destino;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Paciente;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elisangela
 */
public class FichaAtendimentoDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static FichaAtendimentoDao fichaAtendimentoDao;
    private static DateTimeUtilBean dateTimeUtilBean;
    private static List<FichaAtendimento> listaFichaAtendimentos;
    private static Long id;
    private static Paciente paciente;
    
    public FichaAtendimentoDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        fichaAtendimentoDao = new FichaAtendimentoDao();
        dateTimeUtilBean = new DateTimeUtilBean();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        fichaAtendimentoDao.setEntityManager(entityManager);
    
        
        paciente =  new Paciente();
        paciente.setCpf("33458391487");
        paciente.setNome("Jose Menezes");
        paciente.setCartaoSus("898 0001 1147 7896");
        paciente.setId(1L);
        
    }
    
    @Test (expected = Exception.class)
    public void testSalvarFichaAtendimentoNull() {

        FichaAtendimento fichaAtendimento = new FichaAtendimento();
        
        fichaAtendimentoDao.getEntityManager().getTransaction().begin();
        fichaAtendimentoDao.salvar(fichaAtendimento);
        fichaAtendimentoDao.getEntityManager().getTransaction().commit();
        
    }
    
    @Test 
    public void testSalvarFichaAtendimentoCamposObrigatorios(){

        FichaAtendimento fichaAtendimento = new FichaAtendimento();
        
        
        fichaAtendimento.setPaciente(paciente);
        fichaAtendimento.setDestino(Destino.ODONTOLOGO);
        fichaAtendimento.setData(dateTimeUtilBean.getDateToday());
        
        
        fichaAtendimentoDao.getEntityManager().getTransaction().begin();
        fichaAtendimentoDao.salvar(fichaAtendimento);
        fichaAtendimentoDao.getEntityManager().getTransaction().commit();
        
        listaFichaAtendimentos = (List<FichaAtendimento>) new ArrayList<FichaAtendimento>();
        listaFichaAtendimentos = fichaAtendimentoDao.findAll();

        for (FichaAtendimento fichaAtendimento1 : listaFichaAtendimentos) {

            if (fichaAtendimento1.getPaciente().equals(paciente)) {
                id = fichaAtendimento1.getId();
            }
        }
        
        FichaAtendimento novaFichaAtendimento = new FichaAtendimento();
        novaFichaAtendimento = fichaAtendimentoDao.findById(id);
        assertEquals(fichaAtendimento.getPaciente().getId(), novaFichaAtendimento.getPaciente().getId());
        assertEquals(fichaAtendimento.getPaciente().getCpf(), novaFichaAtendimento.getPaciente().getCpf());
        assertEquals(fichaAtendimento.getPaciente().getNome(), novaFichaAtendimento.getPaciente().getNome());
        assertEquals(fichaAtendimento.getPaciente().getCartaoSus(), novaFichaAtendimento.getPaciente().getCartaoSus());
        assertEquals(fichaAtendimento.getDestino(), novaFichaAtendimento.getDestino());
        
    }
    
    @Test
    public void testFindAll() {
        
        FichaAtendimento fichaAtendimento = new FichaAtendimento();
        
        fichaAtendimento.setData(dateTimeUtilBean.getDateToday());
        fichaAtendimento.setDestino(Destino.MEDICO);
        fichaAtendimento.setPaciente(paciente);
        
        fichaAtendimentoDao.getEntityManager().getTransaction().begin();
        fichaAtendimentoDao.salvar(fichaAtendimento);
        fichaAtendimentoDao.getEntityManager().getTransaction().commit();
        
        listaFichaAtendimentos = (List<FichaAtendimento>) new ArrayList<FichaAtendimento>();
        listaFichaAtendimentos = fichaAtendimentoDao.findAll();

        assertFalse(0 == listaFichaAtendimentos.size());
    }
    
    @Test
    public void testFindById() {
        
        FichaAtendimento fichaAtendimento = new FichaAtendimento();
        
        fichaAtendimento.setData(dateTimeUtilBean.getDateToday());
        fichaAtendimento.setDestino(Destino.ENFERMEIRO);
        fichaAtendimento.setPaciente(paciente);
        
        fichaAtendimentoDao.getEntityManager().getTransaction().begin();
        fichaAtendimentoDao.salvar(fichaAtendimento);
        fichaAtendimentoDao.getEntityManager().getTransaction().commit();
        
        listaFichaAtendimentos = (List<FichaAtendimento>) new ArrayList<FichaAtendimento>();
        listaFichaAtendimentos = fichaAtendimentoDao.findAll();

        for (FichaAtendimento fichaAtendimento1 : listaFichaAtendimentos) {

            if (fichaAtendimento1.getPaciente().equals(paciente)) {
                id = fichaAtendimento1.getId();
            }
        }
        
        FichaAtendimento novaFichaAtendimento = new FichaAtendimento();
        novaFichaAtendimento = fichaAtendimentoDao.findById(id);
        assertEquals(fichaAtendimento.getPaciente().getId(), novaFichaAtendimento.getPaciente().getId());
        assertEquals(fichaAtendimento.getPaciente().getCpf(), novaFichaAtendimento.getPaciente().getCpf());
        assertEquals(fichaAtendimento.getPaciente().getNome(), novaFichaAtendimento.getPaciente().getNome());
        assertEquals(fichaAtendimento.getPaciente().getCartaoSus(), novaFichaAtendimento.getPaciente().getCartaoSus());
        assertEquals(fichaAtendimento.getDestino(), novaFichaAtendimento.getDestino());
    }
    
    @Test
    public void testFindByIdInexistente() {
        assertNull(fichaAtendimentoDao.findById(0L));
    }
    
    @Test
    public void testDelete() {
        
        FichaAtendimento fichaAtendimento = new FichaAtendimento();
        
        fichaAtendimento.setData(dateTimeUtilBean.getDateToday());
        fichaAtendimento.setDestino(Destino.TRIAGEM);
        fichaAtendimento.setPaciente(paciente);
        
        fichaAtendimentoDao.getEntityManager().getTransaction().begin();
        fichaAtendimentoDao.salvar(fichaAtendimento);
        fichaAtendimentoDao.getEntityManager().getTransaction().commit();
        
        listaFichaAtendimentos = (List<FichaAtendimento>) new ArrayList<FichaAtendimento>();
        listaFichaAtendimentos = fichaAtendimentoDao.findAll();

        for (FichaAtendimento fichaAtendimento1 : listaFichaAtendimentos) {

            if (fichaAtendimento1.getPaciente().equals(paciente)) {
                id = fichaAtendimento1.getId();
                fichaAtendimento = fichaAtendimento1;
            }
        }
        fichaAtendimentoDao.delete(fichaAtendimento);
        
        assertNull(fichaAtendimentoDao.findById(id));
    }
    
}
