package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.ConsultaDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Consulta;
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
public class ConsultaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ConsultaDao consultaDao;

    public ConsultaService() {
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param consulta
     */
    @Transactional
    public void save(Consulta consulta) {
        if (consulta != null) {
            consulta.setData(new DateTimeUtilBean().getDateToday());
            this.consultaDao.salvar(consulta);
        }
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * @param consulta
     * @throws NegocioException
     */
    @Transactional
    public void delete(Consulta consulta) throws NegocioException {
        consultaDao.delete(findById(consulta.getId()));
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public Consulta findById(Long id) {
        return consultaDao.findById(id);
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    public List<Consulta> findAll() {
        return consultaDao.findAll();
    }

}
