package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.FichaAtendimentoDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 * Classe de serviço que faz chamadas aos métodos de persistência e pode conter
 * lógica de negócio e pode fazer chamadas a outras partes do sistema, caso
 * necessite.
 *
 * @author Cássio Oliveira
 */
public class FichaAtendimentoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private FichaAtendimentoDao fichaAtendimentoDao;

    /**
     *
     */
    public FichaAtendimentoService() {
    }

    /**
     *
     * @param fichaAtendimento
     */
    @Transactional
    public void save(FichaAtendimento fichaAtendimento) {
        if (fichaAtendimento != null) {
            fichaAtendimento.setData(new DateTimeUtilBean().getDateToday());
            this.fichaAtendimentoDao.salvar(fichaAtendimento);
        }
    }

    /**
     *
     * @param fichaAtendimento
     * @throws UBSException
     */
    @Transactional
    public void delete(FichaAtendimento fichaAtendimento) throws UBSException {
        fichaAtendimentoDao.delete(findById(fichaAtendimento.getId()));
    }

    /**
     *
     * @param id
     * @return
     */
    public FichaAtendimento findById(Long id) {
        return fichaAtendimentoDao.findById(id);
    }

    /**
     *
     * @return
     */
    public List<FichaAtendimento> findAll() {
        return fichaAtendimentoDao.findAll();
    }

}
