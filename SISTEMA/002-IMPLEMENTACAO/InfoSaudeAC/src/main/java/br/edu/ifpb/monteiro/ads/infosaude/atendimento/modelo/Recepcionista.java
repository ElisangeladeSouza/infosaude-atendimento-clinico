package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Entidade que representa o Recepcionista da UBS. É o primeiro profissional da
 * UBS que o paciente (usuário) do sistema de saúde tem contato. Responsável
 * pela acolhida e preenchimento dos dados preliminares do paciente. 
 * Ao extender Pessoa, passa a herdar todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
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

    // hashCode e equals
    
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
