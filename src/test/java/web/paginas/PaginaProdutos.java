package web.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        navegador.findElement(iconeCarrinho).click();
    }
}