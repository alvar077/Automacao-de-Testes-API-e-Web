package web.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaLogin {
    private WebDriver navegador;

    // Mapeamento de elementos
    private By campoUsuario = By.id("user-name");
    private By campoSenha = By.id("password");
    private By botaoLogin = By.id("login-button");

    public PaginaLogin(WebDriver navegador) {
        this.navegador = navegador;
    }

    // Ações na página
    public void fazerLogin(String usuario, String senha) {
        navegador.findElement(campoUsuario).sendKeys(usuario);
        navegador.findElement(campoSenha).sendKeys(senha);
        navegador.findElement(botaoLogin).click();
    }
}