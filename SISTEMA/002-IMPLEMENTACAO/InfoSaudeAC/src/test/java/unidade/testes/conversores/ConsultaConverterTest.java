package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.ConsultaConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde <wildearruda@gmail.com>
 */
public class ConsultaConverterTest {

    public ConsultaConverterTest() {
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        ConsultaConverter consultaConverter = new ConsultaConverter();
        consultaConverter.getAsObject(null, null, null);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        ConsultaConverter consultaConverter = new ConsultaConverter();
        consultaConverter.getAsString(null, null, null);
    }
}
