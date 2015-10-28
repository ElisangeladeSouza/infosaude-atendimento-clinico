package br.edu.ifpb.monteiro.ads.infosaude.atendimento.seguranca;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Login;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author cassio
 */
public class UsuarioSistema extends User {

    private final Login login;

    public UsuarioSistema(Login login, Collection<? extends GrantedAuthority> authorities) {
        super(login.getUsuario(), login.getSenha(), authorities);
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }
    
    

}
