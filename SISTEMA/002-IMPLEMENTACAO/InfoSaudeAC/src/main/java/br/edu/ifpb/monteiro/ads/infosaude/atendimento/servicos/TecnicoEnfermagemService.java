package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.TecnicoEnfermagemDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.TecnicoEnfermagem;
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
public class TecnicoEnfermagemService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TecnicoEnfermagemDao tecnicoEnfermagemDAO;

    public TecnicoEnfermagemService() {
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param tecnicoEnfermagem
     */
    @Transactional
    public void save(TecnicoEnfermagem tecnicoEnfermagem) {
        if (tecnicoEnfermagem != null) {
            tecnicoEnfermagemDAO.salvar(tecnicoEnfermagem);
        }
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param tecnicoEnfermagem
     * @throws NegocioException
     */
    @Transactional
    public void delete(TecnicoEnfermagem tecnicoEnfermagem) throws NegocioException {
        tecnicoEnfermagemDAO.delete(findById(tecnicoEnfermagem.getId()));
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    public List<TecnicoEnfermagem> findAll() {
        return tecnicoEnfermagemDAO.findAll();
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public TecnicoEnfermagem findById(Long id) {
        return tecnicoEnfermagemDAO.findById(id);
    }

}
