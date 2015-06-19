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
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "consulta_observacoes", length = 500)
    private String observacoes;

    @NotNull
    @Column(name = "consulta_prescricao", length = 255)
    private String prescricao;

    @Column(name = "consulta_diagnostico", length = 255)
    private String diagnostico;

    @Column(name = "consulta_anamnese", length = 255)
    private String anamnese;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "consulta_data")
    private Date data;

    @Column(name = "consulta_exames")
    private String exames;

    @Column(name = "consulta_sintomas")
    private String sintomas;

    @OneToOne(mappedBy = "consultaPaciente")
    @JoinColumn(name = "paciente_pk", referencedColumnName = "id")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "ficha_atendimento_pk")
    private FichaAtendimento fichaAtendimento;

    @OneToOne
    @JoinColumn(name = "triagem_pk")
    private Triagem triagem;

    @OneToOne
    @JoinColumn(name = "procedimento_pk")
    private Procedimento procedimento;

    @OneToOne
    @JoinColumn(name = "requisicao_exame_pk")
    private RequisicaoExame requisicaoExame;

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
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     *
     * @param paciente
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     *
     * @return
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     *
     * @param observacoes
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    /**
     *
     * @return
     */
    public String getPrescricao() {
        return prescricao;
    }

    /**
     *
     * @param prescricao
     */
    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    /**
     *
     * @return
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     *
     * @param diagnostico
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     *
     * @return
     */
    public String getSintomas() {
        return sintomas;
    }

    /**
     *
     * @param sintomas
     */
    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
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
    public RequisicaoExame getRequisicaoExame() {
        return requisicaoExame;
    }

    /**
     *
     * @param requisicaoExame
     */
    public void setRequisicaoExame(RequisicaoExame requisicaoExame) {
        this.requisicaoExame = requisicaoExame;
    }

    /**
     *
     * @return
     */
    public String getAnamnese() {
        return anamnese;
    }

    /**
     *
     * @param anamnese
     */
    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    /**
     *
     * @return
     */
    public String getExames() {
        return exames;
    }

    /**
     *
     * @param exames
     */
    public void setExames(String exames) {
        this.exames = exames;
    }

    /**
     *
     * @return
     */
    public FichaAtendimento getFichaAtendimento() {
        return fichaAtendimento;
    }

    /**
     *
     * @param fichaAtendimento
     */
    public void setFichaAtendimento(FichaAtendimento fichaAtendimento) {
        this.fichaAtendimento = fichaAtendimento;
    }

    /**
     *
     * @return
     */
    public Triagem getTriagem() {
        return triagem;
    }

    /**
     *
     * @param triagem
     */
    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }

    /**
     *
     * @return
     */
    public Procedimento getProcedimento() {
        return procedimento;
    }

    /**
     *
     * @param procedimento
     */
    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    @Override
    public int hashCode() {
        int hashConsulta = 3;
        hashConsulta = 11 * hashConsulta + Objects.hashCode(this.id);
        return hashConsulta;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return paciente.getNome();
    }

}
