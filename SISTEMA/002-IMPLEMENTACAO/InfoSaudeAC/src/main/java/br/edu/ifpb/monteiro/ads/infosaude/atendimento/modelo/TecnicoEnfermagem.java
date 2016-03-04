package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entidade que representa o Técnico em Enfermagem da UBS. Profissional que
 * dentre as suas atribuições tem como responsabilidade dar assitência básica na
 * realização de procedimentos dentro da UBS de acordo com o regulamento no
 * exercício de sua profissão. Ao extender Pessoa, passa a herdar todos os seus
 * atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class TecnicoEnfermagem extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pessoa_cpf", nullable = false, unique = true, length = 11)
    private String cpfTecnicoEnfermagem;

    @Column(name = "pessoa_cartao_sus", unique = true, nullable = false, length = 20)
    private String cartaoSusTecnicoEnfermagem;

    @Column(name = "tecnico_enfermagem_coren", unique = true, length = 30)
    private String corenTecnicoEnfermagem;

    @Embedded
    private Endereco endereco;
    
    public TecnicoEnfermagem() {
        endereco = new Endereco();
    }
    
}
