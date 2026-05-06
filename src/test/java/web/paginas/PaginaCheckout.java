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
        this.wait = new WebDriverWait(navegador, Duration.ofSeconds(20));
    }

    public void preencherDadosEContinuar(String nome, String sobrenome, String cep) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoNome)).sendKeys(nome);
        navegador.findElement(campoSobrenome).sendKeys(sobrenome);
        navegador.findElement(campoCep).sendKeys(cep);
        WebElement btnContinuar = wait.until(ExpectedConditions.presenceOfElementLocated(botaoContinuar));
        ((JavascriptExecutor) navegador).executeScript("arguments[0].click();", btnContinuar);
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));
    }

    public void finalizarCompra() {
        WebElement btnFinish = wait.until(ExpectedConditions.elementToBeClickable(botaoFinalizar));
        ((JavascriptExecutor) navegador).executeScript("arguments[0].click();", btnFinish);
    }

    public String pegarMensagemDeSucesso() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemDeSucesso)).getText();
    }
}