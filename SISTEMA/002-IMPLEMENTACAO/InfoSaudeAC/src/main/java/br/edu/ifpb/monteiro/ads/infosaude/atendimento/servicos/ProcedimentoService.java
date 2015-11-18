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
 * @author elisangela
 */
public class ProcedimentoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProcedimentoDao procedimentoDao;

    /**
     *
     */
    public ProcedimentoService() {
    }

    /**
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
     *
     * @param procedimento
     * @throws NegocioException
     */
    @Transactional
    public void delete(Procedimento procedimento) throws NegocioException {
        procedimentoDao.delete(findById(procedimento.getId()));
    }

    /**
     *
     * @param id
     * @return
     */
    public Procedimento findById(Long id) {
        return procedimentoDao.findById(id);
    }

    /**
     *
     * @return
     */
    public List<Procedimento> findAll() {
        return procedimentoDao.findAll();
    }

}
