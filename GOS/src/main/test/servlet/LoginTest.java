package servlet;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        // Configura il driver del browser (assumi che il driver di Chrome sia installato sul tuo sistema)
        System.setProperty("webdriver.chrome.driver", "percorso/del/tuo/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        // Naviga verso la pagina contenente il codice HTML fornito
        driver.get("URL_DEL_TUO_SITO"); // Sostituisci con l'effettivo URL del tuo sito

        // Esegui le azioni di login
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        usernameInput.sendKeys("Spaghettino");
        passwordInput.sendKeys("Ciaone55");
        submitButton.click();

        // Esegui le asserzioni o verifiche dei risultati
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        assert(welcomeMessage.getText().contains("Benvenuto"));
    }

    @AfterAll
    public static void tearDown() {
        // Chiudi il browser
        driver.quit();
    }
}
