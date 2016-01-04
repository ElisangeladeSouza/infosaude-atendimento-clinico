package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.ExameConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class ExameConverterTest {

    /**
     *
     */
    public ExameConverterTest() {
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        ExameConverter exameConverter = new ExameConverter();
        exameConverter.getAsObject(null, null, null);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        ExameConverter exameConverter = new ExameConverter();
        exameConverter.getAsString(null, null, null);
    }
}
