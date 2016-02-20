package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.AgendamentoPreNatalConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com
 */
public class AgendamentoPreNatalConverterTest {
    
    public AgendamentoPreNatalConverterTest() {
    }
    
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        AgendamentoPreNatalConverter agendamentoPreNatalConverter = new AgendamentoPreNatalConverter();
        agendamentoPreNatalConverter.getAsObject(null, null, null);
    }
    
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        AgendamentoPreNatalConverter agendamentoPreNatalConverter = new AgendamentoPreNatalConverter();
        agendamentoPreNatalConverter.getAsString(null, null, this);
    }
    
}
