/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.EnfermeiroService;
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
 * @author wilde
 */
public class EnfermeiroServiceTest {

    private static Enfermeiro enfermeiro;
    private static Enfermeiro novoEnfermeiro;

    @Mock
    private EnfermeiroService enfermeiroService;

    public EnfermeiroServiceTest() {

        enfermeiroService = new EnfermeiroService();

    }

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        enfermeiro = new Enfermeiro();
        novoEnfermeiro = new Enfermeiro();
    }

    @Test
    public void testSaveCamposObrigatorios() {

        enfermeiro.setCartaoSusEnfermeiro("777 9876 9876 9876");
        enfermeiro.setCorenEnfermeiro("123987");
        enfermeiro.setNome("NONA SENHORA");
        enfermeiro.setCpfEnfermeiro("78010752851");

        when(enfermeiroService.findById(1L)).thenReturn(enfermeiro);
        novoEnfermeiro = enfermeiroService.findById(1L);
        assertEquals("NONA SENHORA", enfermeiro.getNome());
        assertEquals("78010752851", enfermeiro.getCpfEnfermeiro());
        assertEquals("123987", enfermeiro.getCorenEnfermeiro());
        assertEquals("777 9876 9876 9876", enfermeiro.getCartaoSusEnfermeiro());
    }

    @Test(expected = Exception.class)
    public void testFindByIdInexistente() {
        when(enfermeiroService.findById(0L)).thenThrow(new Exception());
        enfermeiro = enfermeiroService.findById(0L);
    }

    @Test
    public void testFindByIdExistente() {

        enfermeiro.setNome("LUCAS GANSO");
        enfermeiro.setCpfEnfermeiro("60817159819");
        enfermeiro.setCartaoSusEnfermeiro("585 9876 1234 9876");
        enfermeiro.setCorenEnfermeiro("10001");

        when(enfermeiroService.findById(1L)).thenReturn(enfermeiro);
        novoEnfermeiro = enfermeiroService.findById(1L);
        assertEquals("LUCAS GANSO", enfermeiro.getNome());
        assertEquals("60817159819", enfermeiro.getCpfEnfermeiro());
        assertEquals("10001", enfermeiro.getCorenEnfermeiro());
        assertEquals("585 9876 1234 9876", enfermeiro.getCartaoSusEnfermeiro());

    }

    @Test
    public void testFindAll() {

        List<Enfermeiro> listaEnfermeiros = new ArrayList<>();

        enfermeiro.setNome("LUCIUS MALLAFYORI");
        enfermeiro.setCpfEnfermeiro("31422203565");
        enfermeiro.setCartaoSusEnfermeiro("585 9876 4444 7890");

        listaEnfermeiros = (List<Enfermeiro>) new ArrayList<Enfermeiro>();
        listaEnfermeiros.add(enfermeiro);

        when(enfermeiroService.findAll()).thenReturn(listaEnfermeiros);

        assertFalse(listaEnfermeiros.isEmpty());

    }

}
