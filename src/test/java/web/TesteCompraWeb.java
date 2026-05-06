package web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import web.paginas.PaginaCarrinho;
import web.paginas.PaginaCheckout;
import web.paginas.PaginaProdutos;
import web.paginas.PaginaLogin;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteCompraWeb {

    private WebDriver navegador;

    @BeforeEach
    public void iniciarNavegador() {
        // Opções para rodar oculto no GitHub Actions
        ChromeOptions opcoes = new ChromeOptions();
        opcoes.addArguments("--headless");
        opcoes.addArguments("--disable-gpu");
        opcoes.addArguments("--window-size=1920,1080");

        navegador = new ChromeDriver(opcoes);
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        navegador.get("https://www.saucedemo.com/");
    }

    @Test
    public void deveRealizarCompraComSucesso() {
        PaginaLogin paginaLogin = new PaginaLogin(navegador);
        PaginaProdutos paginaProdutos = new PaginaProdutos(navegador);
        PaginaCarrinho paginaCarrinho = new PaginaCarrinho(navegador);
        PaginaCheckout paginaCheckout = new PaginaCheckout(navegador);

        // O fluxo do usuário interagindo com a página
        paginaLogin.fazerLogin("standard_user", "secret_sauce");
        paginaProdutos.adicionarMochilaAoCarrinho();
        paginaProdutos.acessarCarrinho();

        paginaCarrinho.clicarNoCheckout();

        paginaCheckout.preencherDadosEContinuar("Joao", "Silva", "12345-678");
        paginaCheckout.finalizarCompra();

        // Verificando se deu certo
        String mensagem = paginaCheckout.pegarMensagemDeSucesso();
        assertEquals("Thank you for your order!", mensagem);
    }

    @AfterEach
    public void fecharNavegador() {
        if (navegador != null) {
            navegador.quit(); // Encerra o Chrome ao final do teste
        }
    }
}