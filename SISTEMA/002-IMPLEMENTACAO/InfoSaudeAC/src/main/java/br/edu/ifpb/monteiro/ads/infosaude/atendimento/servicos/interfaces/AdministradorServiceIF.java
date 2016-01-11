/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Administrador;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface AdministradorServiceIF {
    
    
    public void save(Administrador administrador);
    
    public void delete(Administrador administrador);
    
    public List<Administrador> findAll();
    
    public Administrador findById(Long id);
    
}
