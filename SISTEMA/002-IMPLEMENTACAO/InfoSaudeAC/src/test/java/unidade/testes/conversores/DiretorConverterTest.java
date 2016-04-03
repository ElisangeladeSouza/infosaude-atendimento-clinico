package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.DiretorConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wilde <wildearruda@gmail.com>
 */
public class DiretorConverterTest {

    public DiretorConverterTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        DiretorConverter diretorConverter = new DiretorConverter();
        diretorConverter.getAsObject(null, null, null);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        DiretorConverter diretorConverter = new DiretorConverter();
        diretorConverter.getAsString(null, null, null);
    }
}
