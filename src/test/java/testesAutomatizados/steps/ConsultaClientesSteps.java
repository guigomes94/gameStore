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
    private String url = "http://localhost:8080/clients";
    private ValidatableResponse json;
    private AbstractStep step = new AbstractStep();
    private String token;

    @Given("Dado o endpoint Get\\/clients")
    public void dado_o_endpoint_get_clients() {
        request = given();
        Response responseToken = step.generateToken();
        token = step.extract(responseToken,null);


    }
    @When("Quando recebe uma requisicao")
    public void quando_recebe_uma_requisicao() {
        response = step.sendRequestGet(token,url);

    }
    @Then("Entao retorna todos os clientes")
    public void entao_retorna_todos_os_clientes() {
        json = response.then().statusCode(200);

        String name = "admin";
        String email = "admin@admin.com";
        String cpf = "00000000000";

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
        Response responseToken = step.generateToken();
        token = step.extract(responseToken,null);
    }
    @When("Quando recebe uma requisicao para o endpoint Get\\/clients\\/id")
    public void quando_recebe_uma_requisicao_para_o_endpoint_get_clients_id() {
        response = step.sendRequestGet(token,url+"/1");
    }
    @Then("Entao retorna o cliente que contem o id")
    public void entao_retorna_o_cliente_que_contem_o_id() {
        json = response.then().statusCode(200);

        String name = "admin";
        String email = "admin@admin.com";
        String cpf = "00000000000";
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
