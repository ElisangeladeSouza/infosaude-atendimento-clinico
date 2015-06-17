/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.MedicoConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class MedicoConverterTest {
    
    public MedicoConverterTest() {
    }
    
    @Test (expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        MedicoConverter medicoConverter = new MedicoConverter();
        medicoConverter.getAsObject(null, null, null);
    }

    @Test (expected = Exception.class)
    public void testGetAsString() throws UBSException {
        MedicoConverter medicoConverter = new MedicoConverter();
        medicoConverter.getAsString(null, null, null);
    }
    
}
