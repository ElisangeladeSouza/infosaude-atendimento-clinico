package unidade.testes.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Recepcionista;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author elisangela
 */
public class RecepcionistaTest {

    private Recepcionista recepcionista;

    public RecepcionistaTest() {
    }

    @Before
    public void setUp() {
        recepcionista = new Recepcionista();

        recepcionista.setCpf("173.375.113-02");
        recepcionista.setCartaoSus("78263710923");
        recepcionista.setNome("Fabiana Costa");
        recepcionista.setDataNascimento(new Date());
        recepcionista.setCorOuRaca("PARDA");
        recepcionista.setEmail("fabiana@gmail.com");
        recepcionista.setTelefone1("(83) 999026725");
        recepcionista.setTelefone2("(83) 999763002");
        recepcionista.setEnderecoBairro("Alto da Bela Vista");
        recepcionista.setEnderecoCep("58500-000");
        recepcionista.setEnderecoCidade("Monteiro");
        recepcionista.setEnderecoEstado(Estados.PB);
        recepcionista.setEnderecoNumero("28");
        recepcionista.setEnderecoRua("Rua Euclides da Cunha");
        recepcionista.setRg("9217406");
    }

    @Test
    public void testCreateObjetc() {
        System.out.println(recepcionista.getCpf());
        System.out.println(recepcionista.getCartaoSus());
        System.out.println(recepcionista.getNome());
        System.out.println(recepcionista.getDataNascimento());
        System.out.println(recepcionista.getCorOuRaca());
        System.out.println(recepcionista.getEmail());
        System.out.println(recepcionista.getTelefone1());
        System.out.println(recepcionista.getTelefone2());
        System.out.println(recepcionista.getEnderecoBairro());
        System.out.println(recepcionista.getEnderecoCep());
        System.out.println(recepcionista.getEnderecoCidade());
        System.out.println(recepcionista.getEnderecoEstado());
        System.out.println(recepcionista.getEnderecoNumero());
        System.out.println(recepcionista.getEnderecoRua());
        System.out.println(recepcionista.getRg());

        assertEquals("O cpf esperado deve ser 173.375.113-02", "173.375.113-02", recepcionista.getCpf());
        assertEquals("O cartão sus esperado deve ser 78263710923", "78263710923", recepcionista.getCartaoSus());
        assertEquals("O nome esperado deve ser Fabiana Costa", "Fabiana Costa", recepcionista.getNome());
        assertEquals("A data esperada deve ser " + recepcionista.getDataNascimento(), recepcionista.getDataNascimento(),
                recepcionista.getDataNascimento());
        assertEquals("A cor/raça esperada deve ser PARDA", "PARDA", recepcionista.getCorOuRaca());
        assertEquals("O email esperado deve ser fabiana@gmail.com", "fabiana@gmail.com", recepcionista.getEmail());
        assertEquals("O telefone esperado deve ser (83) 999026725", "(83) 999026725", recepcionista.getTelefone1());
        assertEquals("O telefone esperado deve ser (83) 999763002", "(83) 999763002", recepcionista.getTelefone2());
        assertEquals("O bairro esperado deve ser Alto da Bela Vista", "Alto da Bela Vista", recepcionista.getEnderecoBairro());
        assertEquals("O cep esperado deve ser 58500-000", "58500-000", recepcionista.getEnderecoCep());
        assertEquals("A cidade esperada deve ser Monteiro", "Monteiro", recepcionista.getEnderecoCidade());
        assertEquals("O estado esperado deve ser " + recepcionista.getEnderecoEstado(), recepcionista.getEnderecoEstado(),
                recepcionista.getEnderecoEstado());
        assertEquals("O número esperado deve ser 28", "28", recepcionista.getEnderecoNumero());
        assertEquals("A rua esperada deve ser Rua Euclides da Cunha", "Rua Euclides da Cunha",
                recepcionista.getEnderecoRua());
        assertEquals("O rg esperado deve ser 9217406", "9217406", recepcionista.getRg());

    }
}
