package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.EnfermeiroDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author elisangela
 */
public class EnfermeiroService implements Serializable {

    @Inject
    private EnfermeiroDao enfermeiroDAO;
    private Enfermeiro enfermeiro;

    @Transactional
    public void save(Enfermeiro enfermeiro) throws UBSException {
        this.enfermeiroDAO.salvar(enfermeiro);
    }

    @Transactional
    public void delete(Enfermeiro enfermeiro) throws UBSException {
        this.enfermeiro = findById(enfermeiro.getId());
        enfermeiroDAO.delete(enfermeiro);
    }

    public List<Enfermeiro> findAll() {
        return enfermeiroDAO.findAll();
    }

    public Enfermeiro findById(Long id) throws UBSException {
        return enfermeiroDAO.findById(id);
    }

}
