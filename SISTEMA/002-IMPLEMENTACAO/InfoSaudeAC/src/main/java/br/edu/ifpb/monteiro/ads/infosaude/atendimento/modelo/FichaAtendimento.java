package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Destino;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * Entidade que representa a Ficha de atendimento que é feita pelo recepcionista
 * da UBS. A ficha de atendimento é onde são registradas todas as atividades, 
 * procedimentos e notificações dos pacientes atendidos pelo estabelecimento 
 * de saúde em questão.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Data
public class FichaAtendimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ficha_atendimento_codigo")
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(name = "ficha_atendimento_destino", nullable = false)
    private Destino destino;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ficha_atendimento_data")
    private Date data;

    @OneToOne
    @JoinColumn(name = "paciente_pk")
    private Paciente paciente;

    @OneToOne(mappedBy = "fichaAtendimentoTriagem")
    @JoinColumn(name = "triagem_pk")
    private Triagem triagem;

    @OneToOne(mappedBy = "fichaAtendimento")
    @JoinColumn(name = "procedimento_pk")
    private Procedimento procedimento;

}
