package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.ContaConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class ContaConverterTest {
    
    public ContaConverterTest() {
    }
    
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        ContaConverter contaConverter = new ContaConverter();
        contaConverter.getAsObject(null, null, null);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        ContaConverter contaConverter = new ContaConverter();
        contaConverter.getAsString(null, null, null);
    }
    
}
