package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TesteLoja {

    @BeforeAll
    public static void configuracaoInicial() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void deveCriarUmPedidoNaLoja() {
        String corpoRequisicao = "{ \"id\": 5050, \"petId\": 101010, \"quantity\": 1, \"status\": \"placed\", \"complete\": true }";

        given()
                .header("Content-Type", "application/json")
                .body(corpoRequisicao)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .body("status", equalTo("placed"));
    }
}