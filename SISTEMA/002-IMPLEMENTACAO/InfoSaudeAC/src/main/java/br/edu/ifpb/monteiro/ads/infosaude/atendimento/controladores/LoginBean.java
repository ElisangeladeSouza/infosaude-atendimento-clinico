package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cassio
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

//    private String userName;
    @Inject
    private FacesContext facesContext;

    @Inject
    private HttpServletRequest request;

    @Inject
    private HttpServletResponse response;

    /**
     * Método que é chamado antes da pagína ser renderizada e verifica se há um
     * parametro "invalid" na URL, indicando que o usuário digitou os dados
     * inválidos para o login
     */
    public void preRender() {
        if ("true".equals(request.getParameter("invalid"))) {
            FacesUtil.mensagemErro("Usuário ou senha inválidos!");
        }
    }

    public LoginBean() {
//        this.userName = SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public void login() throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
        dispatcher.forward(request, response);

        facesContext.responseComplete(); //Interrompe o ciclo de vida do JSF
    }

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
}
