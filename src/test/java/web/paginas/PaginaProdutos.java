package web.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaginaProdutos {
    private WebDriver navegador;

    private By botaoAdicionarMochila = By.id("add-to-cart-sauce-labs-backpack");
    private By iconeCarrinho = By.className("shopping_cart_link");

    public PaginaProdutos(WebDriver navegador) {
        this.navegador = navegador;
    }

    public void adicionarMochilaAoCarrinho() {
        navegador.findElement(botaoAdicionarMochila).click();
    }

    public void acessarCarrinho() {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(iconeCarrinho)).click();
    }
}