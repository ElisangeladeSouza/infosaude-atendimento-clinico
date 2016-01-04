package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Procedimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ProcedimentoService;
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
public class ProcedimentoServiceTest {

    private static Procedimento procedimento;
    private static Procedimento novoProcedimento;
    private static List<Procedimento> listaProcedimentos;
    private static Long id;
    private static FichaAtendimento fichaAtendimento;

    @Mock
    private ProcedimentoService procedimentoService;

    /**
     *
     */
    public ProcedimentoServiceTest() {
        procedimentoService = new ProcedimentoService();

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
        procedimento = new Procedimento();
        novoProcedimento = new Procedimento();
    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testFindByIdInexistente() {
        when(procedimentoService.findById(0L)).thenThrow(new Exception());
        procedimento = procedimentoService.findById(0L);
    }

    /**
     *
     */
    @Test
    public void testFindById() {
        procedimento.setDescricao("ACESSO A POLPA DENTÁRIA E MEDICAÇÃO(PORDENTE)");
        procedimento.setCodigo("0307020010");
        procedimento.setFichaAtendimento(fichaAtendimento);

        when(procedimentoService.findById(1L)).thenReturn(procedimento);
        novoProcedimento = procedimentoService.findById(1L);
        assertEquals("ACESSO A POLPA DENTÁRIA E MEDICAÇÃO(PORDENTE)", procedimento.getDescricao());
        assertEquals(fichaAtendimento.getId(), novoProcedimento.getFichaAtendimento().getId());
        assertEquals("0307020010", novoProcedimento.getCodigo());

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testFindAllNenhumSalvo() {
        when(procedimentoService.findAll()).thenThrow(new Exception());
        procedimentoService.findAll();

    }

    /**
     *
     */
    @Test
    public void testFindAll() {
        procedimento.setDescricao("ACESSO A POLPA DENTÁRIA E MEDICAÇÃO(PORDENTE)");
        procedimento.setCodigo("0307020010");
        procedimento.setFichaAtendimento(fichaAtendimento);

        listaProcedimentos = (List<Procedimento>) new ArrayList<Procedimento>();
        listaProcedimentos.add(procedimento);

        when(procedimentoService.findAll()).thenReturn(listaProcedimentos);

        assertFalse(listaProcedimentos.isEmpty());

    }
}
