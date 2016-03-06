package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entidade que representa o Médico da UBS. Ao extender Pessoa, passa a herdar
 * todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Medico extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pessoa_cpf_medico", nullable = false, unique = true, length = 11)
    private String cpfMedico;

    @Column(name = "pessoa_cartao_sus", unique = true, nullable = false, length = 20)
    private String cartaoSusMedico;

    @Column(name = "medico_crm", unique = true, length = 30)
    private String crm;

//    @Embedded
//    private Endereco endereco;
//    public Medico() {
//        endereco = new Endereco();
//    }
}
