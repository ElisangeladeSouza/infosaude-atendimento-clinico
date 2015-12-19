package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.TriagemDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Triagem;
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
public class TriagemService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TriagemDao triagemDao;

    public TriagemService() {
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param triagem
     */
    @Transactional
    public void save(Triagem triagem) {
        if (triagem != null) {
            triagem.setData(new DateTimeUtilBean().getDateToday());
            this.triagemDao.salvar(triagem);
        }
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param triagem
     * @throws NegocioException
     */
    @Transactional
    public void delete(Triagem triagem) throws NegocioException {
        triagemDao.delete(findById(triagem.getId()));
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public Triagem findById(Long id) {
        return triagemDao.findById(id);
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    public List<Triagem> findAll() {
        return triagemDao.findAll();
    }

}
