package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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

/**
 *
 * @author cassio
 */
@Entity
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "consulta")
    @JoinColumn(name = "paciente_pk")
    private Paciente paciente;

    @Lob
    @Column(name = "consulta_observacoes", length = 500)
    private String observacoes;

    @Column(name = "consulta_prescricao", length = 255)
    private String prescricao;

    @Column(name = "consulta_diagnostico", length = 255)
    private String diagnostico;

    @Column(name = "consulta_procedimento", length = 255)
    private String procedimento;

    /*Ajustar como relacionamento*/
    @Column(name = "consulta_atendimento", length = 255)
    private String atendimento;

    /*Ajustar como relacionamento*/
    @Column(name = "consulta_requisicao_exame", length = 255)
    private transient List<String> requisicaoExame;

    @Column(name = "consulta_anamnese", length = 255)
    private String anamnese;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "consulta_data")
    private Date data;

    @Column(name = "consulta_exames")
    private String exames;

    @Column(name = "consulta_sintomas")
    private String sintomas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }

    public List<String> getRequisicaoExame() {
        return requisicaoExame;
    }

    public void setRequisicaoExame(List<String> requisicaoExame) {
        this.requisicaoExame = requisicaoExame;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getExames() {
        return exames;
    }

    public void setExames(String exames) {
        this.exames = exames;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
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

}
