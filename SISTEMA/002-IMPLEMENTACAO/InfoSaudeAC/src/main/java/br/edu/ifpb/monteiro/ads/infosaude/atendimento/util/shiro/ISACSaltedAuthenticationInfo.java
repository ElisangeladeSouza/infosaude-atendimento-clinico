package br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.shiro;

import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.bouncycastle.util.encoders.Base64;

/**
 * “salt” é uma string complexa utilizada para concatenar toda e qualquer senha antes de encriptá-la.
 * Gera uma string aleatória, utilizando-a como salt na hora de encriptar a senha do usuário e salva ambas no banco de dados 
 * (a senha e a string utilizada como salt).
 *	
 * Artigo completo: http://www.linhadecodigo.com.br/artigo/3523/encriptando-senhas-de-forma-segura.aspx#ixzz3uJC1aGuY
 *
 * @author elisangelas <elysangeladesouza@gmail.com>
 */
class ISACSaltedAuthenticationInfo implements SaltedAuthenticationInfo {

    private static final long serialVersionUID = 1L;

    private final String userName;
    private final String password;
    private final String salt;

    public ISACSaltedAuthenticationInfo(String userName, String password, String salt) {
        this.userName = userName;
        this.password = password;
        this.salt = salt;
    }

    @Override
    public ByteSource getCredentialsSalt() {
        return  new SimpleByteSource(Base64.decode(salt)); 
    }

    @Override
    public PrincipalCollection getPrincipals() {
        PrincipalCollection coll = new SimplePrincipalCollection(userName, userName);
        return coll;
    }

    @Override
    public Object getCredentials() {
        return password;
    }
}
