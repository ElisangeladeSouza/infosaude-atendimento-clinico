/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.EnfermeiroService;
import static org.junit.Assert.assertEquals;
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
    public void testSaveCamposObrigatorios(){
    
        enfermeiro.setCartaoSus("777 9876 9876 9876");
        enfermeiro.setCoren("123987");
        enfermeiro.setNome("NONA SENHORA");
        enfermeiro.setCpf("78010752851");
        
        enfermeiroService.save(enfermeiro);
        
        when(enfermeiroService.findById(1L)).thenReturn(enfermeiro);
        novoEnfermeiro = enfermeiroService.findById(1L);
        assertEquals("NONA SENHORA", enfermeiro.getNome());
        assertEquals("78010752851", enfermeiro.getCpf());
        assertEquals("123987", enfermeiro.getCoren());
        assertEquals("777 9876 9876 9876", enfermeiro.getCartaoSus());
    }
    
    @Test(expected = Exception.class)
    public void testFindByIdInexistente(){
        when(enfermeiroService.findById(0L)).thenThrow(new Exception());
        enfermeiro = enfermeiroService.findById(0L);
    }
    
    @Test
    public void testFindByIdExistente() {
        
        enfermeiro.setNome("LUCAS GANSO");
        enfermeiro.setCpf("60817159819");
        enfermeiro.setCartaoSus("585 9876 1234 9876");
        enfermeiro.setCoren("10001");
        enfermeiroService.save(enfermeiro);
        
        when(enfermeiroService.findById(1L)).thenReturn(enfermeiro);
        novoEnfermeiro = enfermeiroService.findById(1L);
        assertEquals("LUCAS GANSO", enfermeiro.getNome());
        assertEquals("60817159819", enfermeiro.getCpf());
        assertEquals("10001", enfermeiro.getCoren());
        assertEquals("585 9876 1234 9876", enfermeiro.getCartaoSus());
        
    }
    
}
