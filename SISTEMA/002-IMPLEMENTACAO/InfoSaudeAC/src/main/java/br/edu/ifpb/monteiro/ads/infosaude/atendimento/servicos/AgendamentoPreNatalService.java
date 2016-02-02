package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.AgendamentoPreNatalDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.AgendamentoPreNatal;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.AgendamentoPreNatalServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Classe de serviço que faz chamadas aos métodos de persistência e pode conter
 * lógica de negócio e pode fazer chamadas a outras partes do sistema, caso
 * necessite.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class AgendamentoPreNatalService implements AgendamentoPreNatalServiceIF, Serializable {
    
    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(AgendamentoPreNatalService.class);
    
    @Inject
    private AgendamentoPreNatalDao agendamentoPreNatalDao;

    public AgendamentoPreNatalService() {
    }
    
    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param agendamentoPreNatal
     */
    @Transactional
    @Override
    public void save(AgendamentoPreNatal agendamentoPreNatal) {
        this.agendamentoPreNatalDao.salvar(agendamentoPreNatal);
    }
    
    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param agendamentoPreNatal
     */
    @Transactional
    @Override
    public void delete(AgendamentoPreNatal agendamentoPreNatal) throws NegocioException {
        agendamentoPreNatalDao.delete(findById(agendamentoPreNatal.getId()));
        LOGGER.info("Agendagemento com id "+ agendamentoPreNatal.getId() + "removido.");
    }
    
    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public AgendamentoPreNatal findById(Long id) {
        return agendamentoPreNatalDao.findById(id);
    }
    
    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    @Override
    public List<AgendamentoPreNatal> findAll() {
        return agendamentoPreNatalDao.findAll();
    }

}
