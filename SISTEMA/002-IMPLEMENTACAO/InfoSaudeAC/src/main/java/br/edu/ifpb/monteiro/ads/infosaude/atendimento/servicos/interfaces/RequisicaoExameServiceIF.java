/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.RequisicaoExame;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface RequisicaoExameServiceIF {

    public List<RequisicaoExame> findAll();

    public boolean verificaCampoUnique(String campo, Object valor, Long id);

    public void save(RequisicaoExame requisicaoExame);

    public void delete(RequisicaoExame requisicaoExameSelecionada);
    
}
