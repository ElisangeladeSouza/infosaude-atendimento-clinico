package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.DiretorDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Diretor;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.DiretorServiceIF;
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
public class DiretorService implements DiretorServiceIF, Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private DiretorDao diretorDAO;

    public DiretorService() {
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param diretor
     */
    @Transactional
    @Override
    public void save(Diretor diretor) {
        if (diretor != null) {
            this.diretorDAO.salvar(diretor);
        }
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param diretor
     * @throws NegocioException
     */
    @Transactional
    @Override
    public void delete(Diretor diretor) throws NegocioException {
        diretorDAO.delete(findById(diretor.getId()));
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    @Override
    public List<Diretor> findAll() {
        return diretorDAO.findAll();
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    @Override
    public Diretor findById(Long id) {
        return diretorDAO.findById(id);
    }
}
