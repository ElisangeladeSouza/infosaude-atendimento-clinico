package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author elisangela
 */
@Entity
public class Login extends Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name= "usuario", nullable = false, length = 25)
    private String usuario;
    
    @Column(name = "senha", nullable = false, length = 40)
    private String senha;
    
    public Login() {
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode(); 
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Login other = (Login) obj;
        return Objects.equals(this.usuario, other.usuario);
    }

}
