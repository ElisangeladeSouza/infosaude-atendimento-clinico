package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.EnfermeiroDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
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
public class EnfermeiroService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EnfermeiroDao enfermeiroDAO;

    public EnfermeiroService() {
    }

    @Transactional
    public void save(Enfermeiro enfermeiro) {
        if (enfermeiro != null) {
            this.enfermeiroDAO.salvar(enfermeiro);
        }
    }

    @Transactional
    public void delete(Enfermeiro enfermeiro) throws UBSException {
        enfermeiroDAO.delete(findById(enfermeiro.getId()));
    }

    public List<Enfermeiro> findAll() {
        return enfermeiroDAO.findAll();
    }

    public Enfermeiro findById(Long id) {
        return enfermeiroDAO.findById(id);
    }

}
