/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Consulta;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface ConsultaServiceIF {

    public List<Consulta> findAll();

    public void save(Consulta consulta);

    public void delete(Consulta consultaSelecionada);
    
}
