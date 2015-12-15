package br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.shiro;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Conta;
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
 * A classe ISACRealm é um realm de segurança personalizado que pode acessar 
 * entidades de segurança. Ele usa consultas SQL configuráveis para ler nomes de usário,
 * senhas, permissões e funções de banco de dados para determinar as operações
 * de autenticação e autorização.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class ISACRealm extends AuthorizingRealm {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("InfoSaudePU");

     /**
     * Método que lê as informações de autenticação de conta de banco de dados e
     * converte-os em informação de autenticação objeto. Ele retorna nulo se
     * nenhuma informação de conta for encontrado. A classe pai
     * AuthenticatingRealm compara informação de autenticação objeto com os
     * dados fornecidos pelo usuário original.
     *
     * @param token
     * @return
     * @throws AuthenticationException <elysangeladesouza@gmail.com>
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SaltedAuthenticationInfo info = null;
        UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
        String username = passwordToken.getUsername();
        String password = new String(passwordToken.getPassword());
        
        if (username == null) {
            throw new AccountException();
        }
        
        if (password == null || password.isEmpty()) {
            throw new UnknownAccountException();
        }
        
        Conta conta = null;
        
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT conta FROM Conta conta WHERE conta.userName = ?1");
        query.setParameter(1, username);
        
        List<Conta> contas = query.getResultList();
        if(contas.size() == 1) {
            conta = contas.get(0);
        }
        em.close();
        if(conta != null) {
            info = new ISACSaltedAuthenticationInfo(conta.getUserName(), conta.getPassword(), conta.getSalt());
        }
        return info;
    }
    
    /**
     * O método AuthorizationInfo verifica os dados de autorização (papéis, permissões) 
     * armazenados de um subject utilizados durante a autorização (controle de acesso).
     * Este método provém a autorização dos usuários.
     * 
     * @param principals
     * @return 
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        EntityManager em = emf.createEntityManager();
        String username = (String) principals.getPrimaryPrincipal();
        Set<String> permissoes = new HashSet<String>();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        
        Query query = em.createQuery("SELECT grupo FROM Grupo grupo WHERE grupo.nome = ?1");
        query.setParameter(1, username);
        return null;
    }
    
}
