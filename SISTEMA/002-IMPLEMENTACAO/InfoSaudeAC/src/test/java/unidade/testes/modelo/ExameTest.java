package unidade.testes.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class ExameTest {

    private Exame exame;

    /**
     *
     */
    public ExameTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        exame = new Exame();

        exame.setDescricao("Glicose");
    }

    /**
     *
     */
    @Test
    public void testCreateObjetc() {
        System.out.println(exame.getDescricao());

        assertEquals("O exame esperado deve ser Glicose", "Glicose", exame.getDescricao());
    }
}
