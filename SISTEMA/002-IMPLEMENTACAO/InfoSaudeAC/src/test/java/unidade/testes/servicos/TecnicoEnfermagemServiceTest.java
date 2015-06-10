/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.TecnicoEnfermagem;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.TecnicoEnfermagemService;
import java.util.ArrayList;
import java.util.List;
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
public class TecnicoEnfermagemServiceTest {
   
    private static TecnicoEnfermagem tecnicoEnfermagem;
    private static TecnicoEnfermagem novoTecnicoEnfermagem;
    
    @Mock
    private TecnicoEnfermagemService tecnicoEnfermagemService;
    
    
    public TecnicoEnfermagemServiceTest() {
        
        tecnicoEnfermagemService = new TecnicoEnfermagemService();
        
    }
    
    @Before
    public void setUp() {
   
        MockitoAnnotations.initMocks(this);
        tecnicoEnfermagem = new TecnicoEnfermagem();
        novoTecnicoEnfermagem = new TecnicoEnfermagem();
    }
    
    @Test
    public void testSaveCamposObrigatorios(){
    
        tecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("123 9876 9876 1234");
        tecnicoEnfermagem.setCorenTecnicoEnfermagem("20012");
        tecnicoEnfermagem.setNome("BELLA BEAST");
        tecnicoEnfermagem.setCpfTecnicoEnfermagem("60578164809");
        
        tecnicoEnfermagemService.save(tecnicoEnfermagem);
        
        when(tecnicoEnfermagemService.findById(1L)).thenReturn(tecnicoEnfermagem);
        novoTecnicoEnfermagem = tecnicoEnfermagemService.findById(1L);
        assertEquals("BELLA BEAST", tecnicoEnfermagem.getNome());
        assertEquals("60578164809", tecnicoEnfermagem.getCpfTecnicoEnfermagem());
        assertEquals("20012", tecnicoEnfermagem.getCorenTecnicoEnfermagem());
        assertEquals("123 9876 9876 1234", tecnicoEnfermagem.getCartaoSusTecnicoEnfermagem());
    }
    
    @Test(expected = Exception.class)
    public void testFindByIdInexistente(){
        when(tecnicoEnfermagemService.findById(0L)).thenThrow(new Exception());
        tecnicoEnfermagem = tecnicoEnfermagemService.findById(0L);
    }
    
    @Test
    public void testFindByIdExistente() {
        
        tecnicoEnfermagem.setNome("LUCIUS MALLAFYORI");
        tecnicoEnfermagem.setCpfTecnicoEnfermagem("31422203565");
        tecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("585 9876 4444 7890");
        tecnicoEnfermagem.setCorenTecnicoEnfermagem("19700");
        tecnicoEnfermagemService.save(tecnicoEnfermagem);
        
        when(tecnicoEnfermagemService.findById(1L)).thenReturn(tecnicoEnfermagem);
        novoTecnicoEnfermagem = tecnicoEnfermagemService.findById(1L);
        assertEquals("LUCIUS MALLAFYORI", tecnicoEnfermagem.getNome());
        assertEquals("31422203565", tecnicoEnfermagem.getCpfTecnicoEnfermagem());
        assertEquals("19700", tecnicoEnfermagem.getCorenTecnicoEnfermagem());
        assertEquals("585 9876 4444 7890", tecnicoEnfermagem.getCartaoSusTecnicoEnfermagem());
        
    }
    
}
