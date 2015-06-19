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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author elisangela
 */
@Entity
public class Triagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "triagem_codigo", length = 20, nullable = false)
    private String codigo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "triagem_data")
    private Date data;

    @OneToOne
    @JoinColumn(name = "ficha_atendimento_pk")
    private FichaAtendimento fichaAtendimentoTriagem;

    @OneToOne
    @JoinColumn(name = "consulta_pk")
    private Consulta consultaTriagem;

    @OneToOne
    @JoinColumn(name = "procedimento_pk")
    private Procedimento procedimentoTriagem;

    @OneToOne(mappedBy = "triagemPaciente")
    @JoinColumn(name = "triagem_pk", referencedColumnName = "id")
    private Paciente pacienteTriagem;

    /**
     *
     */
    public Triagem() {
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return
     */
    public Date getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public FichaAtendimento getFichaAtendimentoTriagem() {
        return fichaAtendimentoTriagem;
    }

    /**
     *
     * @param fichaAtendimentoTriagem
     */
    public void setFichaAtendimentoTriagem(FichaAtendimento fichaAtendimentoTriagem) {
        this.fichaAtendimentoTriagem = fichaAtendimentoTriagem;
    }

    /**
     *
     * @return
     */
    public Consulta getConsultaTriagem() {
        return consultaTriagem;
    }

    /**
     *
     * @param consultaTriagem
     */
    public void setConsultaTriagem(Consulta consultaTriagem) {
        this.consultaTriagem = consultaTriagem;
    }

    /**
     *
     * @return
     */
    public Procedimento getProcedimento() {
        return procedimentoTriagem;
    }

    /**
     *
     * @param procedimento
     */
    public void setProcedimento(Procedimento procedimento) {
        this.procedimentoTriagem = procedimento;
    }

    /**
     *
     * @return
     */
    public Paciente getPaciente() {
        return pacienteTriagem;
    }

    /**
     *
     * @param paciente
     */
    public void setPaciente(Paciente paciente) {
        this.pacienteTriagem = paciente;
    }

    @Override
    public int hashCode() {
        int hashTriagem = 3;
        hashTriagem = 53 * hashTriagem + Objects.hashCode(this.id);
        return hashTriagem;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Triagem other = (Triagem) obj;
        return Objects.equals(this.id, other.id);
    }
}
