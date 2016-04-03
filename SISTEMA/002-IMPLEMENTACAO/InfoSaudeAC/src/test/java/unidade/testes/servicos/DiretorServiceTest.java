package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Diretor;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.DiretorService;
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
 * @author wilde <wildearruda@gmail.com>
 */
public class DiretorServiceTest {

    private static Diretor diretor;
    private static Diretor novoDiretor;

    @Mock
    private final DiretorService diretorService;

    /**
     *
     */
    public DiretorServiceTest() {

        diretorService = new DiretorService();

    }

    /**
     *
     */
    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        diretor = new Diretor();
        novoDiretor = new Diretor();
    }

    /**
     *
     */
    @Test
    public void testSaveCamposObrigatorios() {

        diretor.setCartaoSusDiretor("777 1234 1111 9876");
        diretor.setNome("MARTA SANHASSU");
        diretor.setCpfDiretor("65076065884");

        when(diretorService.findById(1L)).thenReturn(diretor);

        novoDiretor = diretorService.findById(1L);
        assertEquals("MARTA SANHASSU", diretor.getNome());
        assertEquals("65076065884", diretor.getCpfDiretor());
        assertEquals("777 1234 1111 9876", diretor.getCartaoSusDiretor());
    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testFindByIdInexistente() {
        when(diretorService.findById(0L)).thenThrow(new Exception());
        diretor = diretorService.findById(0L);
    }

    /**
     *
     */
    @Test
    public void testFindById() {

        diretor.setNome("LUIS VITON");
        diretor.setCpfDiretor("15489262303");
        diretor.setCartaoSusDiretor("585 5678 0000 5432");

        when(diretorService.findById(1L)).thenReturn(diretor);
        diretor = diretorService.findById(1L);
        assertEquals("LUIS VITON", diretor.getNome());
        assertEquals("15489262303", diretor.getCpfDiretor());
        assertEquals("585 5678 0000 5432", diretor.getCartaoSusDiretor());

    }

    /**
     *
     */
    @Test
    public void testFindAll() {

        List<Diretor> listaDiretores = new ArrayList<>();

        diretor.setNome("LUCIUS MALLAFYORI");
        diretor.setCpfDiretor("31422203565");
        diretor.setCartaoSusDiretor("585 9876 4444 7890");

        listaDiretores = (List<Diretor>) new ArrayList<Diretor>();
        listaDiretores.add(diretor);

        when(diretorService.findAll()).thenReturn(listaDiretores);

        assertFalse(listaDiretores.isEmpty());

    }
}
