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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade que representa a Requisição de exame para o paciente que pode ser
 * solicitada durante uma consulta do médico ou Odontólogo da UBS. Ao extender
 * Pessoa, passa a herdar todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Table(name = "requisicao_exame")
public class RequisicaoExame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "requisicao_exame_codigo")
    private String codigo;

    @Column(name = "requisicao_solicitante_cnes", length = 200)
    private String solicitanteCnes;

    @Column(name = "requisicao_solicitante_endereco", length = 200)
    private String solicitanteEndereco;

    @Column(name = "requisicao_solicitante_cidade", length = 100)
    private String solicitanteCidade;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "requisicao_data")
    private Date data;

    private List<String> exames;

    public RequisicaoExame() {
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

    public String getSolicitanteCnes() {
        return solicitanteCnes;
    }

    public void setSolicitanteCnes(String solicitanteCnes) {
        this.solicitanteCnes = solicitanteCnes;
    }

    public String getSolicitanteEndereco() {
        return solicitanteEndereco;
    }

    public void setSolicitanteEndereco(String solicitanteEndereco) {
        this.solicitanteEndereco = solicitanteEndereco;
    }

    public String getSolicitanteCidade() {
        return solicitanteCidade;
    }

    public void setSolicitanteCidade(String solicitanteCidade) {
        this.solicitanteCidade = solicitanteCidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<String> getExames() {
        return exames;
    }

    public void setExames(List<String> exames) {
        this.exames = exames;
    }

    @Override
    public int hashCode() {
        int hashRequisicaoExame = 7;
        hashRequisicaoExame = 13 * hashRequisicaoExame + Objects.hashCode(this.id);
        return hashRequisicaoExame;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RequisicaoExame other = (RequisicaoExame) obj;
        return Objects.equals(this.id, other.id);
    }

}
