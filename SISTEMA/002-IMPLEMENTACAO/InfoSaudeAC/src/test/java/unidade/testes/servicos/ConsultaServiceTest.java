package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Consulta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ConsultaService;
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
 * @author wilde
 */
public class ConsultaServiceTest {

    private static Consulta consulta;
    private static Consulta novaConsulta;
    private static List<Consulta> listaConsultas;
    private static Long id;
    private static FichaAtendimento fichaAtendimento;

    @Mock
    private ConsultaService consultaService;

    /**
     *
     */
    public ConsultaServiceTest() {

        consultaService = new ConsultaService();

    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {

        fichaAtendimento = new FichaAtendimento();
        fichaAtendimento.setId(1L);

    }

    /**
     *
     */
    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        consulta = new Consulta();
        novaConsulta = new Consulta();
    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testFindByIdInexistente() {

        when(consultaService.findById(0L)).thenThrow(new Exception());
        consulta = consultaService.findById(0L);
    }

    /**
     *
     */
    @Test
    public void testFindById() {

        consulta.setPrescricao("Dipirona");
        consulta.setFichaAtendimento(fichaAtendimento);

        when(consultaService.findById(1L)).thenReturn(consulta);
        novaConsulta = consultaService.findById(1L);
        assertEquals("Dipirona", consulta.getPrescricao());
        assertEquals(fichaAtendimento.getId(), novaConsulta.getFichaAtendimento().getId());

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testFindAllNenhumSalvo() {

        when(consultaService.findAll()).thenThrow(new Exception());
        consultaService.findAll();

    }

    /**
     *
     */
    @Test
    public void testFindAll() {

        consulta.setPrescricao("Amoxicilina");
        consulta.setFichaAtendimento(fichaAtendimento);

        listaConsultas = (List<Consulta>) new ArrayList<Consulta>();
        listaConsultas.add(consulta);

        when(consultaService.findAll()).thenReturn(listaConsultas);

        assertFalse(listaConsultas.isEmpty());

    }
}
