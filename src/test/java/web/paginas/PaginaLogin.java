package web.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaginaLogin {
    private WebDriver navegador;

    public PaginaLogin(WebDriver navegador) {
        this.navegador = navegador;
    }

    public void fazerLogin(String usuario, String senha) {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(usuario);
        navegador.findElement(By.id("password")).sendKeys(senha);

        WebElement botao = navegador.findElement(By.id("login-button"));
        ((JavascriptExecutor) navegador).executeScript("arguments[0].click();", botao);
    }
}