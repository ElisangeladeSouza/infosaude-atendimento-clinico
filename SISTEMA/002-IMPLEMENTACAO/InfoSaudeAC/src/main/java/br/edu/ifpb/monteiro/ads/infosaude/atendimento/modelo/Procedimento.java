package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cassio
 */
@Entity
public class Procedimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "procedimento_codigo", length = 20, nullable = false)
    private String codigo;

    @Lob
    @NotNull
    @Column(name = "procedimento_descricao", nullable = false)
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "procedimento_data")
    private Date data;

    @OneToOne
    @JoinColumn(name = "ficha_atendimento_pk")
    private FichaAtendimento fichaAtendimento;

    @OneToOne
    @JoinColumn(name = "triagem_pk")
    private Triagem triagem;

    @OneToOne(mappedBy = "procedimento")
    @JoinColumn(name = "procedimento_pk", referencedColumnName = "id")
    private Paciente paciente;

    public Procedimento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public FichaAtendimento getFichaAtendimento() {
        return fichaAtendimento;
    }

    public void setFichaAtendimento(FichaAtendimento fichaAtendimento) {
        this.fichaAtendimento = fichaAtendimento;
    }

    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hashProcedimento = 3;
        hashProcedimento = 83 * hashProcedimento + Objects.hashCode(this.id);
        return hashProcedimento;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Procedimento other = (Procedimento) obj;
        return Objects.equals(this.id, other.id);
    }

}
