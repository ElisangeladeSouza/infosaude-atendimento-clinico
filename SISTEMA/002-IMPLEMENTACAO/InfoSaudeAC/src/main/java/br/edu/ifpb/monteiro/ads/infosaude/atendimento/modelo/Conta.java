package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Permissao;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * Entidade que representa as contas dos usuários do sistema. Nela estão 
 * contidas as permissões para acessar, inserir, editar, consultar e excluir 
 * informações no sistema.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Entity
@Data
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long id;

    @Column(name = "username", nullable = false, length = 25)
    private String userName;

    @Column(name = "password", nullable = false, length = 40)
    private String password;

    @Column(name = "permissao", nullable = true)
    private Permissao permissao;
    

}
