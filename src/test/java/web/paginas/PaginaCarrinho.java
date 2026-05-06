package web.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaginaCarrinho {
    private WebDriver navegador;
    private By botaoCheckout = By.id("checkout");

    public PaginaCarrinho(WebDriver navegador) {
        this.navegador = navegador;
    }

    public void clicarNoCheckout() {
        // Aguarda o botão de checkout estar visível e clicável
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(botaoCheckout)).click();
    }
}