package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Date;
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
import lombok.Data;

/**
 * Entidade que representa a Triagem feita na UBS. A triagem é o primeiro
 * atendimento prestado por profissionais de saúde ao usuários com a finalidade
 * de selecionar e conduzir o paciente para especialidade e/ou procedimento
 * necessário. O profissional autorizado e responsável por esse procedimento é o
 * Técnico em Enfermagem.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Entity
@Data
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

}
