package web.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaCarrinho {
    private WebDriver navegador;
    private By botaoCheckout = By.id("checkout");

    public PaginaCarrinho(WebDriver navegador) {
        this.navegador = navegador;
    }

    public void clicarNoCheckout() {
        navegador.findElement(botaoCheckout).click();
    }
}