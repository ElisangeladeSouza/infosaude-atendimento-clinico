package br.edu.ifpb.monteiro.ads.infosaude.atendimento.relatorios;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;


/**
 *
 * @author cassio
 */
public class GeradorRelatorios {
    
    /*
     Injeta o EntityManager 
     */
    @Inject
    public EntityManager entityManager;


    /**
     * Retorna uma conexão ativa com o banco de dados
     * 
     * @return 
     */
    public Connection getConexao() {
        // EntityManager.unwrap - retorna a conexão ativa com as devidas 
        // permissões
        return entityManager.unwrap(Connection.class);
    }

    /*
     Método para fechar a conexão      
     */
    public void fecharConexao() {
        // se a conexão for diferente de nulo
        if (getConexao() != null) {
            try {
                // fecha conexão
                getConexao().close();
            } catch (SQLException e) {
                try {
                    throw new SQLException("Erro ao fechara conexão", e);
                } catch (SQLException ex) {
                    Logger.getLogger(RelatorioTodosMedicos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /*
     Método para pegar o caminho completo do local onde está os relatórios
     */
    public String pegarCaminhoRelatorio() {

        return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/relatorios/");

    }
    
}
