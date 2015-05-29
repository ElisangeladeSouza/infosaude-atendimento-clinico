package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Classe que representa um modelo de uma entidade a ser persistida no banco,
 * com todos os atributos relacionados.
 *
 * @author cassio
 */
@Entity
public class Enfermeiro extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pessoa_cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "pessoa_cartao_sus", unique = true, nullable = false, length = 20)
    private String cartaoSus;

    @Column(name = "enfermeiro_coren", unique = true, length = 30)
    private String coren;

    public Enfermeiro() {
    }

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
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

}
