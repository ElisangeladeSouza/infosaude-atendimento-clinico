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

    @Column(name = "pessoa_cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "pessoa_cartao_sus", unique = true, nullable = false, length = 20)
    private String cartaoSus;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    @Override
    public int hashCode() {
        int hashOdontologo = 7;
        hashOdontologo = 29 * hashOdontologo + Objects.hashCode(this.cpf);
        hashOdontologo = 29 * hashOdontologo + Objects.hashCode(this.cartaoSus);
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
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.cartaoSus, other.cartaoSus)) {
            return false;
        }
        return Objects.equals(this.cro, other.cro);
    }
}
