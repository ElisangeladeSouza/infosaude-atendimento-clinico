package acceptance.test.br.edu.ifpb.monteiro.ads.infosaude.atendimento;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastroEnfermeiroObrigatorioCompletoRepetido {
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
  public void testCadastroEnfermeiroObrigatorioCompletoRepetido() throws Exception {
    driver.get(baseUrl + "/InfoSaudeAC/enfermeiro/CapaEnfermeiro.xhtml");
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:coren")).clear();
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:coren")).sendKeys("1240001");
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:cpf")).clear();
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:cpf")).sendKeys("131.784.202-23");
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:cartaoSus")).clear();
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:cartaoSus")).sendKeys("01234560000");
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:nome")).clear();
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:nome")).sendKeys("Ed Corvo");
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:saveButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("span.ui-growl-title"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("Enfermeiro cadastrado com sucesso!", driver.findElement(By.cssSelector("span.ui-growl-title")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.get(baseUrl + "/InfoSaudeAC/enfermeiro/CapaEnfermeiro.xhtml");
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:coren")).clear();
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:coren")).sendKeys("1240001");
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:cpf")).clear();
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:cpf")).sendKeys("131.784.202-23");
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:cartaoSus")).clear();
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:cartaoSus")).sendKeys("01234560000");
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:nome")).clear();
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:nome")).sendKeys("Ed Corvo");
    driver.findElement(By.id("tabEnfermeiro:formCadastroEnfermeiro:saveButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("span.ui-growl-title"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("Este enfermeiro já está cadastrado!", driver.findElement(By.cssSelector("span.ui-growl-title")).getText());
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
