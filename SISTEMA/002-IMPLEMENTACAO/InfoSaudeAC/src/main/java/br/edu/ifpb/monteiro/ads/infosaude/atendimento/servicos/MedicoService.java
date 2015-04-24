package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.MedicoDAO;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Medico;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author elisangela
 */
public class MedicoService implements Serializable {

    @Inject
    private MedicoDAO medicoDao;
    private Medico medico;

    @Transactional
    public void save(Medico medico) throws UBSException {
        medicoDao.salvar(medico);
    }

    @Transactional
    public void delete(Medico medico) throws UBSException {
        this.medico = findById(medico.getId());
        medicoDao.delete(medico);
    }

    public Medico findById(Long id) throws UBSException {
        return medicoDao.findById(id);
    }

    public List<Medico> findAll() {
        return medicoDao.findAll();
    }

}
