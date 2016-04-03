//package unidade.testes.modelo;
//
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Diretor;
//import java.util.Date;
//import static org.junit.Assert.assertEquals;
//import org.junit.Before;
//import org.junit.Test;
//
///**
// *
// * @author elisangela <elysangeladesouza@gmail.com>
// */
//public class DiretorTest {
//
//    private Diretor diretor = new Diretor();
//
//    public DiretorTest() {
//    }
//
//    /**
//     *
//     */
//    @Before
//    public void setUp() {
//        diretor = new Diretor();
//
//        diretor.setCpfDiretor("271.503.479-24");
//        diretor.setCartaoSusDiretor("2340956716582");
//        diretor.setNome("Maria de Lurdes");
//        diretor.setDataNascimento(new Date());
//        diretor.setCorOuRaca("BRANCA");
//        diretor.setEmail("maria@gmail.com");
//        diretor.setEnderecoBairro("Centro");
//        diretor.setEnderecoCep("58500-000");
//        diretor.setEnderecoCidade("Monteiro");
//        diretor.setEnderecoEstado(Estados.PB);
//        diretor.setEnderecoNumero("88");
//        diretor.setEnderecoRua("Rua Francisco de Alcântara Torres");
//        diretor.setRg("8926371");
//        diretor.setTelefone1("(83) 999467281");
//
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testCreateObjetc() {
//        System.out.println(diretor.getCpfDiretor());
//        System.out.println(diretor.getCartaoSusDiretor());
//        System.out.println(diretor.getNome());
//        System.out.println(diretor.getDataNascimento());
//        System.out.println(diretor.getCorOuRaca());
//        System.out.println(diretor.getEmail());
//        System.out.println(diretor.getEnderecoBairro());
//        System.out.println(diretor.getEnderecoCep());
//        System.out.println(diretor.getEnderecoCidade());
//        System.out.println(diretor.getEnderecoEstado());
//        System.out.println(diretor.getEnderecoNumero());
//        System.out.println(diretor.getEnderecoRua());
//        System.out.println(diretor.getRg());
//        System.out.println(diretor.getTelefone1());
//
//        assertEquals("O cpf esperado deve ser 271.503.479-24", "271.503.479-24", diretor.getCpfDiretor());
//        assertEquals("O cartão sus esperado deve ser 2340956716582", "2340956716582", diretor.getCartaoSusDiretor());
//        assertEquals("O nome esperado deve ser Maria de Lurdes", "Maria de Lurdes", diretor.getNome());
//        assertEquals("A data esperada deve ser " + diretor.getDataNascimento(), diretor.getDataNascimento(),
//                diretor.getDataNascimento());
//        assertEquals("A cor/raça esperada deve ser BRANCA", "BRANCA", diretor.getCorOuRaca());
//        assertEquals("O email esperado deve ser maria@gmail.com", "maria@gmail.com", diretor.getEmail());
//        assertEquals("O bairro esperado deve ser Centro", "Centro", diretor.getEnderecoBairro());
//        assertEquals("O cep esperado deve ser 58500-000", "58500-000", diretor.getEnderecoCep());
//        assertEquals("A cidade esperada deve ser Monteiro", "Monteiro", diretor.getEnderecoCidade());
//        assertEquals("O estado esperado deve ser " + diretor.getEnderecoEstado(), diretor.getEnderecoEstado(),
//                diretor.getEnderecoEstado());
//        assertEquals("O número esperado deve ser 88", "88", diretor.getEnderecoNumero());
//        assertEquals("A rua esperada deve ser Rua Francisco de Alcântara Torres", "Rua Francisco de Alcântara Torres",
//                diretor.getEnderecoRua());
//        assertEquals("O rg esperado deve ser 8926371", "8926371", diretor.getRg());
//        assertEquals("O telefone esperado deve ser (83) 999467281", "(83) 999467281", diretor.getTelefone1());
//    }
//}
