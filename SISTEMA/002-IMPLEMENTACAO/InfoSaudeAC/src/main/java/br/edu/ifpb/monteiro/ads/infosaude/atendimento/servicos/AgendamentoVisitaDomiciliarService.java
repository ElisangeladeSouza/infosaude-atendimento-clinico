package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.AgendamentoVisitaDomiciliarDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.AgendamentoVisitaDomiciliar;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.AgendamentoVisitaDomiciliarServiceIF;
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
public class AgendamentoVisitaDomiciliarService implements AgendamentoVisitaDomiciliarServiceIF, Serializable {
    
    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(AgendamentoVisitaDomiciliarService.class);

    @Inject
    private AgendamentoVisitaDomiciliarDao agendamentoVisitaDomiciliarDao;
    
    public AgendamentoVisitaDomiciliarService() {
    }
    
    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param agendamentoVisitaDomiciliar 
     */
    @Transactional
    @Override
    public void save(AgendamentoVisitaDomiciliar agendamentoVisitaDomiciliar) {
        if(agendamentoVisitaDomiciliar != null) {
            agendamentoVisitaDomiciliar.setData(new DateTimeUtilBean().getDateToday());
            this.agendamentoVisitaDomiciliarDao.salvar(agendamentoVisitaDomiciliar);
        }
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param agendamentoVisitaDomiciliar
     */
    @Transactional
    @Override
    public void delete(AgendamentoVisitaDomiciliar agendamentoVisitaDomiciliar) throws NegocioException {
        agendamentoVisitaDomiciliarDao.delete(findById(agendamentoVisitaDomiciliar.getId()));
        LOGGER.info("Visita domiciliar com id "+ agendamentoVisitaDomiciliar.getId() + "removido.");
    }
    
    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public AgendamentoVisitaDomiciliar findById(Long id) {
        return agendamentoVisitaDomiciliarDao.findById(id);
    }
    
    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    @Override
    public List<AgendamentoVisitaDomiciliar> findAll() {
        return agendamentoVisitaDomiciliarDao.findAll();
    }
}
