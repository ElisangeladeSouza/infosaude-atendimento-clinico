/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Triagem;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.TriagemService;
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
public class TriagemServiceTest {

    private static Triagem triagem;
    private static Triagem novaTriagem;
    private static List<Triagem> listaTriagems;
    private static Long id;
    private static FichaAtendimento fichaAtendimento;

    @Mock
    private TriagemService triagemService;

    public TriagemServiceTest() {

        triagemService = new TriagemService();

    }

    @BeforeClass
    public static void setUpClass() {

        fichaAtendimento = new FichaAtendimento();
        fichaAtendimento.setId(1L);

    }

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        triagem = new Triagem();
        novaTriagem = new Triagem();
    }

    @Test(expected = Exception.class)
    public void testFindByIdInexistente() {

        when(triagemService.findById(0L)).thenThrow(new Exception());
        triagem = triagemService.findById(0L);
    }

    @Test
    public void testFindById() {

        triagem.setCodigo("00001");
        triagem.setFichaAtendimento(fichaAtendimento);

        when(triagemService.findById(1L)).thenReturn(triagem);
        novaTriagem = triagemService.findById(1L);
        assertEquals("00001", triagem.getCodigo());
        assertEquals(fichaAtendimento.getId(), novaTriagem.getFichaAtendimento().getId());

    }

    @Test(expected = Exception.class)
    public void testFindAllNenhumSalvo() {

        when(triagemService.findAll()).thenThrow(new Exception());
        triagemService.findAll();

    }

    @Test
    public void testFindAll() {

        triagem.setCodigo("00001");
        triagem.setFichaAtendimento(fichaAtendimento);

        listaTriagems = (List<Triagem>) new ArrayList<Triagem>();
        listaTriagems.add(triagem);

        when(triagemService.findAll()).thenReturn(listaTriagems);

        assertFalse(listaTriagems.isEmpty());

    }

}
