package unidade.testes.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Odontologo;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author elisangela
 */
public class OdontologoTest {

    private Odontologo odontologo;

    public OdontologoTest() {
    }

    @Before
    public void setUp() {
        odontologo = new Odontologo();
        odontologo.setNome("Mariana");
        odontologo.setCro("88665232");
        odontologo.setCpf("035.982.856-63");
        odontologo.setRg("26475828");
        odontologo.setCartaoSus("65745437543");
        odontologo.setDataNascimento(new Date());
        odontologo.setCorOuRaca("Branca");
        odontologo.setTelefone1("(83)33512678");
        odontologo.setTelefone2("(83)98474782");
        odontologo.setEmail("usuario@dominio.com");
        odontologo.setEnderecoRua("Avenida Brasil");
        odontologo.setEnderecoNumero("10");
        odontologo.setEnderecoBairro("Centro");
        odontologo.setEnderecoCep("58500-000");
        odontologo.setEnderecoCidade("Monteiro");
        odontologo.setEnderecoEstado(Estados.PB);

    }

    @Test
    public void testCreateObjetc() {
        System.out.println(odontologo.getNome());
        System.out.println(odontologo.getCro());
        System.out.println(odontologo.getCpf());
        System.out.println(odontologo.getRg());
        System.out.println(odontologo.getCartaoSus());
        System.out.println(odontologo.getDataNascimento());
        System.out.println(odontologo.getCorOuRaca());
        System.out.println(odontologo.getTelefone1());
        System.out.println(odontologo.getTelefone2());
        System.out.println(odontologo.getEmail());
        System.out.println(odontologo.getEnderecoRua());
        System.out.println(odontologo.getEnderecoNumero());
        System.out.println(odontologo.getEnderecoBairro());
        System.out.println(odontologo.getEnderecoCep());
        System.out.println(odontologo.getEnderecoCidade());
        System.out.println(odontologo.getEnderecoEstado());

        assertEquals("O nome esperado deve ser Mariana", "Mariana", odontologo.getNome());
        assertEquals("O crm esperado deve ser 88665232", "88665232", odontologo.getCro());
        assertEquals("O cpf esperado deve ser 035.982.856-63", "035.982.856-63", odontologo.getCpf());
        assertEquals("O rg esperado deve ser 26475828", "26475828", odontologo.getRg());
        assertEquals("O cartão sus deve ser 65745437543", "65745437543", odontologo.getCartaoSus());
        assertEquals("A data esperada deve ser " + odontologo.getDataNascimento(), odontologo.getDataNascimento(), odontologo.getDataNascimento());
        assertEquals("A cor ou raça deve ser Branca", "Branca", odontologo.getCorOuRaca());
        assertEquals("O telefone deve ser (83)33512678", "(83)33512678", odontologo.getTelefone1());
        assertEquals("O telefone deve ser (83)98474782", "(83)98474782", odontologo.getTelefone2());
        assertEquals("O email deve ser usuario@dominio.com", "usuario@dominio.com", odontologo.getEmail());
        assertEquals("A rua deve ser Avenida Brasil", "Avenida Brasil", odontologo.getEnderecoRua());
        assertEquals("O número deve ser 10", "10", odontologo.getEnderecoNumero());
        assertEquals("O bairro deve ser Centro", "Centro", odontologo.getEnderecoBairro());
        assertEquals("O cep esperado deve ser 58500-000", "58500-000", odontologo.getEnderecoCep());
        assertEquals("A cidade esperada deve ser Monteiro", "Monteiro", odontologo.getEnderecoCidade());
        assertEquals("O estado esperado deve ser " + odontologo.getEnderecoEstado(), odontologo.getEnderecoEstado(), odontologo.getEnderecoEstado());
    }

}
