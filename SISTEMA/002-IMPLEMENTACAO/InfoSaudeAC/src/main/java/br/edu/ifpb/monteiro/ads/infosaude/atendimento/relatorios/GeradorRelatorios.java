package br.edu.ifpb.monteiro.ads.infosaude.atendimento.relatorios;

import java.io.IOException;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class GeradorRelatorios {

    @Inject
    public EntityManager entityManager;

    /**
     * Retorna uma conexão ativa com o banco de dados
     *
     * @return
     */
    public Connection getConexao() {
        return entityManager.unwrap(Connection.class);
    }

    public void fecharConexao() {
        if (getConexao() != null) {
            try {
                getConexao().close();
            } catch (SQLException e) {
                try {
                    throw new SQLException("Erro ao fechar a conexão", e);
                } catch (SQLException ex) {
                    Logger.getLogger(GeradorRelatorios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Captura o caminho completo onde os arquivos de template compilados
     * (.jasper) do relatório se encontram, contanto que este arquivo esteja na
     * pasta resources.
     *
     * @return
     */
    public String pegarCaminhoRelatorio() {
        return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/relatorios/");
    }

    public void preparaRelatorio(String nomeArquivoJasper, String nomeArquivoPdf) {
        try {

            /*
                Monta o caminho completo do arquivo de template compilado (.jasper) do relatório.
             */
            String caminhoArquivoJasper = pegarCaminhoRelatorio() + nomeArquivoJasper;

            // abre a conexão com o banco de dados
            entityManager.getTransaction().begin();

            /* Resultado do relatório o jasperprint representa o documento gerado. Ao preencher relatório com os dados, 
             os resultados podem ser enviados pela rede, armazenados em um formulário serializado em disco ou 
             exportados para vários outros formatos, como PDF, HTML, XLS, CSV ou XML. 
            
             O JasperFillManager é uma fachada para a classe que será utilizada para buscar os dados na base de dados
             este porde ser obtido de varias formas. Aqui passamos como parametro do fillReport o 'local do arquivo',
             os parametros que seram passados na consulta para o relatório e a conexao com o banco
             */
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoArquivoJasper, null, getConexao());

            // Array de byte do relatório no formato pdf. o JasperExportManager é uma fachada para os tipos de modelos que 
            // podem ser gerados a partir do resultado do jasperPrint
            // Aqui foi utilizado o exportReportToPdf para exportar o relatorio passado como parametro para o formato pdf 
            byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);

            // Permite passar informações no cabeçalho da página: o nome do arquivo de download, o contentType que é uma
            // arquivo aplication/pdf por ser um pdf, por exemplo
            HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            // passando o tipo do arquivo de saida
            res.setContentType("application/pdf");

            //Gerar o relatório e disponibiliza diretamente na página. passando como parametro no cabeçario
            // o o Content-disposition acho 'que indica que os parametros devem está disponivel no inicio do cabeçario,
            // o inline para ser mostrado altomaticamente e o filename com o nome do arquivo para download.
            res.setHeader("Content-disposition", "inline;filename=" + nomeArquivoPdf);

            //Código abaixo gerar o relatório e disponibiliza para o cliente baixar ou salvar   
            // ---> res.setHeader("Content-disposition", "attachment;filename=arquivo.pdf");  
            // response, criar o arquipo contido em b 'array de byte do relatório'
            res.getOutputStream().write(b);

            // retorna a codificação de caractere utilizada
            res.getCharacterEncoding();

            // Confirma o termino da execução para pagina jsf. Não permitindo alteração após  
            // a execução do relatório
            FacesContext.getCurrentInstance().responseComplete();

            fecharConexao();
        } catch (JRException | IOException ex) {
            ex.printStackTrace();
        }
    }

}
