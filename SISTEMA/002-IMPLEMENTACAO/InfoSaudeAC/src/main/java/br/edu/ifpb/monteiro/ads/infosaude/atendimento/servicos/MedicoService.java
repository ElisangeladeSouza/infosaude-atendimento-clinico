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
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class MedicoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private MedicoDao medicoDao;

    public MedicoService() {
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
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
     * Método utilizado para remover um cadastro do banco de dados.
     * @param medico
     * @throws NegocioException
     */
    @Transactional
    public void delete(Medico medico) throws NegocioException {
        medicoDao.delete(findById(medico.getId()));
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public Medico findById(Long id) {
        return medicoDao.findById(id);
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    public List<Medico> findAll() {
        return medicoDao.findAll();
    }
}
