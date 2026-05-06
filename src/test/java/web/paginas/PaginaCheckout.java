package web.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaCheckout {
    private WebDriver navegador;

    private By campoNome = By.id("first-name");
    private By campoSobrenome = By.id("last-name");
    private By campoCep = By.id("postal-code");
    private By botaoContinuar = By.id("continue");
    private By botaoFinalizar = By.id("finish");
    private By mensagemDeSucesso = By.className("complete-header");

    public PaginaCheckout(WebDriver navegador) {
        this.navegador = navegador;
    }

    public void preencherDadosEContinuar(String nome, String sobrenome, String cep) {
        navegador.findElement(campoNome).sendKeys(nome);
        navegador.findElement(campoSobrenome).sendKeys(sobrenome);
        navegador.findElement(campoCep).sendKeys(cep);
        navegador.findElement(botaoContinuar).click();
    }

    public void finalizarCompra() {
        navegador.findElement(botaoFinalizar).click();
    }

    public String pegarMensagemDeSucesso() {
        return navegador.findElement(mensagemDeSucesso).getText();
    }
}