package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.MedicoConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class MedicoConverterTest {

    /**
     *
     */
    public MedicoConverterTest() {
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        MedicoConverter medicoConverter = new MedicoConverter();
        medicoConverter.getAsObject(null, null, null);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        MedicoConverter medicoConverter = new MedicoConverter();
        medicoConverter.getAsString(null, null, null);
    }
}
