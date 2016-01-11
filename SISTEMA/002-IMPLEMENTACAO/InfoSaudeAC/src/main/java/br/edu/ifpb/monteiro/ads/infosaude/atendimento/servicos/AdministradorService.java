package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.AdministradorDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Administrador;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.AdministradorServiceIF;
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
public class AdministradorService implements AdministradorServiceIF, Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AdministradorDao administradorDAO;

    public AdministradorService() {
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param administrador
     */
    @Transactional
    @Override
    public void save(Administrador administrador) {
        if (administrador != null) {
            this.administradorDAO.salvar(administrador);
        }
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param administrador
     * @throws NegocioException
     */
    @Transactional
    @Override
    public void delete(Administrador administrador) throws NegocioException {
        administradorDAO.delete(findById(administrador.getId()));
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    @Override
    public List<Administrador> findAll() {
        return administradorDAO.findAll();
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    @Override
    public Administrador findById(Long id) {
        return administradorDAO.findById(id);
    }
}
