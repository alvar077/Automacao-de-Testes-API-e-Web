package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TesteUsuario {

    @BeforeAll
    public static void configuracaoInicial() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void deveCriarUmUsuario() {
        String corpoRequisicao = "{ \"id\": 9999, \"username\": \"aluno_teste\", \"firstName\": \"Aluno\", \"password\": \"12345\" }";

        given()
                .header("Content-Type", "application/json")
                .body(corpoRequisicao)
                .when()
                .post("/user")
                .then()
                .statusCode(200)
                .body("message", equalTo("9999"));
    }
}