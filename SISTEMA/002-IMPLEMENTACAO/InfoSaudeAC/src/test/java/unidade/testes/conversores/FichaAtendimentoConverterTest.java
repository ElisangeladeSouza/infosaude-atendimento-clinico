package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.FichaAtendimentoConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class FichaAtendimentoConverterTest {

    /**
     *
     */
    public FichaAtendimentoConverterTest() {
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        FichaAtendimentoConverter fichaAtendimentoConverter = new FichaAtendimentoConverter();
        fichaAtendimentoConverter.getAsObject(null, null, null);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        FichaAtendimentoConverter fichaAtendimentoConverter = new FichaAtendimentoConverter();
        fichaAtendimentoConverter.getAsString(null, null, null);
    }
}
