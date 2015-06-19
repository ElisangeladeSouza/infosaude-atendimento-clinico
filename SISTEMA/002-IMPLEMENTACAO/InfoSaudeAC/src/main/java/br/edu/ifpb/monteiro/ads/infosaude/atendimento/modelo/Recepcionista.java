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
public class Recepcionista extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pessoa_cpfRecepcionista", nullable = false, unique = true, length = 11)
    private String cpfRecepcionista;

    @Column(name = "pessoa_cartao_sus", unique = true, nullable = false, length = 20)
    private String cartaoSusRecepcionista;

    public Recepcionista() {
    }

    public String getCpfRecepcionista() {
        return cpfRecepcionista;
    }

    public void setCpfRecepcionista(String cpfRecepcionista) {
        this.cpfRecepcionista = cpfRecepcionista;
    }

    public String getCartaoSusRecepcionista() {
        return cartaoSusRecepcionista;
    }

    public void setCartaoSusRecepcionista(String cartaoSusRecepcionista) {
        this.cartaoSusRecepcionista = cartaoSusRecepcionista;
    }

    @Override
    public int hashCode() {
        int hashRecepcionista = 5;
        hashRecepcionista = 59 * hashRecepcionista + Objects.hashCode(this.cpfRecepcionista);
        hashRecepcionista = 59 * hashRecepcionista + Objects.hashCode(this.cartaoSusRecepcionista);
        return hashRecepcionista;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recepcionista other = (Recepcionista) obj;
        if (!Objects.equals(this.cpfRecepcionista, other.cpfRecepcionista)) {
            return false;
        }
        return Objects.equals(this.cartaoSusRecepcionista, other.cartaoSusRecepcionista);
    }
}
