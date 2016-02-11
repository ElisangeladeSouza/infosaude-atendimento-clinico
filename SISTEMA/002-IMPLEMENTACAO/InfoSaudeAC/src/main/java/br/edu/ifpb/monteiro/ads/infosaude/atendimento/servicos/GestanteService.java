package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.GestanteDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Gestante;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.GestanteServiceIF;
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
public class GestanteService implements GestanteServiceIF, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private GestanteDao gestanteDao;

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param gestante 
     */
    @Transactional
    @Override
    public void save(Gestante gestante) {
        gestante.setData(new DateTimeUtilBean().getDateToday());
        if(gestante != null) {
            this.gestanteDao.salvar(gestante);
        } 
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * @param gestante 
     * @throws NegocioException
     */
    @Transactional
    @Override
    public void delete(Gestante gestante) throws NegocioException {
        gestanteDao.delete(findById(gestante.getId()));
    }
    
    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public Gestante findById(Long id) {
        return gestanteDao.findById(id);
    }
    
    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    @Override
    public List<Gestante> findAll() {
        return gestanteDao.findAll();
    }
}
