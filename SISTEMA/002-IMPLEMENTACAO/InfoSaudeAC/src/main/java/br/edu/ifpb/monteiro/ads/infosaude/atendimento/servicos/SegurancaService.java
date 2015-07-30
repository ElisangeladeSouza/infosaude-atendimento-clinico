package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.LoginDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Login;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 *
 * @author elisangela
 */
public class SegurancaService {

    @Inject
    private LoginDao loginDao;

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("InfoSaudePU");

    private void generatePassword(Login login, String plainTextPassword) {
        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
        Object salt = rng.nextBytes();

        // Now hash the plain-text password with the random salt and multiple
        // iterations and then Base64-encode the value (requires less space than Hex):
        String hashedPasswordBase64 = new Sha256Hash(plainTextPassword, salt, 1024).toBase64();

        login.setSenha(hashedPasswordBase64);
        login.setSalt(salt.toString());
    }

    public void registrar(Login login, String plainTextPassword) {
        generatePassword(login, plainTextPassword);
        loginDao.salvar(login);
    }

    public boolean isAuthorized(String roleIdentifier) {
        org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.hasRole(roleIdentifier)) {
            System.out.println("##########################################################");
            return true;
        }
        return false;
    }

    public Login login(String username, String password, Boolean rememberMe) {
        // get the currently executing user:
        org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            //collect user principals and credentials in a gui specific manner
            //such as username/password html form, X509 certificate, OpenID, etc.
            //We'll use the username/password example here since it is the most common.
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            //this is all you have to do to support 'remember me' (no config - built in!):
            token.setRememberMe(rememberMe);
            currentUser.login(token);

            Login login = getCurrentUser();
            return login;
        }
        return null;
    }

    public Login getLogin(String username) {
        List<Login> listaLogin = loginDao.query("select login from Login login "
                + "where login.usuario = ?1",
                username);
        Login login = null;
        if (listaLogin.size() == 1) {
            login = listaLogin.get(0);
        }
        return login;
    }

    public Login getCurrentUser() {
        Login aux = null;
        org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            String login = (String) currentUser.getPrincipal();
            List<Login> listaLogin = loginDao.query("select login from Login login "
                    + "where login.usuario = ?1", login);
            if (listaLogin.size() == 1) {
                aux = listaLogin.get(0);
            }
        }
        return aux;
    }
    
    public void logout() {
        org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
    }

}
