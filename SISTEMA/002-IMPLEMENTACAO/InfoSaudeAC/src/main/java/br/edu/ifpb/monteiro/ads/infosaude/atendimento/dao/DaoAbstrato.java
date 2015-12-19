package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.interfaces.Dao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Esta classe representa um DAO genérico e contém todos os métodos básicos para
 * efetuar um CRUD e métodos adicionais que podem ser usados por qualquer
 * entidade do sistema.
 *
 * @author cassio <cassio@cassioliveira.com.br>
 * @param <T>
 */
public abstract class DaoAbstrato<T> implements Dao<T>, Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(DaoAbstrato.class);

    @Inject
    private transient EntityManager entityManager;

    private Class<T> entity;

    public DaoAbstrato() {
    }

    /**
     * Construtor da classe que captura a entidade que chamar esta classe.
     *
     * @param entityClass
     */
    public DaoAbstrato(Class<T> entityClass) {
        this.entity = entityClass;
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param entity 
     */
    @Override
    public void salvar(T entity) {
        entityManager.merge(entity);
    }
    
    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param entity 
     */
    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return 
     */
    @Override
    public List<T> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entity));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return 
     */
    @Override
    public T findById(Long id) {
        return entityManager.find(entity, id);
    }

    /**
     * Faz uma consulta no banco de dados baseado em um valor passado como
     * parâmetro e retorna o resultado da consulta.
     * 
     * @param campo
     * @param valor
     * @return 
     */
    @Override
    public T buscarPorCampo(String campo, Object valor) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> createQuery = criteriaBuilder.createQuery(entity);
            Root<T> root = createQuery.from(entity);
            Predicate predicate = criteriaBuilder.conjunction();
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.<T>get(campo), valor));
            createQuery.where(predicate);

            return entityManager.createQuery(createQuery).getSingleResult();

        } catch (NoResultException ex) {
            LOGGER.info("Infomação não encontrada" + ex.getMessage());
        }
        return null;
    }

    /**
     * Recebe o valor passado pelo método buscarPorCampo() para determinar a
     * duplicidade do cadastro e lança uma exceção informando ao usuário qual
     * campo não pode ser inserido por já existir no banco de dados.
     *
     * 
     * @param campo
     * @param valor
     * @param id
     * @param entidade
     * @return
     * @throws NegocioException 
     */
    @Override
    public boolean checaCampoDuplicado(String campo, Object valor, Long id, T entidade) throws NegocioException {
        try {
            if (id == null) {
                entidade = buscarPorCampo(campo, valor);
                if (entidade != null) {
                    throw new NegocioException("Já existe um cadastro com esse(a) " + campo.toUpperCase());
                }
            }
        } catch (NoResultException ex) {
            LOGGER.info("Infomação não encontrada" + ex.getMessage());
        }
        return true;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
