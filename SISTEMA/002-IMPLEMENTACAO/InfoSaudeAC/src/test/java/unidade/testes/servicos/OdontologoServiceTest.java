/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Odontologo;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.OdontologoService;
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
public class OdontologoServiceTest {
   
    private static Odontologo odontologo;
    private static Odontologo novoOdontologo;
    
    @Mock
    private OdontologoService odontologoService;
    
    
    public OdontologoServiceTest() {
        
        odontologoService = new OdontologoService();
        
    }
    
    @Before
    public void setUp() {
   
        MockitoAnnotations.initMocks(this);
        odontologo = new Odontologo();
        novoOdontologo = new Odontologo();
    }
    
    @Test
    public void testSaveCamposObrigatorios(){
    
        odontologo.setCartaoSus("777 9876 8877 2244");
        odontologo.setCro("9687");
        odontologo.setNome("ISABELLE MAURICE");
        odontologo.setCpf("09827885685");
        
        odontologoService.save(odontologo);
        
        when(odontologoService.findById(1L)).thenReturn(odontologo);
        novoOdontologo = odontologoService.findById(1L);
        assertEquals("ISABELLE MAURICE", odontologo.getNome());
        assertEquals("09827885685", odontologo.getCpf());
        assertEquals("9687", odontologo.getCro());
        assertEquals("777 9876 8877 2244", odontologo.getCartaoSus());
    }
    
    @Test(expected = Exception.class)
    public void testFindByIdInexistente(){
        when(odontologoService.findById(0L)).thenThrow(new Exception());
        odontologo = odontologoService.findById(0L);
    }
    
    @Test
    public void testFindByIdExistente() {
        
        odontologo.setNome("LUIS ARTHUR");
        odontologo.setCpf("88378682862");
        odontologo.setCartaoSus("123 9876 1234 9876");
        odontologo.setCro("19147");
        odontologoService.save(odontologo);
        
        when(odontologoService.findById(1L)).thenReturn(odontologo);
        novoOdontologo = odontologoService.findById(1L);
        assertEquals("LUIS ARTHUR", odontologo.getNome());
        assertEquals("88378682862", odontologo.getCpf());
        assertEquals("19147", odontologo.getCro());
        assertEquals("123 9876 1234 9876", odontologo.getCartaoSus());
        
    }
    
}
