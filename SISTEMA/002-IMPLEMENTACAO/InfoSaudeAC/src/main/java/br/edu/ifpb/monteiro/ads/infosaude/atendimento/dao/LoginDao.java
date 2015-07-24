package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Login;
import java.io.Serializable;

/**
 *
 * @author elisangela
 */
public class LoginDao extends DaoAbstrato<Login> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public LoginDao() {
        super(Login.class);
    }
    
}
