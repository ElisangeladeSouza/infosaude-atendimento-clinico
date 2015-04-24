package acceptance.test.br.edu.ifpb.monteiro.ads.infosaude.atendimento.medico;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastroMedicoObrigatorioCompletoRepetido {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCadastroMedicoObrigatorioCompletoRepetido() throws Exception {
    driver.get(baseUrl + "/InfoSaudeAC/medico/CapaMedico.xhtml");
    driver.findElement(By.id("tabMedico:formCadastroMedico:crm")).clear();
    driver.findElement(By.id("tabMedico:formCadastroMedico:crm")).sendKeys("1240001");
    driver.findElement(By.id("tabMedico:formCadastroMedico:cpf")).clear();
    driver.findElement(By.id("tabMedico:formCadastroMedico:cpf")).sendKeys("131.784.202-23");
    driver.findElement(By.id("tabMedico:formCadastroMedico:cartaoSus")).clear();
    driver.findElement(By.id("tabMedico:formCadastroMedico:cartaoSus")).sendKeys("01234560000");
    driver.findElement(By.id("tabMedico:formCadastroMedico:nome")).clear();
    driver.findElement(By.id("tabMedico:formCadastroMedico:nome")).sendKeys("Ed Corvo");
    driver.findElement(By.id("tabMedico:formCadastroMedico:saveButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("span.ui-growl-title"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("Médico cadastrado com sucesso!", driver.findElement(By.cssSelector("span.ui-growl-title")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.get(baseUrl + "/InfoSaudeAC/medico/CapaMedico.xhtml");
    driver.findElement(By.id("tabMedico:formCadastroMedico:crm")).clear();
    driver.findElement(By.id("tabMedico:formCadastroMedico:crm")).sendKeys("1240001");
    driver.findElement(By.id("tabMedico:formCadastroMedico:cpf")).clear();
    driver.findElement(By.id("tabMedico:formCadastroMedico:cpf")).sendKeys("131.784.202-23");
    driver.findElement(By.id("tabMedico:formCadastroMedico:cartaoSus")).clear();
    driver.findElement(By.id("tabMedico:formCadastroMedico:cartaoSus")).sendKeys("01234560000");
    driver.findElement(By.id("tabMedico:formCadastroMedico:nome")).clear();
    driver.findElement(By.id("tabMedico:formCadastroMedico:nome")).sendKeys("Ed Corvo");
    driver.findElement(By.id("tabMedico:formCadastroMedico:saveButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("span.ui-growl-title"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("Este médico já está cadastrado!", driver.findElement(By.cssSelector("span.ui-growl-title")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
