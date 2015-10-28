package br.edu.ifpb.monteiro.ads.infosaude.atendimento.seguranca;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Grupo;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Login;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.LoginService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi.CDIServiceLocator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author cassio
 */
public class SystemUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        LoginService loginService = CDIServiceLocator.getBean(LoginService.class);
        Login login = loginService.porUsuario(userName);
        UsuarioSistema systemUser = null;

        if (login != null) {
            systemUser = new UsuarioSistema(login, getGrupos(login));
        }

        return systemUser;
    }

    private Collection<? extends GrantedAuthority> getGrupos(Login login) {
        List<SimpleGrantedAuthority> grupos = new ArrayList<>();
        for (Grupo grupo : login.getGrupos()) {
            grupos.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));
        }
        return grupos;
    }

}
