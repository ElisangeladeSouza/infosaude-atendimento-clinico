/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Paciente;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.PacienteService;
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
public class PacienteServiceTest {
   
    private static Paciente paciente;
    private static Paciente novoPaciente;
    
    @Mock
    private PacienteService pacienteService;
    
    
    public PacienteServiceTest() {
        
        pacienteService = new PacienteService();
        
    }
    
    @Before
    public void setUp() {
   
        MockitoAnnotations.initMocks(this);
        paciente = new Paciente();
        novoPaciente = new Paciente();
    }
    
    @Test
    public void testSaveCamposObrigatorios(){
    
        paciente.setCartaoSus("777 1234 7777 2225");
        paciente.setNome("PRISCILLA LUCIA");
        paciente.setCpf("01438218494");
        
        pacienteService.save(paciente);
        
        when(pacienteService.findById(1L)).thenReturn(paciente);
        novoPaciente = pacienteService.findById(1L);
        assertEquals("PRISCILLA LUCIA", paciente.getNome());
        assertEquals("01438218494", paciente.getCpf());
        assertEquals("777 1234 7777 2225", paciente.getCartaoSus());
    }
    
    @Test(expected = Exception.class)
    public void testFindByIdInexistente(){
        when(pacienteService.findById(0L)).thenThrow(new Exception());
        paciente = pacienteService.findById(0L);
    }
    
    @Test
    public void testFindByIdExistente() {
        
        paciente.setNome("MARCIA MINEIRO");
        paciente.setCpf("72409668607");
        paciente.setCartaoSus("585 9874 1234 9876");
        pacienteService.save(paciente);
        
        when(pacienteService.findById(1L)).thenReturn(paciente);
        novoPaciente = pacienteService.findById(1L);
        assertEquals("MARCIA MINEIRO", paciente.getNome());
        assertEquals("72409668607", paciente.getCpf());
        assertEquals("585 9874 1234 9876", paciente.getCartaoSus());
        
    }
    
}
