package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.MedicoDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Medico;
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
public class MedicoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private MedicoDao medicoDao;

    /**
     *
     */
    public MedicoService() {
    }

    /**
     *
     * @param medico
     */
    @Transactional
    public void save(Medico medico) {
        if (medico != null) {
            this.medicoDao.salvar(medico);
        }
    }

    /**
     *
     * @param medico
     * @throws NegocioException
     */
    @Transactional
    public void delete(Medico medico) throws NegocioException {
        medicoDao.delete(findById(medico.getId()));
    }

    /**
     *
     * @param id
     * @return
     */
    public Medico findById(Long id) {
        return medicoDao.findById(id);
    }

    /**
     *
     * @return
     */
    public List<Medico> findAll() {
        return medicoDao.findAll();
    }

}
