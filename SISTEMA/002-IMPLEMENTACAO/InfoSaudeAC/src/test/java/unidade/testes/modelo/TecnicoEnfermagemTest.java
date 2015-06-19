package unidade.testes.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.TecnicoEnfermagem;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author elisangela
 */
public class TecnicoEnfermagemTest {

    private TecnicoEnfermagem tecnicoEnfermagem;

    /**
     *
     */
    public TecnicoEnfermagemTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        tecnicoEnfermagem = new TecnicoEnfermagem();
        tecnicoEnfermagem.setNome("Joelton");
        tecnicoEnfermagem.setCorenTecnicoEnfermagem("2789012");
        tecnicoEnfermagem.setCpfTecnicoEnfermagem("415.706.534-45");
        tecnicoEnfermagem.setRg("26475828");
        tecnicoEnfermagem.setCartaoSusTecnicoEnfermagem("65745437543");
        tecnicoEnfermagem.setDataNascimento(new Date());
        tecnicoEnfermagem.setCorOuRaca("Branca");
        tecnicoEnfermagem.setTelefone1("(83)33512678");
        tecnicoEnfermagem.setTelefone2("(83)98474782");
        tecnicoEnfermagem.setEmail("usuario@dominio.com");
        tecnicoEnfermagem.setEnderecoRua("Avenida Brasil");
        tecnicoEnfermagem.setEnderecoNumero("10");
        tecnicoEnfermagem.setEnderecoBairro("Centro");
        tecnicoEnfermagem.setEnderecoCep("58500-000");
        tecnicoEnfermagem.setEnderecoCidade("Monteiro");
        tecnicoEnfermagem.setEnderecoEstado(Estados.PB);

    }

    /**
     *
     */
    @Test
    public void testCreateObjetc() {
        System.out.println(tecnicoEnfermagem.getNome());
        System.out.println(tecnicoEnfermagem.getCorenTecnicoEnfermagem());
        System.out.println(tecnicoEnfermagem.getCpfTecnicoEnfermagem());
        System.out.println(tecnicoEnfermagem.getRg());
        System.out.println(tecnicoEnfermagem.getCartaoSusTecnicoEnfermagem());
        System.out.println(tecnicoEnfermagem.getDataNascimento());
        System.out.println(tecnicoEnfermagem.getCorOuRaca());
        System.out.println(tecnicoEnfermagem.getTelefone1());
        System.out.println(tecnicoEnfermagem.getTelefone2());
        System.out.println(tecnicoEnfermagem.getEmail());
        System.out.println(tecnicoEnfermagem.getEnderecoRua());
        System.out.println(tecnicoEnfermagem.getEnderecoNumero());
        System.out.println(tecnicoEnfermagem.getEnderecoBairro());
        System.out.println(tecnicoEnfermagem.getEnderecoCep());
        System.out.println(tecnicoEnfermagem.getEnderecoCidade());
        System.out.println(tecnicoEnfermagem.getEnderecoEstado());

        assertEquals("O nome esperado deve ser Joelton", "Joelton", tecnicoEnfermagem.getNome());
        assertEquals("O crm esperado deve ser 2789012", "2789012", tecnicoEnfermagem.getCorenTecnicoEnfermagem());
        assertEquals("O cpf esperado deve ser 415.706.534-45", "415.706.534-45", tecnicoEnfermagem.getCpfTecnicoEnfermagem());
        assertEquals("O rg esperado deve ser 26475828", "26475828", tecnicoEnfermagem.getRg());
        assertEquals("O cartão sus deve ser 65745437543", "65745437543", tecnicoEnfermagem.getCartaoSusTecnicoEnfermagem());
        assertEquals("A data esperada deve ser " + tecnicoEnfermagem.getDataNascimento(), tecnicoEnfermagem.getDataNascimento(),
                tecnicoEnfermagem.getDataNascimento());
        assertEquals("A cor ou raça deve ser Branca", "Branca", tecnicoEnfermagem.getCorOuRaca());
        assertEquals("O telefone deve ser (83)33512678", "(83)33512678", tecnicoEnfermagem.getTelefone1());
        assertEquals("O telefone deve ser (83)98474782", "(83)98474782", tecnicoEnfermagem.getTelefone2());
        assertEquals("O email deve ser usuario@dominio.com", "usuario@dominio.com", tecnicoEnfermagem.getEmail());
        assertEquals("A rua deve ser Avenida Brasil", "Avenida Brasil", tecnicoEnfermagem.getEnderecoRua());
        assertEquals("O número deve ser 10", "10", tecnicoEnfermagem.getEnderecoNumero());
        assertEquals("O bairro deve ser Centro", "Centro", tecnicoEnfermagem.getEnderecoBairro());
        assertEquals("O cep esperado deve ser 58500-000", "58500-000", tecnicoEnfermagem.getEnderecoCep());
        assertEquals("A cidade esperada deve ser Monteiro", "Monteiro", tecnicoEnfermagem.getEnderecoCidade());
        assertEquals("O estado esperado deve ser " + tecnicoEnfermagem.getEnderecoEstado(), tecnicoEnfermagem.getEnderecoEstado(),
                tecnicoEnfermagem.getEnderecoEstado());
    }

}
