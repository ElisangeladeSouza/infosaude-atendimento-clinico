package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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

    @Lob
    @Column(name = "consulta_observacoes", length = 500)
    private String observacoes;

    @Column(name = "consulta_prescricao", length = 255)
    private String prescricao;

    @Column(name = "consulta_requisicao_exames", length = 255)
    private String requisicaoExames;

    @Column(name = "consulta_diagnostico", length = 255)
    private String diagnostico;

    @Column(name = "consulta_sintomas", length = 255)
    private String sintoma;
    
    @Column(name = "exame_cid", length = 50)
    private String cid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "consulta_data_consulta")
    private Date data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRequisicaoExames() {
        return requisicaoExames;
    }

    public void setRequisicaoExames(String requisicaoExames) {
        this.requisicaoExames = requisicaoExames;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }
    
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


}
