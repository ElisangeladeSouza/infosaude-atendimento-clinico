package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.FichaPreNatalConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com
 */
public class FichaPreNatalConverterTest {
    
    public FichaPreNatalConverterTest() {
    }
    
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        FichaPreNatalConverter fichaPreNatalConverter = new FichaPreNatalConverter();
        fichaPreNatalConverter.getAsObject(null, null, null);
    }
    
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        FichaPreNatalConverter fichaPreNatalConverter = new FichaPreNatalConverter();
        fichaPreNatalConverter.getAsString(null, null, this);
    }
    
}
