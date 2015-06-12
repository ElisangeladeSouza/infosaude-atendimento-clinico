package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.FichaAtendimentoDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
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
    
    public FichaAtendimentoDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        fichaAtendimentoDao = new FichaAtendimentoDao();
        dateTimeUtilBean = new DateTimeUtilBean();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        fichaAtendimentoDao.setEntityManager(entityManager);    
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
        
        fichaAtendimento.setAtendimento("Atendimento 1");
        fichaAtendimento.setDestino("Odontologo");
        
        fichaAtendimentoDao.getEntityManager().getTransaction().begin();
        fichaAtendimentoDao.salvar(fichaAtendimento);
        fichaAtendimentoDao.getEntityManager().getTransaction().commit();
        
        listaFichaAtendimentos = (List<FichaAtendimento>) new ArrayList<FichaAtendimento>();
        listaFichaAtendimentos = fichaAtendimentoDao.findAll();

        for (FichaAtendimento fichaAtendimento1 : listaFichaAtendimentos) {

            if (fichaAtendimento1.getAtendimento().equals(fichaAtendimento.getAtendimento())) {
                id = fichaAtendimento1.getId();
            }
        }
        
        FichaAtendimento novaFichaAtendimento = new FichaAtendimento();
        novaFichaAtendimento = fichaAtendimentoDao.findById(id);
        assertEquals(fichaAtendimento.getAtendimento(), novaFichaAtendimento.getAtendimento());
    }
    
    @Test 
    public void testSalvarFichaAtendimentoTodosCampos(){
        FichaAtendimento fichaAtendimento = new FichaAtendimento();
        
        fichaAtendimento.setAtendimento("Atendimento 2");
        fichaAtendimento.setData(dateTimeUtilBean.getDateToday());
        fichaAtendimento.setDestino("Odontologo");
        
        fichaAtendimentoDao.getEntityManager().getTransaction().begin();
        fichaAtendimentoDao.salvar(fichaAtendimento);
        fichaAtendimentoDao.getEntityManager().getTransaction().commit();
        
        listaFichaAtendimentos = (List<FichaAtendimento>) new ArrayList<FichaAtendimento>();
        listaFichaAtendimentos = fichaAtendimentoDao.findAll();

        for (FichaAtendimento fichaAtendimento1 : listaFichaAtendimentos) {

            if (fichaAtendimento1.getAtendimento().equals(fichaAtendimento.getAtendimento())) {
                id = fichaAtendimento1.getId();
            }
        }
        
        FichaAtendimento novaFichaAtendimento = new FichaAtendimento();
        novaFichaAtendimento = fichaAtendimentoDao.findById(id);
        assertEquals(fichaAtendimento.getAtendimento(), novaFichaAtendimento.getAtendimento());
        
    }
    
    @Test
    public void testFindAll() {
        
        FichaAtendimento fichaAtendimento = new FichaAtendimento();
        
        fichaAtendimento.setAtendimento("Atendimento 3");
        fichaAtendimento.setData(dateTimeUtilBean.getDateToday());
        fichaAtendimento.setDestino("Médico");
        
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
        
        fichaAtendimento.setAtendimento("Atendimento 4");
        fichaAtendimento.setData(dateTimeUtilBean.getDateToday());
        fichaAtendimento.setDestino("Enfermeiro");
        
        fichaAtendimentoDao.getEntityManager().getTransaction().begin();
        fichaAtendimentoDao.salvar(fichaAtendimento);
        fichaAtendimentoDao.getEntityManager().getTransaction().commit();
        
        listaFichaAtendimentos = (List<FichaAtendimento>) new ArrayList<FichaAtendimento>();
        listaFichaAtendimentos = fichaAtendimentoDao.findAll();

        for (FichaAtendimento fichaAtendimento1 : listaFichaAtendimentos) {

            if (fichaAtendimento1.getAtendimento().equals(fichaAtendimento.getAtendimento())) {
                id = fichaAtendimento1.getId();
            }
        }
        
        FichaAtendimento novaFichaAtendimento = new FichaAtendimento();
        novaFichaAtendimento = fichaAtendimentoDao.findById(id);
        assertEquals(fichaAtendimento.getAtendimento(), novaFichaAtendimento.getAtendimento());
    }
    
    @Test
    public void testFindByIdInexistente() {
        
        FichaAtendimento fichaAtendimento = new FichaAtendimento();
        
        fichaAtendimento.setAtendimento("Atendimento 5");
        fichaAtendimento.setData(dateTimeUtilBean.getDateToday());
        fichaAtendimento.setDestino("Técnico em Enfermagem");
        
        fichaAtendimentoDao.getEntityManager().getTransaction().begin();
        fichaAtendimentoDao.salvar(fichaAtendimento);
        fichaAtendimentoDao.getEntityManager().getTransaction().commit();
        
        FichaAtendimento novaFichaAtendimento = new FichaAtendimento();
        
        assertNull(novaFichaAtendimento = fichaAtendimentoDao.findById(0L));
    }
    
    @Test
    public void testDelete() {
        
        FichaAtendimento fichaAtendimento = new FichaAtendimento();
        
        fichaAtendimento.setAtendimento("Atendimento 6");
        fichaAtendimento.setData(dateTimeUtilBean.getDateToday());
        fichaAtendimento.setDestino("Técnico em Enfermagem");
        
        fichaAtendimentoDao.getEntityManager().getTransaction().begin();
        fichaAtendimentoDao.salvar(fichaAtendimento);
        fichaAtendimentoDao.getEntityManager().getTransaction().commit();
        
        listaFichaAtendimentos = (List<FichaAtendimento>) new ArrayList<FichaAtendimento>();
        listaFichaAtendimentos = fichaAtendimentoDao.findAll();

        for (FichaAtendimento fichaAtendimento1 : listaFichaAtendimentos) {

            if (fichaAtendimento1.getAtendimento().equals(fichaAtendimento.getAtendimento())) {
                id = fichaAtendimento1.getId();
                fichaAtendimento = fichaAtendimento1;
            }
        }
        fichaAtendimentoDao.delete(fichaAtendimento);
        
        assertNull(fichaAtendimentoDao.findById(id));
    }
    
}
