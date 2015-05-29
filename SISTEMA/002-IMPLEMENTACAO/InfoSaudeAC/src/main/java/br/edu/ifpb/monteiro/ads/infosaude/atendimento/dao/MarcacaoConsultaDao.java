package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.MarcacaoConsulta;
import java.io.Serializable;

/**
 * 
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class MarcacaoConsultaDao extends DaoAbstrato<MarcacaoConsulta> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public MarcacaoConsultaDao() {
        super(MarcacaoConsulta.class);
    }
    
}
