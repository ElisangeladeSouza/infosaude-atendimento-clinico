package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Gestante;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.GestanteService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class GestanteServiceTest {
    
    private static Gestante gestante;
    private static Gestante novaGestante;
    
    @Mock
    private GestanteService gestanteService;
    
    public GestanteServiceTest() {
        gestanteService = new GestanteService();
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        gestante = new Gestante();
        novaGestante = new Gestante();
    }
    
    @Test
    public void testSaveCamposObrigatorios() {
        gestante.setMunicipioAtendimento("Monteiro");
        gestante.setNomeEstabelecimentoSaude("UBS 4");
        gestante.setNomeProfissional("Maria de Lourdes");
        gestante.setCartaoSusProfissional("937 8126 4027 7294");

        when(gestanteService.findById(1L)).thenReturn(gestante);
        novaGestante = gestanteService.findById(1L);
        assertEquals("Monteiro", gestante.getMunicipioAtendimento());
        assertEquals("UBS 4", gestante.getNomeEstabelecimentoSaude());
        assertEquals("Maria de Lourdes", gestante.getNomeProfissional());
        assertEquals("937 8126 4027 7294", gestante.getCartaoSusProfissional());
    }
    
    @Test(expected = Exception.class)
    public void testFindByIdInexistente() {
        when(gestanteService.findById(0L)).thenThrow(new Exception());
        gestante = gestanteService.findById(0L);
    }
    
    @Test
    public void testFindByIdExistente() {
        gestante.setMunicipioAtendimento("Sumé");
        gestante.setNomeEstabelecimentoSaude("UBS 2");
        gestante.setNomeProfissional("Joelton Quirino");
        gestante.setCartaoSusProfissional("006 8264 0027 6432");

        when(gestanteService.findById(1L)).thenReturn(gestante);
        novaGestante = gestanteService.findById(1L);
        assertEquals("Sumé", gestante.getMunicipioAtendimento());
        assertEquals("UBS 2", gestante.getNomeEstabelecimentoSaude());
        assertEquals("Joelton Quirino", gestante.getNomeProfissional());
        assertEquals("006 8264 0027 6432", gestante.getCartaoSusProfissional());

    }
    
    @Test
    public void testFindAll() {
        List<Gestante> listaGestantes = new ArrayList<>();

        gestante.setMunicipioAtendimento("Amparo");
        gestante.setNomeEstabelecimentoSaude("UBS 7");
        gestante.setNomeProfissional("Patrícia Silva");

        listaGestantes = (List<Gestante>) new ArrayList<Gestante>();
        listaGestantes.add(gestante);

        when(gestanteService.findAll()).thenReturn(listaGestantes);

        assertFalse(listaGestantes.isEmpty());

    }
    
}
