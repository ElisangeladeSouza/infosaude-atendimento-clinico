/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade.testes.conversores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.conversores.AdministradorConverter;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.AdministradorDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Administrador;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wilde
 */
public class AdministradorConverterTest {
    
    public AdministradorConverterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Test (expected = Exception.class)
    public void testGetAsObject() throws UBSException {
        AdministradorConverter administradorConverter = new AdministradorConverter();
        administradorConverter.getAsObject(null, null, null);
    }

    @Test (expected = Exception.class)
    public void testGetAsString() throws UBSException {
        AdministradorConverter administradorConverter = new AdministradorConverter();
        administradorConverter.getAsString(null, null, null);
    }
    
}
