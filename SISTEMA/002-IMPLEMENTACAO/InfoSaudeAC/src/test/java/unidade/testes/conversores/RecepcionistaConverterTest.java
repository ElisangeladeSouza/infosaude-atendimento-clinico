package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.RecepcionistaConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class RecepcionistaConverterTest {

    /**
     *
     */
    public RecepcionistaConverterTest() {
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        RecepcionistaConverter recepcionistaConverter = new RecepcionistaConverter();
        recepcionistaConverter.getAsObject(null, null, null);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        RecepcionistaConverter recepcionistaConverter = new RecepcionistaConverter();
        recepcionistaConverter.getAsString(null, null, null);
    }
}
