package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *Entidade que representa os grupos de acesso do sistema. Cada papel no sistema
 * possui um grupo de permissões.
 * 
 * @author cassio <cassio@cassioliveira.com.br>
 */
@Entity
@Data
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "grupo_nome", length = 200, nullable = false)
    private String nome;

    @Column(name = "grupo_descricao", length = 20)
    private String descricao;

}
