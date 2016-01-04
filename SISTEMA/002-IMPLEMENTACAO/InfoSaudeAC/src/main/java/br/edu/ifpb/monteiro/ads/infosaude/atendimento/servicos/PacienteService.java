package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.PacienteDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
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
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class PacienteService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PacienteDao pacienteDao;

    public PacienteService() {
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param paciente
     */
    @Transactional
    public void save(Paciente paciente) {
        if (paciente != null) {
            this.pacienteDao.salvar(paciente);
        }
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param paciente
     * @throws NegocioException
     */
    @Transactional
    public void delete(Paciente paciente) throws NegocioException {
        pacienteDao.delete(findById(paciente.getId()));
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public Paciente findById(Long id) {
        return pacienteDao.findById(id);
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    public List<Paciente> findAll() {
        return pacienteDao.findAll();
    }
}
