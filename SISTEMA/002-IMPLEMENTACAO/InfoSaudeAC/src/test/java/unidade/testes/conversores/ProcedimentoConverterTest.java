package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.ProcedimentoConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde <wildearruda@gmail.com>
 */
public class ProcedimentoConverterTest {

    public ProcedimentoConverterTest() {
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        ProcedimentoConverter procedimentoConverter = new ProcedimentoConverter();
        procedimentoConverter.getAsObject(null, null, null);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        ProcedimentoConverter procedimentoConverter = new ProcedimentoConverter();
        procedimentoConverter.getAsString(null, null, null);
    }
}
