package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Login;
import java.io.Serializable;
import javax.persistence.Query;

/**
 *
 * @author elisangela
 */
public class LoginDao extends DaoAbstrato<Login> implements Serializable {

    private static final long serialVersionUID = 1L;

    public LoginDao() {
        super(Login.class);
    }

    /**
     * Método que faz uma consulta por um usuário no banco de dados e retorna o
     * mesmo baseado no parametro do método
     *
     * @param usuario
     * @return
     */
    public Login porUsuario(String usuario) {
        Query createQuery;
        createQuery = getEntityManager().createQuery("FROM Login AS l WHERE l.usuario = :usuario", Login.class)
                .setParameter("usuario", usuario.toLowerCase());
        return (Login) createQuery.getSingleResult();
    }
}
