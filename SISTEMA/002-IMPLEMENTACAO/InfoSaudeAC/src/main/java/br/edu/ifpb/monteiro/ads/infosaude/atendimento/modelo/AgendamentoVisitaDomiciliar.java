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
import lombok.Data;

/**
 * Entidade que representa o agendamento de visitas domiciliares da equipe médica
 * a um paciente idoso, impossibilitado de se locomover ou pacientes de grupos
 * de riscos.
 * A enfermeira faz o agendamento das visitas, como forma de 
 * controle de datas e atendimentos para os pacientes.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Entity
@Data
public class AgendamentoVisitaDomiciliar implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "visita_domiciliar_data")
    private Date data;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "visita_domiciliar_data_visita")
    private Date dataVisita;
    
    @Column(name = "visita_domiciliar_agente_saude", length = 150)
    private String agenteSaude;
    
    @Column(name = "visita_domiciliar_enfermeiro", length = 150)
    private String enfermeiro;
    
    @Column(name = "visita_domiciliar_observacoes")
    private String observacoes;
    
    @OneToOne
    @JoinColumn(name = "paciente_pk", nullable = false)
    private Paciente paciente;
    
}
