package web.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaginaCarrinho {
    private WebDriver navegador;

    public PaginaCarrinho(WebDriver navegador) {
        this.navegador = navegador;
    }

    public void clicarNoCheckout() {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(15));
        WebElement botao = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkout")));
        ((JavascriptExecutor) navegador).executeScript("arguments[0].click();", botao);
    }
}