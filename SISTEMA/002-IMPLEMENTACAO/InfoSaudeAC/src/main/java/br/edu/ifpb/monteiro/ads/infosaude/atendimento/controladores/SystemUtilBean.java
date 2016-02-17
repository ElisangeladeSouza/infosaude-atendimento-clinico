package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import java.io.Serializable;
import javax.enterprise.inject.Model;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * Classe utilitária que provê recursos que podem ser usados por todas as
 * páginas do sistema.
 *
 * @author cassio
 */
@Model
public class SystemUtilBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String text;

    /**
     * Este método é um pequeno utilitário para gerar um hash do tipo SHA-256 de
     * um texto qualquer, porém é mais usado em senhas.
     *
     * @param string
     */
    public void getHashText(String string) {
        Sha256Hash sha256Hash = new Sha256Hash(this.text);
        this.text = sha256Hash.toHex();
    }

}
