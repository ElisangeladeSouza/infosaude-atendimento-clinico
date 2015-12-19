package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Entidade que representa o Administrador da UBS. Esse administrador é uma
 * espécie de gerente que poderá ter poderes administrativos sobre todas as
 * operações contidadas dentro do sistema. Apenas o Administrador pode realizar
 * algumas operações que nenhum outro profissional com acesso ao sistema pode
 * ter. Ao extender Pessoa, passa a herdar todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
public class Administrador extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pessoa_cpf_administrador", nullable = false, unique = true, length = 11)
    private String cpfAdministrador;

    @Column(name = "pessoa_cartao_sus", unique = true, nullable = false, length = 20)
    private String cartaoSusAdministrador;

    public Administrador() {
    }

    public String getCpfAdministrador() {
        return cpfAdministrador;
    }

    public void setCpfAdministrador(String cpfAdministrador) {
        this.cpfAdministrador = cpfAdministrador;
    }

    public String getCartaoSusAdministrador() {
        return cartaoSusAdministrador;
    }

    public void setCartaoSusAdministrador(String cartaoSusAdministrador) {
        this.cartaoSusAdministrador = cartaoSusAdministrador;
    }

    // hashCode e equals
    
    @Override
    public int hashCode() {
        int hashAdministrador = 7;
        hashAdministrador = 37 * hashAdministrador + Objects.hashCode(this.cpfAdministrador);
        hashAdministrador = 37 * hashAdministrador + Objects.hashCode(this.cartaoSusAdministrador);
        return hashAdministrador;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Administrador other = (Administrador) obj;
        if (!Objects.equals(this.cpfAdministrador, other.cpfAdministrador)) {
            return false;
        }
        return Objects.equals(this.cartaoSusAdministrador, other.cartaoSusAdministrador);
    }
}
