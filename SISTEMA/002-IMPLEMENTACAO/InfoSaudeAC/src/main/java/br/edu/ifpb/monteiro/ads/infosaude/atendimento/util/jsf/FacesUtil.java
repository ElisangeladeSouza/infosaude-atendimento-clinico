package br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Classe com métodos utilitários para adicionar mensagens às telas, geralmente,
 * através dos ManagedBeans.
 *
 * @author cassio
 */
public class FacesUtil {

    /**
     * Método que adiciona uma mensagem com nível de severidade de
     * <b>INFORMAÇÃO/SUCESSO</b>
     *
     * @param mensagem
     */
    public static void mensagemSucesso(String mensagem) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    /**
     * Método que adiciona uma mensagem com nível de severidade de <b>AVISO</b>
     *
     * @param mensagem
     */
    public static void mensagemAviso(String mensagem) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, mensagem);
        FacesContext.getCurrentInstance().addMessage("warningInfo", facesMsg);
    }

    /**
     * Método que retorna uma mensagem com nível de severidade de <b>ERRO</b>
     *
     * @param mensagem
     */
    public static void mensagemErro(String mensagem) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     * Método que retorna uma mensagem com nível de severidade de <b>ERRO</b> e
     * também a causa da exceção
     *
     * @param ex
     * @param mensagemPadrao
     */
    public static void mensagemErro(Exception ex, String mensagemPadrao) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            mensagemErro(msg);
        } else {
            mensagemErro(mensagemPadrao);
        }
    }

}
