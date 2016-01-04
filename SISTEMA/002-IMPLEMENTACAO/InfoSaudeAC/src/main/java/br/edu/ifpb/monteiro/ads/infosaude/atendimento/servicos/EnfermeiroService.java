package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.EnfermeiroDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
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
public class EnfermeiroService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EnfermeiroDao enfermeiroDAO;

    public EnfermeiroService() {
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param enfermeiro
     */
    @Transactional
    public void save(Enfermeiro enfermeiro) {
        if (enfermeiro != null) {
            this.enfermeiroDAO.salvar(enfermeiro);
        }
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param enfermeiro
     * @throws NegocioException
     */
    @Transactional
    public void delete(Enfermeiro enfermeiro) throws NegocioException {
        enfermeiroDAO.delete(findById(enfermeiro.getId()));
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    public List<Enfermeiro> findAll() {
        return enfermeiroDAO.findAll();
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public Enfermeiro findById(Long id) {
        return enfermeiroDAO.findById(id);
    }
}
