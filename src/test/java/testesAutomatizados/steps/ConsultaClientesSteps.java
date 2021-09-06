package testesAutomatizados.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class ConsultaClientesSteps {

    private Response response;
    private RequestSpecification request;
    private String url = "http://localhost:8080/gamestore/clients";
    private ValidatableResponse json;

    @Given("Dado o endpoint Get\\/clients")
    public void dado_o_endpoint_get_clients() {
        request = given();


    }
    @When("Quando recebe uma requisicao")
    public void quando_recebe_uma_requisicao() {
        response = request.when().get(url);

    }
    @Then("Entao retorna todos os clientes")
    public void entao_retorna_todos_os_clientes() {
        json = response.then().statusCode(200);

        String name = "TESTESVALDO";
        String email = "TESTE@EU.COM";
        String cpf = "12345678";

        String JSONResponse = response.body().asString();
        String cpfResponse = JsonPath.from(JSONResponse).get("[0].cpf");
        String nameResponse = JsonPath.from(JSONResponse).get("[0].name");
        String emailResponse = JsonPath.from(JSONResponse).get("[0].email");

        Assert.assertEquals(name,nameResponse);
        Assert.assertEquals(email,emailResponse);
        Assert.assertEquals(cpf,cpfResponse);

    }

    @Given("Dado o endpoint Get\\/clients\\/id")
    public void dado_o_endpoint_get_clients_id() {
        request = given();
    }
    @When("Quando recebe uma requisicao para o endpoint Get\\/clients\\/id")
    public void quando_recebe_uma_requisicao_para_o_endpoint_get_clients_id() {
        response = request.when().get(url+"/1");
    }
    @Then("Entao retorna o cliente que contem o id")
    public void entao_retorna_o_cliente_que_contem_o_id() {
        json = response.then().statusCode(200);

        String name = "TESTESVALDO";
        String email = "TESTE@EU.COM";
        String cpf = "12345678";
        Integer id = 1;




        String JSONResponse = response.body().asString();
        Integer idResponse = JsonPath.from(JSONResponse).get("id");
        String cpfResponse = JsonPath.from(JSONResponse).get("cpf");
        String nameResponse = JsonPath.from(JSONResponse).get("name");
        String emailResponse = JsonPath.from(JSONResponse).get("email");

        Assert.assertEquals(id,idResponse);
        Assert.assertEquals(name,nameResponse);
        Assert.assertEquals(email,emailResponse);
        Assert.assertEquals(cpf,cpfResponse);
    }
}
