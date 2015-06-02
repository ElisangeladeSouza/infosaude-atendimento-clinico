/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Administrador;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.AdministradorService;
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
public class AdministradorServiceTest {
   
    private static Administrador administrador;
    private static Administrador novoAdministrador;
    
    @Mock
    private AdministradorService administradorService;
    
    
    public AdministradorServiceTest() {
        
        administradorService = new AdministradorService();
        
    }
    
    @Before
    public void setUp() {
   
        MockitoAnnotations.initMocks(this);
        administrador = new Administrador();
        novoAdministrador = new Administrador();
    }
    
    @Test
    public void testSaveCamposObrigatorios(){
    
        administrador.setCartaoSus("777 1234 1111 9876");
        administrador.setNome("MARTA SANHASSU");
        administrador.setCpf("65076065884");
        
        administradorService.save(administrador);
        
        when(administradorService.findById(1L)).thenReturn(administrador);
        novoAdministrador = administradorService.findById(1L);
        assertEquals("MARTA SANHASSU", administrador.getNome());
        assertEquals("65076065884", administrador.getCpf());
        assertEquals("777 1234 1111 9876", administrador.getCartaoSus());
    }
    
    @Test(expected = Exception.class)
    public void testFindByIdInexistente(){
        when(administradorService.findById(0L)).thenThrow(new Exception());
        administrador = administradorService.findById(0L);
    }
    
    @Test
    public void testFindByIdExistente() {
        
        administrador.setNome("LUIS VITON");
        administrador.setCpf("15489262303");
        administrador.setCartaoSus("585 5678 0000 5432");
        administradorService.save(administrador);
        
        when(administradorService.findById(1L)).thenReturn(administrador);
        administrador = administradorService.findById(1L);
        assertEquals("LUIS VITON", administrador.getNome());
        assertEquals("15489262303", administrador.getCpf());
        assertEquals("585 5678 0000 5432", administrador.getCartaoSus());
        
    }
    
}