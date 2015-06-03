package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

//    @OneToOne(mappedBy = "atendimento")
    private String fichaAtendimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
