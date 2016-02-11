package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.FichaPreNatalDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaPreNatal;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.FichaPreNatalServiceIF;
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
public class FichaPreNatalService implements FichaPreNatalServiceIF, Serializable {
    
    private static final long serialVersionUID = 1L;

    @Inject
    private FichaPreNatalDao fichaPreNatalDao;
    
    public FichaPreNatalService() {
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param fichaPreNatal
     */
    @Transactional
    @Override
    public void save(FichaPreNatal fichaPreNatal) {
        if (fichaPreNatal != null) {
            fichaPreNatal.setDataAtendimento(new DateTimeUtilBean().getDateToday());
            this.fichaPreNatalDao.salvar(fichaPreNatal);
        }
    }
    
    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param fichaPreNatal
     * @throws NegocioException 
     */
    @Transactional
    @Override
    public void delete(FichaPreNatal fichaPreNatal) throws NegocioException {
        fichaPreNatalDao.delete(findById(fichaPreNatal.getId()));
    }
    
    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return 
     */
    public FichaPreNatal findById(Long id) {
        return fichaPreNatalDao.findById(id);
    }
    
    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return 
     */
    @Override
    public List<FichaPreNatal> findAll() {
        return fichaPreNatalDao.findAll();
    }


    
}
