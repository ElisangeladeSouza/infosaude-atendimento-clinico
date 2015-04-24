package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author cassio
 */
@Entity
public class Odontologo extends Pessoa{
    
    @Column(name = "odontologo_cro", length = 30)
    private String cro;

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    
}
