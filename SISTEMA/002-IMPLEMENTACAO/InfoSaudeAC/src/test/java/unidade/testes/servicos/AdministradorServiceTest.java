package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Administrador;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.AdministradorService;
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
 * @author wilde <wildearruda@gmail.com>
 */
public class AdministradorServiceTest {

    private static Administrador administrador;
    private static Administrador novoAdministrador;

    @Mock
    private AdministradorService administradorService;

    /**
     *
     */
    public AdministradorServiceTest() {

        administradorService = new AdministradorService();

    }

    /**
     *
     */
    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        administrador = new Administrador();
        novoAdministrador = new Administrador();
    }

    /**
     *
     */
    @Test
    public void testSaveCamposObrigatorios() {

        administrador.setCartaoSusAdministrador("777 1234 1111 9876");
        administrador.setNome("MARTA SANHASSU");
        administrador.setCpfAdministrador("65076065884");

        when(administradorService.findById(1L)).thenReturn(administrador);

        novoAdministrador = administradorService.findById(1L);
        assertEquals("MARTA SANHASSU", administrador.getNome());
        assertEquals("65076065884", administrador.getCpfAdministrador());
        assertEquals("777 1234 1111 9876", administrador.getCartaoSusAdministrador());
    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testFindByIdInexistente() {
        when(administradorService.findById(0L)).thenThrow(new Exception());
        administrador = administradorService.findById(0L);
    }

    /**
     *
     */
    @Test
    public void testFindById() {

        administrador.setNome("LUIS VITON");
        administrador.setCpfAdministrador("15489262303");
        administrador.setCartaoSusAdministrador("585 5678 0000 5432");

        when(administradorService.findById(1L)).thenReturn(administrador);
        administrador = administradorService.findById(1L);
        assertEquals("LUIS VITON", administrador.getNome());
        assertEquals("15489262303", administrador.getCpfAdministrador());
        assertEquals("585 5678 0000 5432", administrador.getCartaoSusAdministrador());

    }

    /**
     *
     */
    @Test
    public void testFindAll() {

        List<Administrador> listaAdministradores = new ArrayList<>();

        administrador.setNome("LUCIUS MALLAFYORI");
        administrador.setCpfAdministrador("31422203565");
        administrador.setCartaoSusAdministrador("585 9876 4444 7890");

        listaAdministradores = (List<Administrador>) new ArrayList<Administrador>();
        listaAdministradores.add(administrador);

        when(administradorService.findAll()).thenReturn(listaAdministradores);

        assertFalse(listaAdministradores.isEmpty());

    }
}
