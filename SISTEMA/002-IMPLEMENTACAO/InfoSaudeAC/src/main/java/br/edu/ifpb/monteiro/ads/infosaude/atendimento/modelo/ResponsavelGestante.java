package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * Entidade que representa o responsável em caso da gestante ser menor de 15 anos. Ao extender Pessoa,
 * passa a herdar todos os seus atributos.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
//@Entity
@Embeddable
public class ResponsavelGestante extends Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
}
