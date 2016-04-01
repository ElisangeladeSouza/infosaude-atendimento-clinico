package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
import lombok.Data;

/**
 * Entidade que representa a Consulta para o paciente que pode ser feita por um
 * Médico, Enfermeiro, Odontólogo ou Administrador da UBS. Ao extender Pessoa,
 * passa a herdar todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Data
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "consulta_codigo", length = 20)
    private String codigo;

    @Lob
    @Column(name = "consulta_observacoes", length = 500)
    private String observacoes;

    @NotNull
    @Lob
    @Column(name = "consulta_prescricao", length = 500)
    private String prescricao;

    @Lob
    @Column(name = "consulta_diagnostico", length = 500)
    private String diagnostico;

    @Lob
    @Column(name = "consulta_anamnese", length = 500)
    private String anamnese;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "consulta_data")
    private Date data;

    @Column(name = "consulta_sintomas")
    private String sintomas;

    @OneToOne
    @JoinColumn(name = "fichaatendimentofk_id", nullable = false)
    private FichaAtendimento fichaAtendimento;

    @OneToOne
    @JoinColumn(name = "triagem_pk")
    private Triagem triagem;

    @OneToOne
    @JoinColumn(name = "procedimento_pk")
    private Procedimento procedimento;
    
//    @Embedded
//    private RequisicaoExame requisicaoExame;

//    @OneToOne
//    @JoinColumn(name = "requisicao_exame_pk")
//    private RequisicaoExame requisicaoExame;

    public Consulta(){
//        this.requisicaoExame = new RequisicaoExame();
    }
    
}
