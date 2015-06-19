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
    private transient List<Exame> exames;

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
    public String getSolicitanteCnes() {
        return solicitanteCnes;
    }

    /**
     *
     * @param solicitanteCnes
     */
    public void setSolicitanteCnes(String solicitanteCnes) {
        this.solicitanteCnes = solicitanteCnes;
    }

    /**
     *
     * @return
     */
    public String getSolicitanteEndereco() {
        return solicitanteEndereco;
    }

    /**
     *
     * @param solicitanteEndereco
     */
    public void setSolicitanteEndereco(String solicitanteEndereco) {
        this.solicitanteEndereco = solicitanteEndereco;
    }

    /**
     *
     * @return
     */
    public String getSolicitanteCidade() {
        return solicitanteCidade;
    }

    /**
     *
     * @param solicitanteCidade
     */
    public void setSolicitanteCidade(String solicitanteCidade) {
        this.solicitanteCidade = solicitanteCidade;
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
    public List<Exame> getExames() {
        return exames;
    }

    /**
     *
     * @param exames
     */
    public void setExames(List<Exame> exames) {
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
