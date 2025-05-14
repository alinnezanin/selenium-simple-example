import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FormularioTest {

    static WebDriver driver;

    @BeforeAll
    static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String filePath = Paths.get("formulario.html").toAbsolutePath().toUri().toString();
        driver.get(filePath);
    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }

    @Test
    void devePreencherFormularioEValidarCampos() {
        WebElement nome = driver.findElement(By.id("nome"));
        WebElement estado = driver.findElement(By.id("estado"));
        WebElement musica = driver.findElement(By.id("musica"));
        WebElement esporte = driver.findElement(By.id("esporte"));
        WebElement generoFem = driver.findElement(By.id("feminino"));
        WebElement btn = driver.findElement(By.id("btnEnviar"));

        nome.sendKeys("Aline");
        estado.sendKeys("São Paulo");
        musica.click();
        esporte.click();
        generoFem.click();

        assertTrue(generoFem.isSelected(),
                "Radio feminino deve estar selecionado");
        assertEquals("Aline", nome.getAttribute("value"),
                "O nome deve ser preenchido");
        assertEquals("sp", estado.getAttribute("value"),
                "Deve selecionar SP");
        assertTrue(musica.isSelected(),
                "Checkbox Música deve estar selecionado");
        assertTrue(esporte.isSelected(),
                "Checkbox Esporte deve estar selecionado");

        assertAll("Verificações do botão",
                () -> assertTrue(btn.isDisplayed(), "Botão deve estar visível"),
                () -> assertTrue(btn.isEnabled(), "Botão deve estar habilitado")
        );
    }

    @Test
    void deveValidarCamposNaoPreenchidos() {
        WebElement nome = driver.findElement(By.id("nome"));
        WebElement estado = driver.findElement(By.id("estado"));

        assertAll("Verificações de campos obrigatórios (sem preenchimento)",
                () -> assertEquals("", nome.getAttribute("value"), "Nome deve estar vazio inicialmente"),
                () -> assertEquals("", estado.getAttribute("value"), "Estado deve estar vazio inicialmente")
        );
    }

    @Test
    void deveValidarExclusividadeDosRadios() {
        WebElement feminino = driver.findElement(By.id("feminino"));
        WebElement masculino = driver.findElement(By.id("masculino"));

        masculino.click();
        assertTrue(masculino.isSelected(),
                "Masculino deve estar selecionado");
        assertFalse(feminino.isSelected(),
                "Feminino não deve estar selecionado");

        feminino.click();
        assertTrue(feminino.isSelected(),
                "Feminino deve estar selecionado");
        assertFalse(masculino.isSelected(),
                "Masculino não deve estar selecionado");
    }
}
