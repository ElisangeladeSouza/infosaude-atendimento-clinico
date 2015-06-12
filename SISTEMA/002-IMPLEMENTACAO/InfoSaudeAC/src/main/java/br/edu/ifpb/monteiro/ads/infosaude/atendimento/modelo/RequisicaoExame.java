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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
public class RequisicaoExame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "requisicao_solicitante_cnes", length = 200)
    private String solicitanteCnes;

    @Column(name = "requisicao_solicitante_endereco", length = 200)
    private String solicitanteEndereco;

    @Column(name = "requisicao_solicitante_cidade", length = 100)
    private String solicitanteCidade;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "requisicao_data")
    private Date data;

    @OneToMany
    private List<Exame> exames;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final RequisicaoExame other = (RequisicaoExame) obj;
        return Objects.equals(this.id, other.id);
    }

}
