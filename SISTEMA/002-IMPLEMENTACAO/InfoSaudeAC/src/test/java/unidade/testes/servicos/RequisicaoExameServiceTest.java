/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.RequisicaoExame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.RequisicaoExameService;
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
public class RequisicaoExameServiceTest {

    private static RequisicaoExame requisicaoExame;
    private static RequisicaoExame novaRequisicaoExame;
    private static List<RequisicaoExame> listaRequisicaoExames;
    private static List<Exame> listaExames;
    private static Long id;
    private static FichaAtendimento fichaAtendimento;
    private static Exame exame;
    private static Exame novoExame;

    @Mock
    private RequisicaoExameService requisicaoExameService;

    /**
     *
     */
    public RequisicaoExameServiceTest() {

        requisicaoExameService = new RequisicaoExameService();

    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {

        exame = new Exame();
        exame.setId(1L);

        novoExame = new Exame();
        novoExame.setId(2L);

        listaExames = new ArrayList<Exame>();
        listaExames.add(exame);
        listaExames.add(novoExame);

    }

    /**
     *
     */
    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        requisicaoExame = new RequisicaoExame();
        novaRequisicaoExame = new RequisicaoExame();
    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testFindByIdInexistente() {

        when(requisicaoExameService.findById(0L)).thenThrow(new Exception());
        requisicaoExame = requisicaoExameService.findById(0L);
    }

    /**
     *
     */
    @Test
    public void testFindById() {

        requisicaoExame.setExames(listaExames);
        requisicaoExame.setSolicitanteCidade("Sumé");
        requisicaoExame.setSolicitanteCnes("PSF IV");
        requisicaoExame.setSolicitanteEndereco("Centro");

        when(requisicaoExameService.findById(1L)).thenReturn(requisicaoExame);
        novaRequisicaoExame = requisicaoExameService.findById(1L);
        assertEquals(listaExames, requisicaoExame.getExames());
        assertEquals("Sumé", novaRequisicaoExame.getSolicitanteCidade());
        assertEquals("PSF IV", novaRequisicaoExame.getSolicitanteCnes());
        assertEquals("Centro", novaRequisicaoExame.getSolicitanteEndereco());
    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testFindAllNenhumSalvo() {

        when(requisicaoExameService.findAll()).thenThrow(new Exception());
        requisicaoExameService.findAll();

    }

    /**
     *
     */
    @Test
    public void testFindAll() {

        requisicaoExame.setExames(listaExames);
        requisicaoExame.setSolicitanteCidade("Sumé");
        requisicaoExame.setSolicitanteCnes("PSF IV");
        requisicaoExame.setSolicitanteEndereco("Centro");

        listaRequisicaoExames = (List<RequisicaoExame>) new ArrayList<RequisicaoExame>();
        listaRequisicaoExames.add(requisicaoExame);

        when(requisicaoExameService.findAll()).thenReturn(listaRequisicaoExames);

        assertFalse(listaRequisicaoExames.isEmpty());

    }

}
