package web.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaginaCheckout {
    private WebDriver navegador;
    private WebDriverWait wait;

    private By campoNome = By.id("first-name");
    private By campoSobrenome = By.id("last-name");
    private By campoCep = By.id("postal-code");
    private By botaoContinuar = By.id("continue");
    private By botaoFinalizar = By.id("finish");
    private By mensagemDeSucesso = By.className("complete-header");

    public PaginaCheckout(WebDriver navegador) {
        this.navegador = navegador;
        this.wait = new WebDriverWait(navegador, Duration.ofSeconds(15)); // Aumentei para 15s
    }

    public void preencherDadosEContinuar(String nome, String sobrenome, String cep) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoNome)).sendKeys(nome);
        navegador.findElement(campoSobrenome).sendKeys(sobrenome);
        navegador.findElement(campoCep).sendKeys(cep);

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(botaoContinuar));
        ((JavascriptExecutor) navegador).executeScript("arguments[0].click();", btn);

        // NOVIDADE: Espera a URL mudar para a página de revisão
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));
    }

    public void finalizarCompra() {
        // Espera o botão finish estar visível na nova URL
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(botaoFinalizar));
        ((JavascriptExecutor) navegador).executeScript("arguments[0].click();", btn);
    }

    public String pegarMensagemDeSucesso() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemDeSucesso)).getText();
    }
}