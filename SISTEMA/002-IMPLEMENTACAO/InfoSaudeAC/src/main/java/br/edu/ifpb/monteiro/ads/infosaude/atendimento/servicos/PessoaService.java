package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Pessoa;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 * Classe de serviço que faz chamadas aos métodos de persistência e pode conter
 * lógica de negócio e pode fazer chamadas a outras partes do sistema, caso
 * necessite.
 *
 * @author Cássio Oliveira
 */
public class PessoaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PessoaDao pessoaDAO;

    public PessoaService() {
    }

    @Transactional
    public void save(Pessoa pessoa) {
        this.pessoaDAO.salvar(pessoa);
    }

    @Transactional
    public void delete(Pessoa pessoa) throws UBSException {
        pessoaDAO.delete(findById(pessoa.getId()));
    }

    public List<Pessoa> findAll() {
        return pessoaDAO.findAll();
    }

    public Pessoa findById(Long id) {
        return pessoaDAO.findById(id);
    }

    public List<String> retornaCidades(int codigoUF) {
        return pessoaDAO.retornaCidades(codigoUF);
    }
}
