package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.ExameDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.ExameServiceIF;
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
public class ExameService implements ExameServiceIF, Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(ExameService.class);

    @Inject
    private ExameDao exameDao;

    public ExameService() {
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param exame 
     */
    @Transactional
    @Override
    public void save(Exame exame) {
        exame.setData(new DateTimeUtilBean().getDateToday());
        this.exameDao.salvar(exame);
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * @param exame
     * @throws NegocioException
     */
    @Transactional
    @Override
    public void delete(Exame exame) throws NegocioException {
        exameDao.delete(findById(exame.getId()));
        LOGGER.info("Exame com id "+ exame.getId() + "removido.");
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public Exame findById(Long id) {
        return exameDao.findById(id);
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    @Override
    public List<Exame> findAll() {
        return exameDao.findAll();
    }
    
}
