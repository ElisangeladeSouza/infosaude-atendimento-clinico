package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.ContaDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Conta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.ContaServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 * Classe de serviço que faz chamadas aos métodos de persistência e pode conter
 * lógica de negócio e pode fazer chamadas a outras partes do sistema, caso
 * necessite.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class ContaService implements ContaServiceIF, Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ContaDao contaDao;

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param conta 
     */
    @Transactional
    @Override
    public void save(Conta conta) throws NegocioException {
        this.contaDao.salvar(conta);
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param conta 
     * @throws NegocioException
     */
    @Transactional
    @Override
    public void delete(Conta conta) throws NegocioException {
        contaDao.delete(findById(conta.getId()));
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public Conta findById(Long id) {
        return contaDao.findById(id);
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    @Override
    public List<Conta> findAll() {
        return contaDao.findAll();
    }
}
