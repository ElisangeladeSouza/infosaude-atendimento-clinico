package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.RequisicaoExameDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.RequisicaoExame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.RequisicaoExameServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Classe de serviço que faz chamadas aos métodos de persistência e pode conter
 * lógica de negócio e pode fazer chamadas a outras partes do sistema, caso
 * necessite.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class RequisicaoExameService implements RequisicaoExameServiceIF, Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(RequisicaoExameService.class);

    @Inject
    private RequisicaoExameDao requisicaoExameDao;

    public RequisicaoExameService() {
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param requisicaoExame
     */
    @Transactional
    @Override
    public void save(RequisicaoExame requisicaoExame) {
        requisicaoExameDao.salvar(requisicaoExame);
//        if (requisicaoExame.getExames() == null) {
//            throw new NegocioException("Todos os dados devem ser inseridos corretamente");
//        } else{
//            requisicaoExame.setData(new DateTimeUtilBean().getDateToday());
//        }
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param requisicaoExame
     * @throws NegocioException
     */
    @Transactional
    @Override
    public void delete(RequisicaoExame requisicaoExame) throws NegocioException {
        requisicaoExameDao.delete(findById(requisicaoExame.getId()));
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    @Override
    public List<RequisicaoExame> findAll() {
        return requisicaoExameDao.findAll();
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public RequisicaoExame findById(Long id) {
        return requisicaoExameDao.findById(id);
    }

    /**
     * Recebe o valor passado pelo método buscarPorCampo() para determinar a
     * duplicidade do cadastro e lança uma exceção informando ao usuário qual
     * campo não pode ser inserido por já existir no banco de dados.
     * 
     * @param campo
     * @param valor
     * @param id
     * @return
     * @throws NegocioException 
     */
    @Override
    public boolean verificaCampoUnique(String campo, Object valor, Long id) throws NegocioException {

        try {
            RequisicaoExame requisicaoExame;

            if (id == null) {
                requisicaoExame = requisicaoExameDao.buscarPorCampo(campo, valor);
                if (requisicaoExame != null) {
                    throw new NegocioException("Já existe um cadastro com esse(a) " + campo.toUpperCase());
                }
            } else {
                requisicaoExame = requisicaoExameDao.buscarPorCampo(campo, valor);
                if (requisicaoExame != null && id.equals(requisicaoExame.getId())) {
                    throw new NegocioException("Já existe um cadastro com esse(a) " + campo.toUpperCase());
                }
                return true;
            }
        } catch (NoResultException ex) {
            LOGGER.info("Infomação não encontrada");
        }
        return true;
    }
}
