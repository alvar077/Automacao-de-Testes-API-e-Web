package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestePet {

    @BeforeAll
    public static void configuracaoInicial() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void deveAdicionarUmNovoPet() {
        String corpoRequisicao = "{ \"id\": 101010, \"name\": \"Caramelo\", \"status\": \"available\" }";

        given()
                .header("Content-Type", "application/json")
                .body(corpoRequisicao)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .body("name", equalTo("Caramelo"));
    }
}