package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.LoginDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Login;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author elisangela
 */
public class LoginService implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private LoginDao loginDao;

    public LoginService() {
    }
    
    @Transactional
    public void save(Login login) {
        if (login != null) {
            this.loginDao.salvar(login);
        }
    }
    
    @Transactional
    public void delete(Login login) throws UBSException {
        loginDao.delete(findById(login.getId()));
    }
    
    public Login findById(Long id) {
        return loginDao.findById(id);
    }
    
    public List<Login> findAll() {
        return loginDao.findAll();
    }

}