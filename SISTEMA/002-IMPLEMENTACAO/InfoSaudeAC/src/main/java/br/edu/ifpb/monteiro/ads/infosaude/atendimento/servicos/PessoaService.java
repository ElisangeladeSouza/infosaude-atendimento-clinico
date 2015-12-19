package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.PessoaDao;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 * Classe de serviço que faz chamadas aos métodos de persistência e pode conter
 * lógica de negócio e pode fazer chamadas a outras partes do sistema, caso
 * necessite.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class PessoaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PessoaDao pessoaDAO;

    public PessoaService() {
    }

    /**
     * Método responsável por carregar a lista de todas as cidades da federação 
     * através de uma consulta ao banco de dados.
     * 
     * @param codigoUF
     * @return
     */
    public List<String> retornaCidades(int codigoUF) {
        return pessoaDAO.retornaCidades(codigoUF);
    }
}
