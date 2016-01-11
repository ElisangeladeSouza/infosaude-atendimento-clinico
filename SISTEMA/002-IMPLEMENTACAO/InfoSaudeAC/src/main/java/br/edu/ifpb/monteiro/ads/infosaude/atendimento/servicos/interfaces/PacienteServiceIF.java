/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Paciente;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface PacienteServiceIF {

    public List<Paciente> findAll();

    public void save(Paciente paciente);

    public void delete(Paciente pacienteSelecionado);
    
}
