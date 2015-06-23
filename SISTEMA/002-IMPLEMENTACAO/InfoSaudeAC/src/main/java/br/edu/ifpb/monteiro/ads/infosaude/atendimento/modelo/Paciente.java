package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;

/**
 * Entidade que representa o Paciente da UBS. Ao extender Pessoa, passa a herdar
 * todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
public class Paciente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
//    @NotNull(message = "Um CPF deve ser informado")
    @Column(name = "pessoa_cpf", nullable = false, unique = true, length = 11)
    private String cpf;

//    @NotNull(message = "O cartão do SUS deve ser informado")
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
    private FichaAtendimento fichaAtendimentoPaciente;

    @OneToOne
    @JoinColumn(name = "consulta_pk", referencedColumnName = "id")
    private Consulta consultaPaciente;

    @OneToOne
    @JoinColumn(name = "procedimento_pk", referencedColumnName = "id")
    private Procedimento procedimentoPaciente;

    @OneToOne
    @JoinColumn(name = "triagem_pk", referencedColumnName = "id")
    private Triagem triagemPaciente;

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

    public FichaAtendimento getFichaAtendimentoPaciente() {
        return fichaAtendimentoPaciente;
    }

    public void setFichaAtendimentoPaciente(FichaAtendimento fichaAtendimentoPaciente) {
        this.fichaAtendimentoPaciente = fichaAtendimentoPaciente;
    }

    public Consulta getConsultaPaciente() {
        return consultaPaciente;
    }

    public void setConsultaPaciente(Consulta consultaPaciente) {
        this.consultaPaciente = consultaPaciente;
    }

    public Procedimento getProcedimentoPaciente() {
        return procedimentoPaciente;
    }

    public void setProcedimentoPaciente(Procedimento procedimentoPaciente) {
        this.procedimentoPaciente = procedimentoPaciente;
    }

    public Triagem getTriagemPaciente() {
        return triagemPaciente;
    }

    public void setTriagemPaciente(Triagem triagemPaciente) {
        this.triagemPaciente = triagemPaciente;
    }

    @Override
    public int hashCode() {
        int hashPaciente = 7;
        hashPaciente = 73 * hashPaciente + Objects.hashCode(this.cpf);
        hashPaciente = 73 * hashPaciente + Objects.hashCode(this.cartaoSus);
        return hashPaciente;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return Objects.equals(this.cartaoSus, other.cartaoSus);
    }

}
