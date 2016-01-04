package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.RecepcionistaDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Recepcionista;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
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
public class RecepcionistaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RecepcionistaDao recepcionistaDAO;

    public RecepcionistaService() {
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param recepcionista
     */
    @Transactional
    public void save(Recepcionista recepcionista) {
        if (recepcionista != null) {
            recepcionistaDAO.salvar(recepcionista);
        }
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param recepcionista
     * @throws NegocioException
     */
    @Transactional
    public void delete(Recepcionista recepcionista) throws NegocioException {
        recepcionistaDAO.delete(findById(recepcionista.getId()));
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    public List<Recepcionista> findAll() {
        return recepcionistaDAO.findAll();
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public Recepcionista findById(Long id) {
        return recepcionistaDAO.findById(id);
    }
}
