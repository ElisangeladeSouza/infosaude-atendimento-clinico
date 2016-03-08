package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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
 * Entidade que representa o Procedimento a ser executado por algum profissional
 * de saúde da UBS. Alguns procedimentos clínicos e pequenos procedimentos 
 * cirúrgicos podem ser realizados nas UBS, exemplo: curativo, retirada de 
 * pontos, aferição de pressão arterial, etc. Ao extender Pessoa, passa a herdar
 * todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Data
public class Procedimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "procedimento_codigo", length = 20, nullable = false)
    private String codigo;

    @Lob
    @NotNull
    @Column(name = "procedimento_descricao", length = 500, nullable = false)
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "procedimento_data")
    private Date data;
    
    @Column(name="procedimento_cartao_sus_profissional", nullable = false, length = 20)
    private String cartaoSusProfissional;
    
    @Column(name = "procedimento_cnes", length = 15)
    private String cnes;

    @OneToOne
    @JoinColumn(name = "ficha_atendimento_pk")
    private FichaAtendimento fichaAtendimento;

    @OneToOne
    @JoinColumn(name = "triagem_pk")
    private Triagem triagem;

    @OneToOne(mappedBy = "procedimentoPaciente")
    @JoinColumn(name = "procedimento_pk", referencedColumnName = "id")
    private Paciente paciente;

}
