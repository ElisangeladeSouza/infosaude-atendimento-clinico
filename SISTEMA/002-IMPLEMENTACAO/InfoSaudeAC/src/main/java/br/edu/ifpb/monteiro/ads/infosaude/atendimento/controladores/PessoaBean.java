package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.RacaCor;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.PessoaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.inject.Model;

/**
 * Managed bean usado pela página de cadastro de pessoa. É responsável por ligar
 * a classe de modelo Pessoa à página de visualização processando as
 * solicitações do usuário e retornando os dados à visualização.
 *
 * @author cassio <cassio@cassioliveira.com.br>
 */
@Model
public class PessoaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private final transient List<RacaCor> racas;
    private List<Estados> estados = new ArrayList<>();
    private List<String> cidades = new ArrayList<>();

    /**
     * Construtor da classe Inicia o array com os raça e cor possíveis de serem
     * cadastradas no sistema. De acordo como o estabelecido nas leis do Estado
     * Brasileiro.
     *
     * Iniciar também o array de estados da federação. E suas respectivas
     * siglas.
     *
     * @see RacaCor
     * @see Estados
     */
    public PessoaBean() {
        racas = Arrays.asList(RacaCor.values());
//        estados = Arrays.asList(Estados.values());
    }

    /**
     * Lista os estados da federação previamente cadastrados no banco.
     *
     * @return
     */
    public List<Estados> getEstados() {
        this.estados = PessoaService.estados;
        return estados;
    }

    /**
     * Lista as cidades previamente cadastradas no banco.
     *
     * @return
     */
    public List<String> getCidades() {
        this.cidades = PessoaService.cidades;
        return cidades;
    }

    /**
     * Lista as raças e/ou cores de acordo com as leis estabelecidas pelo Estado
     * Brasileiro.
     *
     * @return
     */
    public List<RacaCor> getRacas() {
        return racas;
    }
}
