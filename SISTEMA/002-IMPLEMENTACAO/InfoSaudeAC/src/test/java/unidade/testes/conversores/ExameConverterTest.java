/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.ExameConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class ExameConverterTest {
    
    public ExameConverterTest() {
    }
    
    @Test (expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        ExameConverter exameConverter = new ExameConverter();
        exameConverter.getAsObject(null, null, null);
    }

    @Test (expected = Exception.class)
    public void testGetAsString() throws UBSException {
        ExameConverter exameConverter = new ExameConverter();
        exameConverter.getAsString(null, null, null);
    }
    
}
