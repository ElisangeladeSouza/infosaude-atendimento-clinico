package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.EnfermeiroConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde <wildearruda@gmail.com>
 */
public class EnfermeiroConverterTest {

    public EnfermeiroConverterTest() {
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        EnfermeiroConverter enfermeiroConverter = new EnfermeiroConverter();
        enfermeiroConverter.getAsObject(null, null, null);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        EnfermeiroConverter enfermeiroConverter = new EnfermeiroConverter();
        enfermeiroConverter.getAsString(null, null, null);
    }
}
