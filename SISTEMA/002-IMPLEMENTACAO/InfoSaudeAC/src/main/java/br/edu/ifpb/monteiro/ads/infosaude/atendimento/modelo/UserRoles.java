package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Permissao;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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
public class UserRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    
    @Id
    @Column(name = "user_id")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "user_id_fk")
//    private Conta conta;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false, length = 50)
    private Permissao role;
    
}
