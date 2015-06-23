/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.RequisicaoExameConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class RequisicaoExameConverterTest {

    /**
     *
     */
    public RequisicaoExameConverterTest() {
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        RequisicaoExameConverter requisicaoExameConverter = new RequisicaoExameConverter();
        requisicaoExameConverter.getAsObject(null, null, null);
    }

    /**
     *
     * @throws UBSException
     */
    @Test(expected = Exception.class)
    public void testGetAsString() throws UBSException {
        RequisicaoExameConverter requisicaoExameConverter = new RequisicaoExameConverter();
        requisicaoExameConverter.getAsString(null, null, null);
    }

}
