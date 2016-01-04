package unidade.testes.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Administrador;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class AdministradorTest {

    private Administrador administrador = new Administrador();

    /**
     *
     */
    public AdministradorTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        administrador = new Administrador();

        administrador.setCpfAdministrador("271.503.479-24");
        administrador.setCartaoSusAdministrador("2340956716582");
        administrador.setNome("Maria de Lurdes");
        administrador.setDataNascimento(new Date());
        administrador.setCorOuRaca("BRANCA");
        administrador.setEmail("maria@gmail.com");
        administrador.setEnderecoBairro("Centro");
        administrador.setEnderecoCep("58500-000");
        administrador.setEnderecoCidade("Monteiro");
        administrador.setEnderecoEstado(Estados.PB);
        administrador.setEnderecoNumero("88");
        administrador.setEnderecoRua("Rua Francisco de Alcântara Torres");
        administrador.setRg("8926371");
        administrador.setTelefone1("(83) 999467281");

    }

    /**
     *
     */
    @Test
    public void testCreateObjetc() {
        System.out.println(administrador.getCpfAdministrador());
        System.out.println(administrador.getCartaoSusAdministrador());
        System.out.println(administrador.getNome());
        System.out.println(administrador.getDataNascimento());
        System.out.println(administrador.getCorOuRaca());
        System.out.println(administrador.getEmail());
        System.out.println(administrador.getEnderecoBairro());
        System.out.println(administrador.getEnderecoCep());
        System.out.println(administrador.getEnderecoCidade());
        System.out.println(administrador.getEnderecoEstado());
        System.out.println(administrador.getEnderecoNumero());
        System.out.println(administrador.getEnderecoRua());
        System.out.println(administrador.getRg());
        System.out.println(administrador.getTelefone1());

        assertEquals("O cpf esperado deve ser 271.503.479-24", "271.503.479-24", administrador.getCpfAdministrador());
        assertEquals("O cartão sus esperado deve ser 2340956716582", "2340956716582", administrador.getCartaoSusAdministrador());
        assertEquals("O nome esperado deve ser Maria de Lurdes", "Maria de Lurdes", administrador.getNome());
        assertEquals("A data esperada deve ser " + administrador.getDataNascimento(), administrador.getDataNascimento(),
                administrador.getDataNascimento());
        assertEquals("A cor/raça esperada deve ser BRANCA", "BRANCA", administrador.getCorOuRaca());
        assertEquals("O email esperado deve ser maria@gmail.com", "maria@gmail.com", administrador.getEmail());
        assertEquals("O bairro esperado deve ser Centro", "Centro", administrador.getEnderecoBairro());
        assertEquals("O cep esperado deve ser 58500-000", "58500-000", administrador.getEnderecoCep());
        assertEquals("A cidade esperada deve ser Monteiro", "Monteiro", administrador.getEnderecoCidade());
        assertEquals("O estado esperado deve ser " + administrador.getEnderecoEstado(), administrador.getEnderecoEstado(),
                administrador.getEnderecoEstado());
        assertEquals("O número esperado deve ser 88", "88", administrador.getEnderecoNumero());
        assertEquals("A rua esperada deve ser Rua Francisco de Alcântara Torres", "Rua Francisco de Alcântara Torres",
                administrador.getEnderecoRua());
        assertEquals("O rg esperado deve ser 8926371", "8926371", administrador.getRg());
        assertEquals("O telefone esperado deve ser (83) 999467281", "(83) 999467281", administrador.getTelefone1());
    }
}
