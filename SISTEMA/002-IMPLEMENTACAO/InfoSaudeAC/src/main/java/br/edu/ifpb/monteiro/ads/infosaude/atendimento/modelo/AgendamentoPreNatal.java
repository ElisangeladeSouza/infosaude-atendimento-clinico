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
 * Entidade que representa ficha de marcação de pré-natal da gestante.
 * A enfermeira faz o agendamento das consultas de pré-natal, como forma de 
 * controle de datas e atendimentos para gestantes e para própria gestante.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Entity
@Data
public class AgendamentoPreNatal implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "agendamento_data")
    private Date data;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "agendamento_data_pre_natal")
    private Date dataProximoPreNatal;
    
    @Column(name = "agendamento_agente_saude", length = 150)
    private String agenteSaude;
    
    @Column(name = "agendamento_observacoes")
    private String observacoes;
    
    @OneToOne
    @JoinColumn(name = "gestante_pk")
    private Gestante gestante;
    
}
