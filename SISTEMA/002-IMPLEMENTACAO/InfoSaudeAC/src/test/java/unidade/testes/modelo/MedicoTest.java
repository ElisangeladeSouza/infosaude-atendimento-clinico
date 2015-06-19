package unidade.testes.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Medico;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author elisangela
 */
public class MedicoTest {

    private Medico medico;

    /**
     *
     */
    public MedicoTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        medico = new Medico();
        medico.setNome("João");
        medico.setCrm("4654543568");
        medico.setCpfMedico("682.316.676-28");
        medico.setRg("26475828");
        medico.setCartaoSusMedico("65745437543");
        medico.setDataNascimento(new Date());
        medico.setCorOuRaca("Branca");
        medico.setTelefone1("(83)33512678");
        medico.setTelefone2("(83)98474782");
        medico.setEmail("usuario@dominio.com");
        medico.setEnderecoRua("Avenida Brasil");
        medico.setEnderecoNumero("10");
        medico.setEnderecoBairro("Centro");
        medico.setEnderecoCep("58500-000");
        medico.setEnderecoCidade("Monteiro");
        medico.setEnderecoEstado(Estados.PB);
    }

    /**
     *
     */
    @Test
    public void testCreateObjetc() {
        System.out.println(medico.getNome());
        System.out.println(medico.getCrm());
        System.out.println(medico.getCpfMedico());
        System.out.println(medico.getRg());
        System.out.println(medico.getCartaoSusMedico());
        System.out.println(medico.getDataNascimento());
        System.out.println(medico.getCorOuRaca());
        System.out.println(medico.getTelefone1());
        System.out.println(medico.getTelefone2());
        System.out.println(medico.getEmail());
        System.out.println(medico.getEnderecoRua());
        System.out.println(medico.getEnderecoNumero());
        System.out.println(medico.getEnderecoBairro());
        System.out.println(medico.getEnderecoCep());
        System.out.println(medico.getEnderecoCidade());
        System.out.println(medico.getEnderecoEstado());

        assertEquals("O nome esperado deve ser João", "João", medico.getNome());
        assertEquals("O crm esperado deve ser 4654543568", "4654543568", medico.getCrm());
        assertEquals("O cpf esperado deve ser 682.316.676-28", "682.316.676-28", medico.getCpfMedico());
        assertEquals("O rg esperado deve ser 26475828", "26475828", medico.getRg());
        assertEquals("O cartão sus deve ser 65745437543", "65745437543", medico.getCartaoSusMedico());
        assertEquals("O rg esperado deve ser " + medico.getDataNascimento(), medico.getDataNascimento(), medico.getDataNascimento());
        assertEquals("A cor ou raça deve ser Branca", "Branca", medico.getCorOuRaca());
        assertEquals("O telefone deve ser (83)33512678", "(83)33512678", medico.getTelefone1());
        assertEquals("O telefone deve ser (83)98474782", "(83)98474782", medico.getTelefone2());
        assertEquals("O email deve ser usuario@dominio.com", "usuario@dominio.com", medico.getEmail());
        assertEquals("A rua deve ser Avenida Brasil", "Avenida Brasil", medico.getEnderecoRua());
        assertEquals("O número deve ser 10", "10", medico.getEnderecoNumero());
        assertEquals("O bairro deve ser Centro", "Centro", medico.getEnderecoBairro());
        assertEquals("O cep esperado deve ser 58500-000", "58500-000", medico.getEnderecoCep());
        assertEquals("A cidade esperada deve ser Monteiro", "Monteiro", medico.getEnderecoCidade());
        assertEquals("O rg esperado deve ser " + medico.getEnderecoEstado(), medico.getEnderecoEstado(), medico.getEnderecoEstado());
    }

}
