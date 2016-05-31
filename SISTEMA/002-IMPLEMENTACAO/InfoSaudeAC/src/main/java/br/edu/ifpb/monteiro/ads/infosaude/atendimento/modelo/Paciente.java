package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entidade que representa o Paciente da UBS. Usuário da UBS, não possui acesso
 * as funcionalidades nem possui papel ativo dentro sistema. Ao extender Pessoa,
 * passa a herdar todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Paciente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "pessoa_cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "pessoa_cartao_sus", unique = true, nullable = false, length = 20)
    private String cartaoSus;

    @DecimalMin(value = "0", message = "O peso deve ser um valor maior que 0(zero)")
    @Column(name = "paciente_peso", precision = 10, scale = 2)
    private Double peso;

    @DecimalMin(value = "0", message = "A altura deve ser um valor maior que 0(zero)")
    @Column(name = "paciente_altura", precision = 10, scale = 2)
    private Double altura;

    @Column(name = "paciente_nome_mae", length = 100)
    private String nomeDaMae;

    @OneToOne
    @JoinColumn(name = "ficha_atendimento_pk")
    private FichaAtendimento fichaAtendimentoPaciente;

    @OneToOne
    @JoinColumn(name = "procedimento_pk", referencedColumnName = "id")
    private Procedimento procedimentoPaciente;

    @OneToOne
    @JoinColumn(name = "triagem_pk", referencedColumnName = "id")
    private Triagem triagemPaciente;
    
    @OneToOne
    @JoinColumn(name = "agendamento_visita_domiciliar_pk")
    private AgendamentoVisitaDomiciliar agendamentoVisitaDomiciliar;
}
