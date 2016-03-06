package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.PessoaServiceIF;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

/**
 * Classe de serviço que faz chamadas aos métodos de persistência e pode conter
 * lógica de negócio e pode fazer chamadas a outras partes do sistema, caso
 * necessite.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class PessoaService implements PessoaServiceIF, Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PessoaDao pessoaDAO;

    public static List<Estados> estados = new ArrayList<>();
    public static List<String> cidades = new ArrayList<>();

    public PessoaService() {
        estados = Arrays.asList(Estados.values());
    }

    /**
     * Responsável por varrer a lista de cidades carregadas do banco,
     *
     * @param estado
     * @param codigoEstado
     */
    @Override
    public void retornaCidades(Object estado, Integer codigoEstado) {
        cidades.clear();
        if (estado != null) {
            for (String cidadesFiltradas : listaCidades(codigoEstado)) {
                cidades.add(cidadesFiltradas);
            }
        }
    }

    /**
     * Responsável por carregar a lista de todas as cidades do Brasil por um
     * código que a associa com um estado, através de uma consulta ao banco de
     * dados.
     *
     * @param codigoUF
     * @return
     */
    public List<String> listaCidades(int codigoUF) {
        return pessoaDAO.retornaCidades(codigoUF);
    }
}
