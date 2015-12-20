package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * Entidade que representa o Sintoma que o paciente está tendo que pode ser
 * extraído de uma consulta do Médico, Enfermeiro ou Odontólogo da UBS. 
 * Ao extender Pessoa, passa a herdar todos os seus atributos.
 * 
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Data
public class Sintoma implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sintoma_descricao", length = 150)
    private String descricao;

}
