package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.OdontologoConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class OdontologoConverterTest {

    /**
     *
     */
    public OdontologoConverterTest() {
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        OdontologoConverter odontologoConverter = new OdontologoConverter();
        odontologoConverter.getAsObject(null, null, null);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        OdontologoConverter odontologoConverter = new OdontologoConverter();
        odontologoConverter.getAsString(null, null, null);
    }
}
