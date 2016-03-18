package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entidade que representa o responsável em caso da gestante ser menor de 15 anos. Ao extender Pessoa,
 * passa a herdar todos os seus atributos.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
//@Embeddable
@Entity
public class ResponsavelGestante extends Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResponsavelGestante")
    private transient List<Gestante> gestantes;

}
