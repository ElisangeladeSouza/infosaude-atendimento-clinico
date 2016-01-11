/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface EnfermeiroServiceIF {

    public List<Enfermeiro> findAll();

    public void save(Enfermeiro enfermeiro);

    public void delete(Enfermeiro enfermeiroSelecionado);
    
}
