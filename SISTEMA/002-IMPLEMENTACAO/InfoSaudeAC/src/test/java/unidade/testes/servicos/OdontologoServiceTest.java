package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Odontologo;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.OdontologoService;
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
public class OdontologoServiceTest {

    private static Odontologo odontologo;
    private static Odontologo novoOdontologo;

    @Mock
    private OdontologoService odontologoService;

    /**
     *
     */
    public OdontologoServiceTest() {
        odontologoService = new OdontologoService();

    }

    /**
     *
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        odontologo = new Odontologo();
        novoOdontologo = new Odontologo();
    }

    /**
     *
     */
    @Test
    public void testSaveCamposObrigatorios() {
        odontologo.setCartaoSusOdontologo("777 9876 8877 2244");
        odontologo.setCro("9687");
        odontologo.setNome("ISABELLE MAURICE");
        odontologo.setCpfOdontologo("09827885685");

        when(odontologoService.findById(1L)).thenReturn(odontologo);
        novoOdontologo = odontologoService.findById(1L);
        assertEquals("ISABELLE MAURICE", odontologo.getNome());
        assertEquals("09827885685", odontologo.getCpfOdontologo());
        assertEquals("9687", odontologo.getCro());
        assertEquals("777 9876 8877 2244", odontologo.getCartaoSusOdontologo());
    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testFindByIdInexistente() {
        when(odontologoService.findById(0L)).thenThrow(new Exception());
        odontologo = odontologoService.findById(0L);
    }

    /**
     *
     */
    @Test
    public void testFindByIdExistente() {
        odontologo.setNome("LUIS ARTHUR");
        odontologo.setCpfOdontologo("88378682862");
        odontologo.setCartaoSusOdontologo("123 9876 1234 9876");
        odontologo.setCro("19147");

        when(odontologoService.findById(1L)).thenReturn(odontologo);
        novoOdontologo = odontologoService.findById(1L);
        assertEquals("LUIS ARTHUR", odontologo.getNome());
        assertEquals("88378682862", odontologo.getCpfOdontologo());
        assertEquals("19147", odontologo.getCro());
        assertEquals("123 9876 1234 9876", odontologo.getCartaoSusOdontologo());

    }

    /**
     *
     */
    @Test
    public void testFindAll() {
        List<Odontologo> listaOdontologos = new ArrayList<>();

        odontologo.setNome("LUCIUS MALLAFYORI");
        odontologo.setCpfOdontologo("31422203565");
        odontologo.setCartaoSusOdontologo("585 9876 4444 7890");

        listaOdontologos = (List<Odontologo>) new ArrayList<Odontologo>();
        listaOdontologos.add(odontologo);

        when(odontologoService.findAll()).thenReturn(listaOdontologos);

        assertFalse(listaOdontologos.isEmpty());

    }
}
