package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.CPFConverter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class CPFConverterTest {

    /**
     * Test of getAsObject method, of class CPFConverter.
     * Este teste é aplicado passando-se a condição de "" para testar o retorno do método getAsObject 
     */
    @Test
    public void testeGetAsObjectVazio() {
        CPFConverter cpfConverter = new CPFConverter();
        assertEquals("", cpfConverter.getAsObject(null, null, ""));
    }

    /**
     * Este teste é aplicado passando-se a condição de null para testar o retorno do método getAsObject 
     */
    @Test
    public void testeGetAsObjectNulo() {
        CPFConverter cpfConverter = new CPFConverter();
        assertEquals(null, cpfConverter.getAsObject(null, null, null));
    }

    /**
     * Este teste espera um retorno válido sem pontos (.) e traços(-) vindo do método getAsObject
     */
    @Test
    public void testeGetAsObjectCPFSemPontosETracos() {
        CPFConverter cpfConverter = new CPFConverter();
        assertEquals("20784551561", cpfConverter.getAsObject(null, null, "207.845.515-61"));
    }

    /**
     * Test of getAsString method, of class CPFConverter.
     * Este teste espera um retorno "" vindo do método getAsString
     */
    @Test
    public void testGetAsStringVazio() {
        CPFConverter cpfConverter = new CPFConverter();
        assertEquals("", cpfConverter.getAsString(null, null, ""));
    }
    
    /**
     * Este teste espera um retorno null vindo do método getAsString
     */
    @Test
    public void testeGetAsStringNulo() {
        CPFConverter cpfConverter = new CPFConverter();
        assertEquals(null, cpfConverter.getAsString(null, null, null));
    }

    /**
     * Este teste espera um retorno "1111" vindo do método getAsString sem efetuar nenhuma alteração na entrada
     */
    @Test
    public void testeGetAsStringCPFInvalidoPoucosDigitos() {
        CPFConverter cpfConverter = new CPFConverter();
        assertEquals("1111", cpfConverter.getAsString(null, null, "1111"));
    }

    /**
     * Este teste espera um retorno "1234567890" vindo do método getAsString sem efetuar nenhuma alteração na entrada
     */
    @Test
    public void testeGetAsStringCPFInvalidoDezDigitos() {
        CPFConverter cpfConverter = new CPFConverter();
        assertEquals("1234567890", cpfConverter.getAsString(null, null, "1234567890"));
    }

    /**
     * Este teste espera um retorno "12345678901234567890" vindo do método getAsString sem efetuar nenhuma alteração na entrada
     */
    @Test
    public void testeGetAsStringCPFInvalidoMaisDeOnzeDigitos() {
        CPFConverter cpfConverter = new CPFConverter();
        assertEquals("12345678901234567890", cpfConverter.getAsString(null, null, "12345678901234567890"));
    }

    /**
     * Este teste espera um retorno "123.456.789-01" vindo do método getAsString efetuando alteração na entrada
     */
    @Test
    public void testeGetAsStringCPFComPontosETracos() {
        CPFConverter cpfConverter = new CPFConverter();
        assertEquals("123.456.789-01", cpfConverter.getAsString(null, null, "12345678901"));
    }
}
