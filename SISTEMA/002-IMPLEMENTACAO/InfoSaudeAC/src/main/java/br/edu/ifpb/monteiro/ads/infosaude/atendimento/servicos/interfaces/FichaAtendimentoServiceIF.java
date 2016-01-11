/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface FichaAtendimentoServiceIF {

    public List<FichaAtendimento> findAll();

    public void save(FichaAtendimento fichaAtendimento);

    public void delete(FichaAtendimento fichaAtendimentoSelecionada);
    
}
