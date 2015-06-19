/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Recepcionista;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.RecepcionistaService;
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
public class RecepcionistaServiceTest {

    private static Recepcionista recepcionista;
    private static Recepcionista novoRecepcionista;

    @Mock
    private RecepcionistaService recepcionistaService;

    public RecepcionistaServiceTest() {

        recepcionistaService = new RecepcionistaService();

    }

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        recepcionista = new Recepcionista();
        novoRecepcionista = new Recepcionista();
    }

    @Test
    public void testSaveCamposObrigatorios() {

        recepcionista.setCartaoSusRecepcionista("777 1234 5678 9012");
        recepcionista.setNome("BELLA PRINCE");
        recepcionista.setCpfRecepcionista("78135746130");

        when(recepcionistaService.findById(1L)).thenReturn(recepcionista);
        novoRecepcionista = recepcionistaService.findById(1L);
        assertEquals("BELLA PRINCE", recepcionista.getNome());
        assertEquals("78135746130", recepcionista.getCpfRecepcionista());
        assertEquals("777 1234 5678 9012", recepcionista.getCartaoSusRecepcionista());
    }

    @Test(expected = Exception.class)
    public void testFindByIdInexistente() {
        when(recepcionistaService.findById(0L)).thenThrow(new Exception());
        recepcionista = recepcionistaService.findById(0L);
    }

    @Test
    public void testFindByIdExistente() {

        recepcionista.setNome("LUCIANA MORENO");
        recepcionista.setCpfRecepcionista("13193944343");
        recepcionista.setCartaoSusRecepcionista("123 4567 8920 9876");

        when(recepcionistaService.findById(1L)).thenReturn(recepcionista);
        novoRecepcionista = recepcionistaService.findById(1L);
        assertEquals("LUCIANA MORENO", recepcionista.getNome());
        assertEquals("13193944343", recepcionista.getCpfRecepcionista());
        assertEquals("123 4567 8920 9876", recepcionista.getCartaoSusRecepcionista());

    }

    @Test
    public void testFindAll() {

        List<Recepcionista> listaRecepcionistas = new ArrayList<>();

        recepcionista.setNome("LUCIUS MALLAFYORI");
        recepcionista.setCpfRecepcionista("31422203565");
        recepcionista.setCartaoSusRecepcionista("585 9876 4444 7890");

        listaRecepcionistas = (List<Recepcionista>) new ArrayList<Recepcionista>();
        listaRecepcionistas.add(recepcionista);

        when(recepcionistaService.findAll()).thenReturn(listaRecepcionistas);

        assertFalse(listaRecepcionistas.isEmpty());

    }

}
