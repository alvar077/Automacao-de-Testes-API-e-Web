package web.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        // Criamos o wait aqui para usar em todos os métodos
        this.wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
    }

    public void preencherDadosEContinuar(String nome, String sobrenome, String cep) {
        // Espera o primeiro campo aparecer
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoNome)).sendKeys(nome);
        navegador.findElement(campoSobrenome).sendKeys(sobrenome);
        navegador.findElement(campoCep).sendKeys(cep);

        // Espera o botão continuar estar pronto e clica
        wait.until(ExpectedConditions.elementToBeClickable(botaoContinuar)).click();
    }

    public void finalizarCompra() {
        // Agora sim: espera o botão finish aparecer APÓS a mudança de tela
        wait.until(ExpectedConditions.elementToBeClickable(botaoFinalizar)).click();
    }

    public String pegarMensagemDeSucesso() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemDeSucesso)).getText();
    }
}