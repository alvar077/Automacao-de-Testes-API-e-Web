package web.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(15));
        WebElement botaoAdd = wait.until(ExpectedConditions.elementToBeClickable(botaoAdicionarMochila));
        ((JavascriptExecutor) navegador).executeScript("arguments[0].click();", botaoAdd);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
    }

    public void acessarCarrinho() {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(15));
        WebElement carrinho = navegador.findElement(iconeCarrinho);
        ((JavascriptExecutor) navegador).executeScript("arguments[0].click();", carrinho);
    }
}