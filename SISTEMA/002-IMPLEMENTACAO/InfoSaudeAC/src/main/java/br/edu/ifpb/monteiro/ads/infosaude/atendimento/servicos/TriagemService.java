package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.TriagemDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
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
 * @author elisangela
 */
public class TriagemService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TriagemDao triagemDao;

    /**
     *
     */
    public TriagemService() {
    }

    /**
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
     *
     * @param triagem
     * @throws UBSException
     */
    @Transactional
    public void delete(Triagem triagem) throws UBSException {
        triagemDao.delete(findById(triagem.getId()));
    }

    /**
     *
     * @param id
     * @return
     */
    public Triagem findById(Long id) {
        return triagemDao.findById(id);
    }

    /**
     *
     * @return
     */
    public List<Triagem> findAll() {
        return triagemDao.findAll();
    }

}
