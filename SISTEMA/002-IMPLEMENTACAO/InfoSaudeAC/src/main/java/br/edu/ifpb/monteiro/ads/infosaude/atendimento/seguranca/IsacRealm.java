package br.edu.ifpb.monteiro.ads.infosaude.atendimento.seguranca;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Permissao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Login;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Classe IsacRealm responsavel pela autenticacao e autorizacao. 
 * Qualquer usuario que efetuar login na aplicacao tera suas informacoes de 
 * autenticacao coletadas. Esta classe entao verificara os dados fornecidos e 
 * decidira se o usuario tem permissao para iniciar a sessao, tendo acesso
 * a recursos de acordo com a sua permissao e/ou funcao dentro do sistema.
 * 
 * @author elisangela
 */
public class IsacRealm extends AuthorizingRealm {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("InfoSaudePU");

    /**
     * Metodo responsavel pela autenticacao. Se os dados fornecidos sao validos
     * e associados a uma conta de usuario, o sistema fornece a autenticacao do
     * usuario.
     * @param token
     * @return
     * @throws AuthenticationException 
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SaltedAuthenticationInfo info = null;
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        String passwd = new String(upToken.getPassword());

        if (username == null) {
            throw new AccountException();
        }

        if (passwd == null || passwd.isEmpty()) {
            throw new UnknownAccountException();
        }

        Login login = null;

        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select login from Login Login "
                + "where login.usuario = ?1 ");
        query.setParameter(1, username);

        @SuppressWarnings("unchecked")
        List<Login> logins = query.getResultList();
        if (logins.size() == 1) {
            login = logins.get(0);
        }
        em.close();
        if (login != null) {
            info = new IsacSaltedAuthenticationInfo(login.getUsuario(), login.getSenha(), login.getSalt());
        }
        return info;
    }

    /**
     * Metodo que captura do banco de dados as permissoes. Se sim, verifica se 
     * o usuario tem permissao para acessar o recurso.
     * @param principal
     * @return 
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        EntityManager em = emf.createEntityManager();
        String username = (String) principal.getPrimaryPrincipal();
        Set<String> permissao = new HashSet<String>();
        SimpleAuthorizationInfo authorization = new SimpleAuthorizationInfo();

        Query query = em.createQuery("select lg from Login lg "
                + "where lg.login.usuario=?1");
        query.setParameter(1, username);

        Login loginUsuario = (Login) query.getResultList().get(0);
        System.out.println(loginUsuario.getPermissao()+ "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        if (loginUsuario.getPermissao() == Permissao.ADMIN) {
            permissao.add("ADMIM");
        } else if (loginUsuario.getPermissao() == Permissao.RECEPCIONISTA) {
            permissao.add("RECEPCIONISTA");
        } else if (loginUsuario.getPermissao() == Permissao.MEDICO) {
            permissao.add("MEDICO");
        } else if (loginUsuario.getPermissao() == Permissao.ODONTOLOGO) {
            permissao.add("ODONTOLOGO");
        } else if (loginUsuario.getPermissao() == Permissao.ENFERMEIRO) {
            permissao.add("ENFERMEIRO");
        } else if (loginUsuario.getPermissao() == Permissao.TEC_ENFERMAGEM) {
            permissao.add("TEC_ENFERMAGEM");
        }

        authorization.setRoles(permissao);
        
        Set<String> rol = authorization.getRoles();
        System.out.println(rol + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        if (permissao.isEmpty()) {
            return null;
        } else {
            return authorization;
        }

    }

}
