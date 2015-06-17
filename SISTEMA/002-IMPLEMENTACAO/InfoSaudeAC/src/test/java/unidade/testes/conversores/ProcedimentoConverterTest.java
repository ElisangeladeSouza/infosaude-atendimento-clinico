/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.ProcedimentoConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class ProcedimentoConverterTest {
    
    public ProcedimentoConverterTest() {
    }
    
    @Test (expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        ProcedimentoConverter procedimentoConverter = new ProcedimentoConverter();
        procedimentoConverter.getAsObject(null, null, null);
    }

    @Test (expected = Exception.class)
    public void testGetAsString() throws UBSException {
        ProcedimentoConverter procedimentoConverter = new ProcedimentoConverter();
        procedimentoConverter.getAsString(null, null, null);
    }
    
}
