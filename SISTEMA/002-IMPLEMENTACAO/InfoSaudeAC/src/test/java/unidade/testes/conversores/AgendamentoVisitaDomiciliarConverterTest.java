package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.AgendamentoVisitaDomiciliarConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class AgendamentoVisitaDomiciliarConverterTest {
    
    public AgendamentoVisitaDomiciliarConverterTest() {
    }
    
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        AgendamentoVisitaDomiciliarConverter agendamentoVisitaDomiciliarConverter = new AgendamentoVisitaDomiciliarConverter();
        agendamentoVisitaDomiciliarConverter.getAsObject(null, null, null);
    }
    
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        AgendamentoVisitaDomiciliarConverter agendamentoVisitaDomiciliarConverter = new AgendamentoVisitaDomiciliarConverter();
        agendamentoVisitaDomiciliarConverter.getAsString(null, null, this);
    }
    
}
