package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Destino;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Paciente;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.FichaAtendimentoService;
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
public class FichaAtendimentoServiceTest {

    private static FichaAtendimento fichaAtendimento;
    private static FichaAtendimento novaFichaAtendimento;
    private static List<FichaAtendimento> listaFichaAtendimentos;
    private static Long id;
    private static Paciente paciente;

    @Mock
    private FichaAtendimentoService fichaAtendimentoService;

    /**
     *
     */
    public FichaAtendimentoServiceTest() {
        fichaAtendimentoService = new FichaAtendimentoService();

    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        paciente = new Paciente();
        paciente.setId(1L);

    }

    /**
     *
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        fichaAtendimento = new FichaAtendimento();
        novaFichaAtendimento = new FichaAtendimento();
    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testFindByIdInexistente() {
        when(fichaAtendimentoService.findById(0L)).thenThrow(new Exception());
        fichaAtendimento = fichaAtendimentoService.findById(0L);
    }

    /**
     *
     */
    @Test
    public void testFindById() {
        fichaAtendimento.setPaciente(paciente);
        fichaAtendimento.setDestino(Destino.MEDICO);

        when(fichaAtendimentoService.findById(1L)).thenReturn(fichaAtendimento);
        novaFichaAtendimento = fichaAtendimentoService.findById(1L);
        assertEquals(Destino.MEDICO, novaFichaAtendimento.getDestino());
        assertEquals(paciente.getId(), novaFichaAtendimento.getPaciente().getId());

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testFindAllNenhumSalvo() {
        when(fichaAtendimentoService.findAll()).thenThrow(new Exception());
        fichaAtendimentoService.findAll();

    }

    /**
     *
     */
    @Test
    public void testFindAll() {
        fichaAtendimento.setPaciente(paciente);
        fichaAtendimento.setDestino(Destino.ENFERMEIRO);

        listaFichaAtendimentos = (List<FichaAtendimento>) new ArrayList<FichaAtendimento>();
        listaFichaAtendimentos.add(fichaAtendimento);

        when(fichaAtendimentoService.findAll()).thenReturn(listaFichaAtendimentos);

        assertFalse(listaFichaAtendimentos.isEmpty());

    }
}
