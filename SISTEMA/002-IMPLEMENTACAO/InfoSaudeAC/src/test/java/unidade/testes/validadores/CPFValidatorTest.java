package unidade.testes.validadores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.validadores.CPFValidator;
import javax.faces.validator.ValidatorException;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class CPFValidatorTest {

    /**
     * Test of validate method, of class CPFValidator.
     */
    //Este teste passa um cpf inválido e espera uma exceção
    @Test(expected = ValidatorException.class)
    public void testeCPFInvalidoRetornaExcecao() {
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.validate(null, null, "00011122233");
    }

    //Este teste passa um cpf inválido e espera uma exceção
    /**
     *
     */
    @Test(expected = ValidatorException.class)
    public void testeCPFInvalidoNumerosIguaisRetornaExcecao() {
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.validate(null, null, "00000000000");
    }

    //Este teste passa um cpf em braco e espera uma exceção
    /**
     *
     */
    @Test(expected = ValidatorException.class)
    public void testeCPFVazioRetornaExcecao() {
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.validate(null, null, "");
    }
}
