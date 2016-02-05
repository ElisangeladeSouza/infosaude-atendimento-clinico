/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Procedimento;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface ProcedimentoServiceIF {

    public List<Procedimento> findAll();

    public void save(Procedimento procedimento);

    public void delete(Procedimento procedimentoSelecionado);
    
}