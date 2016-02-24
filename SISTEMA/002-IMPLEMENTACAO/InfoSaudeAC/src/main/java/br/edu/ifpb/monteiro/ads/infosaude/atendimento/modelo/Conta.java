package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

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
 * @author elisangela <elysangeladesouza@gmail.com> e contribuição de Marcus Patriota <macusvp@gmail.com>
 */
@Entity
@Data
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long id;

    @Column(name = "username", nullable = false, length = 25, unique = true)
    private String userName;

    @Column(name = "password", nullable = false, length = 40)
    private String password;
    
    //@Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private String userRoles;
    
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "conta_data")
//    private Date data;
    
//    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
//            message = "E-mail com formato incorreto")
//    @Column(name = "pessoa_email", length = 100)
//    private String email;
    
}
