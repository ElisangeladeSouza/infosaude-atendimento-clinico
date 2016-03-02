package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.TriagemConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde <wildearruda@gmail.com>
 */
public class TriagemConverterTest {

    public TriagemConverterTest() {
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        TriagemConverter triagemConverter = new TriagemConverter();
        triagemConverter.getAsObject(null, null, null);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        TriagemConverter triagemConverter = new TriagemConverter();
        triagemConverter.getAsString(null, null, null);
    }
}
