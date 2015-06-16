/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Medico;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.MedicoService;
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
public class MedicoServiceTest {
   
    private static Medico medico;
    private static Medico novoMedico;
    
    @Mock
    private MedicoService medicoService;
    
    
    public MedicoServiceTest() {
        
        medicoService = new MedicoService();
        
    }
    
    @Before
    public void setUp() {
   
        MockitoAnnotations.initMocks(this);
        medico = new Medico();
        novoMedico = new Medico();
    }
    
    @Test
    public void testSaveCamposObrigatorios(){
    
        medico.setCartaoSus("777 9876 9876 2225");
        medico.setCrm("123456");
        medico.setNome("NONA BELLA");
        medico.setCpf("46359114208");
        
        when(medicoService.findById(1L)).thenReturn(medico);
        novoMedico = medicoService.findById(1L);
        assertEquals("NONA BELLA", medico.getNome());
        assertEquals("46359114208", medico.getCpf());
        assertEquals("123456", medico.getCrm());
        assertEquals("777 9876 9876 2225", medico.getCartaoSus());
    }
    
    @Test(expected = Exception.class)
    public void testFindByIdInexistente(){
        when(medicoService.findById(0L)).thenThrow(new Exception());
        medico = medicoService.findById(0L);
    }
    
    @Test
    public void testFindByIdExistente() {
        
        medico.setNome("LUIS ALVIM");
        medico.setCpf("67147470206");
        medico.setCartaoSus("585 9876 0000 9876");
        medico.setCrm("19147");
        
        when(medicoService.findById(1L)).thenReturn(medico);
        novoMedico = medicoService.findById(1L);
        assertEquals("LUIS ALVIM", medico.getNome());
        assertEquals("67147470206", medico.getCpf());
        assertEquals("19147", medico.getCrm());
        assertEquals("585 9876 0000 9876", medico.getCartaoSus());
        
    }
    
    @Test
    public void testFindAll(){
    
        List<Medico> listaMedicos = new ArrayList<>();
        
        medico.setNome("LUCIUS MALLAFYORI");
        medico.setCpf("31422203565");
        medico.setCartaoSus("585 9876 4444 7890");
        
        listaMedicos = (List<Medico>) new ArrayList<Medico>();
        listaMedicos.add(medico);
    
        when(medicoService.findAll()).thenReturn(listaMedicos);
        
        assertFalse(listaMedicos.isEmpty());
        
    }
    
}
