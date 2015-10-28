package br.edu.ifpb.monteiro.ads.infosaude.atendimento.seguranca;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Bean CDI que disponibiliza o usuário logado no sistema e pode ser usado em
 * qualquer lugar da camada de apresentação.
 *
 * @author cassio
 */
@Model
public class Seguranca {

    /**
     * Captura o usuário já logado e retorna o nome do mesmo para ser exibido na
     * página
     *
     * @return
     */
    public String getNomeUsuario() {
        String nome = null;

        UsuarioSistema usuarioLogado = getUsuarioLogado();
        if (usuarioLogado != null) {
            nome = usuarioLogado.getLogin().getUsuario();
        }

        return nome;
    }

    /**
     * Verifica o usuário que está logado no sistema
     *
     * @return
     */
    private UsuarioSistema getUsuarioLogado() {

        UsuarioSistema usuarioSistema = null;

        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();

        if (authenticationToken != null && authenticationToken.getPrincipal() != null) {
            usuarioSistema = (UsuarioSistema) authenticationToken.getPrincipal();
        }

        return usuarioSistema;
    }

}
