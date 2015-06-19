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
public class Medico extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pessoa_cpf_medico", nullable = false, unique = true, length = 11)
    private String cpfMedico;

    @Column(name = "pessoa_cartao_sus", unique = true, nullable = false, length = 20)
    private String cartaoSusMedico;

    @Column(name = "medico_crm", unique = true, length = 30)
    private String crm;

    public Medico() {
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getCpfMedico() {
        return cpfMedico;
    }

    public void setCpfMedico(String cpfMedico) {
        this.cpfMedico = cpfMedico;
    }

    public String getCartaoSusMedico() {
        return cartaoSusMedico;
    }

    public void setCartaoSusMedico(String cartaoSusMedico) {
        this.cartaoSusMedico = cartaoSusMedico;
    }

    @Override
    public int hashCode() {
        int hashMedico = 7;
        hashMedico = 67 * hashMedico + Objects.hashCode(this.cpfMedico);
        hashMedico = 67 * hashMedico + Objects.hashCode(this.cartaoSusMedico);
        return hashMedico;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.cpfMedico, other.cpfMedico)) {
            return false;
        }
        return Objects.equals(this.cartaoSusMedico, other.cartaoSusMedico);
    }
}
