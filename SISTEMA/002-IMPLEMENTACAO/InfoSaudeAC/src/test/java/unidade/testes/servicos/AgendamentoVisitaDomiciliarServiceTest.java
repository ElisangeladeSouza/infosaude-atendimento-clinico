package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.AgendamentoVisitaDomiciliar;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Paciente;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.AgendamentoVisitaDomiciliarService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class AgendamentoVisitaDomiciliarServiceTest {
    
    private static AgendamentoVisitaDomiciliar agendamentoVisitaDomiciliar;
    private static AgendamentoVisitaDomiciliar novoAgendamentoVisitaDomiciliar;
    private static List<AgendamentoVisitaDomiciliar> listaVisitasDomiciliares;
    private static Paciente paciente;
    
    @Mock
    private AgendamentoVisitaDomiciliarService agendamentoVisitaDomiciliarService;
    
    public AgendamentoVisitaDomiciliarServiceTest() {
        agendamentoVisitaDomiciliar = new AgendamentoVisitaDomiciliar();
    }
    
    @BeforeClass
    public static void setUpClass() {
        paciente = new Paciente();
        paciente.setId(1L);
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        agendamentoVisitaDomiciliar = new AgendamentoVisitaDomiciliar();
        novoAgendamentoVisitaDomiciliar = new AgendamentoVisitaDomiciliar();
    }
    
    @Test(expected = Exception.class)
    public void testFindByIdInexistente() {
        when(agendamentoVisitaDomiciliarService.findById(0L)).thenThrow(new Exception());
        agendamentoVisitaDomiciliar = agendamentoVisitaDomiciliarService.findById(0L);
    }
    
    @Test
    public void testFindById() {
        agendamentoVisitaDomiciliar.setPaciente(paciente);
        agendamentoVisitaDomiciliar.setEnfermeiro("Maria");
        
        when(agendamentoVisitaDomiciliarService.findById(1L)).thenReturn(agendamentoVisitaDomiciliar);
        novoAgendamentoVisitaDomiciliar = agendamentoVisitaDomiciliarService.findById(1L);
        assertEquals(paciente.getId(), novoAgendamentoVisitaDomiciliar.getPaciente().getId());
        assertEquals("Maria", novoAgendamentoVisitaDomiciliar.getEnfermeiro());
        
    }
    
    @Test(expected = Exception.class)
    public void testFindAllNenhumSalvo() {
        when(agendamentoVisitaDomiciliarService.findAll()).thenThrow(new Exception());
        agendamentoVisitaDomiciliarService.findAll();
    }
    
    @Test
    public void testFindAll() {
        agendamentoVisitaDomiciliar.setPaciente(paciente);
        agendamentoVisitaDomiciliar.setEnfermeiro("Conceição");
        
        listaVisitasDomiciliares = (List<AgendamentoVisitaDomiciliar>) new ArrayList<AgendamentoVisitaDomiciliar>();
        listaVisitasDomiciliares.add(agendamentoVisitaDomiciliar);
        
        when(agendamentoVisitaDomiciliarService.findAll()).thenReturn(listaVisitasDomiciliares);
        assertFalse(listaVisitasDomiciliares.isEmpty());

    }
}
