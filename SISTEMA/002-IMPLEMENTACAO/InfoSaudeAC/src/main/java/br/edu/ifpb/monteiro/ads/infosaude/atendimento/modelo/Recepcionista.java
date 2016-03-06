package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entidade que representa o Recepcionista da UBS. É o primeiro profissional da
 * UBS que o paciente (usuário) do sistema de saúde tem contato. Responsável
 * pela acolhida e preenchimento dos dados preliminares do paciente. 
 * Ao extender Pessoa, passa a herdar todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Recepcionista extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pessoa_cpfRecepcionista", nullable = false, unique = true, length = 11)
    private String cpfRecepcionista;

    @Column(name = "pessoa_cartao_sus", unique = true, nullable = false, length = 20)
    private String cartaoSusRecepcionista;
}
