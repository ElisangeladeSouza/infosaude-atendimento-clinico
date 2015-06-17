package unidade.testes.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author elisangela
 */
public class EnfermeiroTest {

    private Enfermeiro enfermeiro;

    public EnfermeiroTest() {
    }

    @Before
    public void setUp() {
        enfermeiro = new Enfermeiro();
        enfermeiro.setNome("Maria");
        enfermeiro.setCorenEnfermeiro("748366354");
        enfermeiro.setCpfEnfermeiro("065.748.982-42");
        enfermeiro.setRg("26475828");
        enfermeiro.setCartaoSusEnfermeiro("65745437543");
        enfermeiro.setDataNascimento(new Date());
        enfermeiro.setCorOuRaca("Branca");
        enfermeiro.setTelefone1("(83)33512678");
        enfermeiro.setTelefone2("(83)98474782");
        enfermeiro.setEmail("usuario@dominio.com");
        enfermeiro.setEnderecoRua("Avenida Brasil");
        enfermeiro.setEnderecoNumero("10");
        enfermeiro.setEnderecoBairro("Centro");
        enfermeiro.setEnderecoCep("58500-000");
        enfermeiro.setEnderecoCidade("Monteiro");
        enfermeiro.setEnderecoEstado(Estados.PB);

    }

    @Test
    public void testCreateObjetc() {
        System.out.println(enfermeiro.getNome());
        System.out.println(enfermeiro.getCorenEnfermeiro());
        System.out.println(enfermeiro.getCpfEnfermeiro());
        System.out.println(enfermeiro.getRg());
        System.out.println(enfermeiro.getCartaoSusEnfermeiro());
        System.out.println(enfermeiro.getDataNascimento());
        System.out.println(enfermeiro.getCorOuRaca());
        System.out.println(enfermeiro.getTelefone1());
        System.out.println(enfermeiro.getTelefone2());
        System.out.println(enfermeiro.getEmail());
        System.out.println(enfermeiro.getEnderecoRua());
        System.out.println(enfermeiro.getEnderecoNumero());
        System.out.println(enfermeiro.getEnderecoBairro());
        System.out.println(enfermeiro.getEnderecoCep());
        System.out.println(enfermeiro.getEnderecoCidade());
        System.out.println(enfermeiro.getEnderecoEstado());

        assertEquals("O nome esperado deve ser Maria", "Maria", enfermeiro.getNome());
        assertEquals("O coren esperado deve ser 748366354", "748366354", enfermeiro.getCorenEnfermeiro());
        assertEquals("O cpf esperado deve ser 065.748.982-42", "065.748.982-42", enfermeiro.getCpfEnfermeiro());
        assertEquals("O rg esperado deve ser 26475828", "26475828", enfermeiro.getRg());
        assertEquals("O cartão sus deve ser 65745437543", "65745437543", enfermeiro.getCartaoSusEnfermeiro());
        assertEquals("A data de nascimento deve ser " + enfermeiro.getDataNascimento(), enfermeiro.getDataNascimento(),
                enfermeiro.getDataNascimento());
        assertEquals("A cor ou raça deve ser Branca", "Branca", enfermeiro.getCorOuRaca());
        assertEquals("O telefone deve ser (83)33512678", "(83)33512678", enfermeiro.getTelefone1());
        assertEquals("O telefone deve ser (83)98474782", "(83)98474782", enfermeiro.getTelefone2());
        assertEquals("O email deve ser usuario@dominio.com", "usuario@dominio.com", enfermeiro.getEmail());
        assertEquals("A rua deve ser Avenida Brasil", "Avenida Brasil", enfermeiro.getEnderecoRua());
        assertEquals("O número deve ser 10", "10", enfermeiro.getEnderecoNumero());
        assertEquals("O bairro deve ser Centro", "Centro", enfermeiro.getEnderecoBairro());
        assertEquals("O cep esperado deve ser 58500-000", "58500-000", enfermeiro.getEnderecoCep());
        assertEquals("A cidade esperada deve ser Monteiro", "Monteiro", enfermeiro.getEnderecoCidade());
        assertEquals("O estado esperado deve ser " + enfermeiro.getEnderecoEstado(), enfermeiro.getEnderecoEstado(),
                enfermeiro.getEnderecoEstado());
    }
}
