package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Classe que representa um modelo de uma entidade a ser persistida no banco,
 * com todos os atributos relacionados.
 *
 * @author cassio
 */
@Entity
public class Odontologo extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pessoa_cpfOdontologo", nullable = false, unique = true, length = 11)
    private String cpfOdontologo;

    @Column(name = "pessoa_cartao_sus", unique = true, nullable = false, length = 20)
    private String cartaoSusOdontologo;

    @Column(name = "odontologo_cro", unique = true, length = 30)
    private String cro;

    public Odontologo() {
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getCpfOdontologo() {
        return cpfOdontologo;
    }

    public void setCpfOdontologo(String cpfOdontologo) {
        this.cpfOdontologo = cpfOdontologo;
    }

    public String getCartaoSusOdontologo() {
        return cartaoSusOdontologo;
    }

    public void setCartaoSusOdontologo(String cartaoSusOdontologo) {
        this.cartaoSusOdontologo = cartaoSusOdontologo;
    }

    @Override
    public int hashCode() {
        int hashOdontologo = 7;
        hashOdontologo = 29 * hashOdontologo + Objects.hashCode(this.cpfOdontologo);
        hashOdontologo = 29 * hashOdontologo + Objects.hashCode(this.cartaoSusOdontologo);
        hashOdontologo = 29 * hashOdontologo + Objects.hashCode(this.cro);
        return hashOdontologo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Odontologo other = (Odontologo) obj;
        if (!Objects.equals(this.cpfOdontologo, other.cpfOdontologo)) {
            return false;
        }
        if (!Objects.equals(this.cartaoSusOdontologo, other.cartaoSusOdontologo)) {
            return false;
        }
        return Objects.equals(this.cro, other.cro);
    }
}
