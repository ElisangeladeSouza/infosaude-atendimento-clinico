package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.PacienteDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Paciente;
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
public class PacienteService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PacienteDao pacienteDao;

    public PacienteService() {
    }

    @Transactional
    public void save(Paciente paciente) {
        this.pacienteDao.salvar(paciente);
    }

    @Transactional
    public void delete(Paciente paciente) throws UBSException {
        pacienteDao.delete(findById(paciente.getId()));
    }

    public Paciente findById(Long id) {
        return pacienteDao.findById(id);
    }

    public List<Paciente> findAll() {
        return pacienteDao.findAll();
    }

}
