package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.PacienteConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class PacienteConverterTest {

    /**
     *
     */
    public PacienteConverterTest() {
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        PacienteConverter pacienteConverter = new PacienteConverter();
        pacienteConverter.getAsObject(null, null, null);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        PacienteConverter pacienteConverter = new PacienteConverter();
        pacienteConverter.getAsString(null, null, null);
    }
}
