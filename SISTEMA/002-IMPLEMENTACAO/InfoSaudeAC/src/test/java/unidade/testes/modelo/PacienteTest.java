//package unidade.testes.modelo;
//
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Paciente;
//import java.util.Date;
//import static org.junit.Assert.assertEquals;
//import org.junit.Before;
//import org.junit.Test;
//
///**
// *
// * @author elisangela <elysangeladesouza@gmail.com>
// */
//public class PacienteTest {
//
//    private Paciente paciente;
//
//    public PacienteTest() {
//    }
//
//    /**
//     *
//     */
//    @Before
//    public void setUp() {
//        paciente = new Paciente();
//        paciente.setNome("Witalo");
//        paciente.setCpf("732.651.744-41");
//        paciente.setRg("26475828");
//        paciente.setCartaoSus("65745437543");
//        paciente.setDataNascimento(new Date());
//        paciente.setCorOuRaca("Branca");
//        paciente.setAltura(170.0);
//        paciente.setPeso(90.0);
//        paciente.setNomeDaMae("Maria");
//        paciente.setTelefone1("(83)33512678");
//        paciente.setTelefone2("(83)98474782");
//        paciente.setEmail("usuario@dominio.com");
//        paciente.setEnderecoRua("Avenida Brasil");
//        paciente.setEnderecoNumero("10");
//        paciente.setEnderecoBairro("Centro");
//        paciente.setEnderecoCep("58500-000");
//        paciente.setEnderecoCidade("Monteiro");
//        paciente.setEnderecoEstado(Estados.PB);
//
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testCreateObjetc() {
//        System.out.println(paciente.getNome());
//        System.out.println(paciente.getCpf());
//        System.out.println(paciente.getRg());
//        System.out.println(paciente.getCartaoSus());
//        System.out.println(paciente.getDataNascimento());
//        System.out.println(paciente.getNomeDaMae());
//        System.out.println(paciente.getCorOuRaca());
//        System.out.println(paciente.getTelefone1());
//        System.out.println(paciente.getTelefone2());
//        System.out.println(paciente.getEmail());
//        System.out.println(paciente.getEnderecoRua());
//        System.out.println(paciente.getEnderecoNumero());
//        System.out.println(paciente.getEnderecoBairro());
//        System.out.println(paciente.getEnderecoCep());
//        System.out.println(paciente.getEnderecoCidade());
//        System.out.println(paciente.getEnderecoEstado());
//
//        assertEquals("O nome esperado deve ser Witalo", "Witalo", paciente.getNome());
//        assertEquals("O cpf esperado deve ser 732.651.744-41", "732.651.744-41", paciente.getCpf());
//        assertEquals("O rg esperado deve ser 26475828", "26475828", paciente.getRg());
//        assertEquals("O cartão sus deve ser 65745437543", "65745437543", paciente.getCartaoSus());
//        assertEquals("A data esperada deve ser " + paciente.getDataNascimento(), paciente.getDataNascimento(), paciente.getDataNascimento());
//        assertEquals("O rg esperado deve ser Maria", "Maria", paciente.getNomeDaMae());
//        assertEquals("A cor ou raça deve ser Branca", "Branca", paciente.getCorOuRaca());
//        assertEquals("O telefone deve ser (83)33512678", "(83)33512678", paciente.getTelefone1());
//        assertEquals("O telefone deve ser (83)98474782", "(83)98474782", paciente.getTelefone2());
//        assertEquals("O email deve ser usuario@dominio.com", "usuario@dominio.com", paciente.getEmail());
//        assertEquals("A rua deve ser Avenida Brasil", "Avenida Brasil", paciente.getEnderecoRua());
//        assertEquals("O número deve ser 10", "10", paciente.getEnderecoNumero());
//        assertEquals("O bairro deve ser Centro", "Centro", paciente.getEnderecoBairro());
//        assertEquals("O cep esperado deve ser 58500-000", "58500-000", paciente.getEnderecoCep());
//        assertEquals("A cidade esperada deve ser Monteiro", "Monteiro", paciente.getEnderecoCidade());
//        assertEquals("O estado esperado deve ser " + paciente.getEnderecoEstado(), paciente.getEnderecoEstado(), paciente.getEnderecoEstado());
//    }
//}
