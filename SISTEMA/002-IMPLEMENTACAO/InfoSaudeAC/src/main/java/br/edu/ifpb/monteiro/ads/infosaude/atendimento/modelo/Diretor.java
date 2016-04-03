package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entidade que representa o Diretor da UBS. Esse diretor é uma
 * espécie de gerente que poderá ter poderes administrativos sobre todas as
 * operações contidadas dentro do sistema. Apenas o Diretor pode realizar
 * algumas operações que nenhum outro profissional com acesso ao sistema pode
 * ter. Ao extender Pessoa, passa a herdar todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Diretor extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pessoa_cpf_diretor", nullable = false, unique = true, length = 11)
    private String cpfDiretor;

    @Column(name = "pessoa_cartao_sus", unique = true, nullable = false, length = 20)
    private String cartaoSusDiretor;
}
