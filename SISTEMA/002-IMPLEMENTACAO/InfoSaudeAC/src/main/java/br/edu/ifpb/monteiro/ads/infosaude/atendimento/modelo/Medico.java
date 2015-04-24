package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author elisangela
 */

@Entity
public class Medico extends Pessoa {
    
    @Column(name = "medico_crm", length = 30)
    private String crm;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
