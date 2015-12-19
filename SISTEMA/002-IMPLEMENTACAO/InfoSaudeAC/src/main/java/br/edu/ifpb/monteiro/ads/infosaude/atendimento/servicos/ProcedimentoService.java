package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.ProcedimentoDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Procedimento;
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
public class ProcedimentoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProcedimentoDao procedimentoDao;

    public ProcedimentoService() {
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param procedimento
     */
    @Transactional
    public void save(Procedimento procedimento) {
        if (procedimento != null) {
            procedimento.setData(new DateTimeUtilBean().getDateToday());
            this.procedimentoDao.salvar(procedimento);
        }
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param procedimento
     * @throws NegocioException
     */
    @Transactional
    public void delete(Procedimento procedimento) throws NegocioException {
        procedimentoDao.delete(findById(procedimento.getId()));
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public Procedimento findById(Long id) {
        return procedimentoDao.findById(id);
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    public List<Procedimento> findAll() {
        return procedimentoDao.findAll();
    }

}
