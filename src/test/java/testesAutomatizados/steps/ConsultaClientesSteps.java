package testesAutomatizados.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ConsultaClientesSteps {

    private Response response;
    private RequestSpecification request;
    private String url;
    private ValidatableResponse json;

    @Given("Dado o endpoint Get\\/clients")
    public void dado_o_endpoint_get_clients() {

    }
    @When("Quando recebe uma requisicao")
    public void quando_recebe_uma_requisicao() {

    }
    @Then("Entao retorna todos os clientes")
    public void entao_retorna_todos_os_clientes() {

    }
}
