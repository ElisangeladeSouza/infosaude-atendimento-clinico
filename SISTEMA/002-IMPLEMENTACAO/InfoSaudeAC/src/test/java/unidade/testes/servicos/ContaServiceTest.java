/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Permissao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Conta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ContaService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author wilde
 */
public class ContaServiceTest {

    private static Conta conta;
    private static Conta novaConta;

    @Mock
    private ContaService contaService;

    public ContaServiceTest() {

        contaService = new ContaService();

    }

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        conta = new Conta();
        novaConta = new Conta();

    }

    @Test
    public void testSaveCamposObrigatorios() {

        conta.setPassword("123");
        conta.setUserName("ubs");
        conta.setPermissao(Permissao.MEDICO);

        when(contaService.findById(1L)).thenReturn(conta);

        novaConta = contaService.findById(1L);

        assertEquals("123", novaConta.getPassword());
        assertEquals("ubs", novaConta.getUserName());
        assertEquals(conta.getPermissao(), novaConta.getPermissao());
    }

    @Test(expected = Exception.class)
    public void testFindByIdInexistente() {
        when(contaService.findById(0L)).thenThrow(new Exception());
        conta = contaService.findById(0L);
    }

    @Test
    public void testFindAll() {

        List<Conta> listaContas = new ArrayList<>();

        conta.setUserName("cool");
        conta.setPassword("cool");
        conta.setPermissao(Permissao.ADMIN);

        listaContas.add(conta);

        when(contaService.findAll()).thenReturn(listaContas);

        assertFalse(listaContas.isEmpty());

    }
}
