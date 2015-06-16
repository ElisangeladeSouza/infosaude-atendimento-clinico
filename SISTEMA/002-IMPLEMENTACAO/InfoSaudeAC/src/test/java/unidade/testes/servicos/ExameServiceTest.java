/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ExameService;
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
public class ExameServiceTest {
   
    private static Exame exame;
    private static Exame novoExame;
    private static List<Exame> listaExames;
    private static Long id;
    private static FichaAtendimento fichaAtendimento;
    
    @Mock
    private ExameService exameService;
    
    
    public ExameServiceTest() {
        
        exameService = new ExameService();
        
    }
    
    @BeforeClass
    public static void setUpClass(){
    
        fichaAtendimento = new FichaAtendimento();
        fichaAtendimento.setId(1L);
    
    }
    
    @Before
    public void setUp() {
   
        MockitoAnnotations.initMocks(this);
        exame = new Exame();
        novoExame = new Exame();
    }
            
    @Test(expected = Exception.class)
    public void testFindByIdInexistente(){
    
        when(exameService.findById(0L)).thenThrow(new Exception());
        exame = exameService.findById(0L);
    }
    
    @Test
    public void testFindById() {
        
        exame.setDescricao("Sangue");
        exame.setDetalhes("Coletar Sangue");
        
        when(exameService.findById(1L)).thenReturn(exame);
        novoExame = exameService.findById(1L);
        assertEquals("Sangue", exame.getDescricao());
        assertEquals("Coletar Sangue", novoExame.getDetalhes());
        
    }
    
    @Test (expected = Exception.class)
    public void testFindAllNenhumSalvo(){
        
        when(exameService.findAll()).thenThrow(new Exception());
        exameService.findAll();
    
    }
    
    @Test
    public void testFindAll(){
    
        exame.setDescricao("Sangue");
        exame.setDetalhes("Coletar Sangue");
        
        listaExames = (List<Exame>) new ArrayList<Exame>();
        listaExames.add(exame);
    
        when(exameService.findAll()).thenReturn(listaExames);
        
        assertFalse(listaExames.isEmpty());
        
    }
    
}
