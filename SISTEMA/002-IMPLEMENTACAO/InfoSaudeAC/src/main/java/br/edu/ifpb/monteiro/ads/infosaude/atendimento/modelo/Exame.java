package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * Entidade que representa um Exame a ser executado por algum profissional de
 * saúde da UBS ou encaminhado pelos mesmos para ser realizado fora da UBS. Ao
 * extender Pessoa, passa a herdar todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Data
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exame_descricao", length = 200, nullable = false)
    private String descricao;

    @Lob
    @Column(name = "exame_detalhes")
    private String detalhes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "exame_data")
    private Date data;

}
