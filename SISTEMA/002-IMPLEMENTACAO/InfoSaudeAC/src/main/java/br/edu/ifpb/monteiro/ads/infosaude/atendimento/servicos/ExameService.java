package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.ExameDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author elisangela
 */
public class ExameService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ExameDao exameDao;

    public ExameService() {
    }

    @Transactional
    public void save(Exame exame) {
        if (exame != null) {
            exame.setData(new DateTimeUtilBean().getDateToday());
            this.exameDao.salvar(exame);
        }
    }

    @Transactional
    public void delete(Exame exame) throws UBSException {
        exameDao.delete(findById(exame.getId()));
    }

    public Exame findById(Long id) {
        return exameDao.findById(id);
    }

    public List<Exame> findAll() {
        return exameDao.findAll();
    }

}
