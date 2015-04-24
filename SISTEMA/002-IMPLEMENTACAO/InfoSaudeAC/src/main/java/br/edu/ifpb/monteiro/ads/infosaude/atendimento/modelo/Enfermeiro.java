package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author cassio
 */
@Entity
public class Enfermeiro extends Pessoa {

    @Column(name = "enfermeiro_coren", length = 30)
    private String coren;

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

}
