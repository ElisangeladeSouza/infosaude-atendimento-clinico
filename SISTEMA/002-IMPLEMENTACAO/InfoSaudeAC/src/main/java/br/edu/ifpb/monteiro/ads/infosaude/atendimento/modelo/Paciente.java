package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 *
 * @author elisangela
 */
@Entity
public class Paciente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotNull(message = "Um CPF deve ser informado")
    @Column(name = "pessoa_cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @NotNull(message = "O cartão do SUS deve ser informado")
    @Column(name = "pessoa_cartao_sus", unique = true, nullable = false, length = 20)
    private String cartaoSus;

    @DecimalMin(value = "0", message = "O peso deve ser um valor maior que 0(zero)")
    @Column(name = "paciente_peso", precision = 10, scale = 2)
    private Double peso;

    @DecimalMin(value = "0", message = "A altura deve ser um valor maior que 0(zero)")
    @Column(name = "paciente_altura", precision = 10, scale = 2)
    private Double altura;

    @Column(name = "paciente_nome_mae", length = 100)
    private String nomeDaMae;

    @OneToOne
    @JoinColumn(name = "ficha_atendimento_pk")
    private FichaAtendimento fichaAtendimento;

    @OneToOne
    @JoinColumn(name = "consulta_pk")
    private Consulta consulta;

//    @Column(name = "paciente_ficha_atendimento")
    public Paciente() {
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
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

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public FichaAtendimento getFichaAtendimento() {
        return fichaAtendimento;
    }

    public void setFichaAtendimento(FichaAtendimento fichaAtendimento) {
        this.fichaAtendimento = fichaAtendimento;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
