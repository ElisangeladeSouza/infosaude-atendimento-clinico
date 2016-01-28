package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.GestanteConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class GestanteConverterTest {
    
    public GestanteConverterTest() {
    }
    
    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        GestanteConverter gestanteConverter = new GestanteConverter();
        gestanteConverter.getAsObject(null, null, null);
    }
    
    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        GestanteConverter gestanteConverter = new GestanteConverter();
        gestanteConverter.getAsString(null, null, null);
    }
}
