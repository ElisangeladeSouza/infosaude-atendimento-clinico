package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.TempoGestacional;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaPreNatal;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Gestante;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.FichaPreNatalService;
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
public class FichaPreNatalServiceTest {
    
    private static FichaPreNatal fichaPreNatal;
    private static FichaPreNatal novaFichaPreNatal;
    private static List<FichaPreNatal> listaFichaPreNatal;
    private static Long id;
    private static Gestante gestante;
    
    @Mock
    private FichaPreNatalService fichaPreNatalService;
    
    public FichaPreNatalServiceTest() {
        fichaPreNatalService = new FichaPreNatalService();
    }
    
    @BeforeClass
    public static void setUpClass() {
        gestante = new Gestante();
        gestante.setId(1L);
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        fichaPreNatal = new FichaPreNatal();
        novaFichaPreNatal = new FichaPreNatal();
    }
    
    @Test(expected = Exception.class)
    public void testFindByIdInexistente() {
        when(fichaPreNatalService.findById(0L)).thenThrow(new Exception());
        fichaPreNatal = fichaPreNatalService.findById(0L);
    }
    
    @Test
    public void testFindById() {
        fichaPreNatal.setFichaPreNatais(gestante);
        fichaPreNatal.setTempoGestacional(TempoGestacional.TRIMESTRE_1);
        
        when(fichaPreNatalService.findById(1L)).thenReturn(fichaPreNatal);
        novaFichaPreNatal = fichaPreNatalService.findById(1L);
        assertEquals(TempoGestacional.TRIMESTRE_1, novaFichaPreNatal.getTempoGestacional());
        assertEquals(gestante.getId(), novaFichaPreNatal.getFichaPreNatais().getId());
    }
    
    @Test(expected = Exception.class)
    public void testFindAllNenhumSalvo() {
        when(fichaPreNatalService.findAll()).thenThrow(new Exception());
        fichaPreNatalService.findAll();
    }
    
    @Test
    public void testFindAll() {
        fichaPreNatal.setFichaPreNatais(gestante);
        fichaPreNatal.setTempoGestacional(TempoGestacional.TRIMESTRE_3);
        listaFichaPreNatal = (List<FichaPreNatal>) new ArrayList<FichaPreNatal>();
        listaFichaPreNatal.add(fichaPreNatal);
        when(fichaPreNatalService.findAll()).thenReturn(listaFichaPreNatal);
        assertFalse(listaFichaPreNatal.isEmpty());
    }
    
}
