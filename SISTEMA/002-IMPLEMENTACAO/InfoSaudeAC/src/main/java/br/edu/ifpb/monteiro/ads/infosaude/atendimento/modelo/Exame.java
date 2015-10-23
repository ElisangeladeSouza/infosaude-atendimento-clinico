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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade que representa um Exame a ser executado por algum profissional de
 * saúde da UBS ou encaminhado pelos mesmos para ser realizado fora da UBS. Ao
 * extender Pessoa, passa a herdar todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exame_descricao", length = 200, nullable = false)
    private String descricao;

    @Column(name = "exame_detalhes", length = 200)
    private String detalhes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "exame_data")
    private Date data;
    
    @ManyToMany(targetEntity = br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame.class)
    @JoinTable(name="exame_requisicaoExame", joinColumns = {@JoinColumn(name = "exame_id", referencedColumnName = "id")}, 
            inverseJoinColumns = {@JoinColumn(name = "requisiscaoExame_id", referencedColumnName = "id")})
    private List<RequisicaoExame> requisicaoExames;

    public Exame() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public List<RequisicaoExame> getRequisicaoExames() {
        return requisicaoExames;
    }

    public void setRequisicaoExames(List<RequisicaoExame> requisicaoExames) {
        this.requisicaoExames = requisicaoExames;
    }

    @Override
    public int hashCode() {
        int hashExame = 5;
        hashExame = 37 * hashExame + Objects.hashCode(this.id);
        return hashExame;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exame other = (Exame) obj;
        return Objects.equals(this.id, other.id);
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}
