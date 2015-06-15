package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.TecnicoEnfermagemDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.TecnicoEnfermagem;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author elisangela
 */
public class TecnicoEnfermagemService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TecnicoEnfermagemDao tecnicoEnfermagemDAO;

    public TecnicoEnfermagemService() {
    }

    @Transactional
    public void save(TecnicoEnfermagem tecnicoEnfermagem) {
        if (tecnicoEnfermagem != null) {
            tecnicoEnfermagemDAO.salvar(tecnicoEnfermagem);
        }
    }

    @Transactional
    public void delete(TecnicoEnfermagem tecnicoEnfermagem) throws UBSException {
        tecnicoEnfermagemDAO.delete(findById(tecnicoEnfermagem.getId()));
    }

    public List<TecnicoEnfermagem> findAll() {
        return tecnicoEnfermagemDAO.findAll();
    }

    public TecnicoEnfermagem findById(Long id) {
        return tecnicoEnfermagemDAO.findById(id);
    }

}
