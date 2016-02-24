/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Medico;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface MedicoServiceIF {

    public List<Medico> findAll();

    public void save(Medico medico);

    public void delete(Medico medicoSelecionado);
    
    public void relatorioTodosMedicos();
    
}
