/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.TecnicoEnfermagemConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class TecnicoEnfermagemConverterTest {

    /**
     *
     */
    public TecnicoEnfermagemConverterTest() {
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        TecnicoEnfermagemConverter tecnicoEnfermagemConverter = new TecnicoEnfermagemConverter();
        tecnicoEnfermagemConverter.getAsObject(null, null, null);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        TecnicoEnfermagemConverter tecnicoEnfermagemConverter = new TecnicoEnfermagemConverter();
        tecnicoEnfermagemConverter.getAsString(null, null, null);
    }

}
