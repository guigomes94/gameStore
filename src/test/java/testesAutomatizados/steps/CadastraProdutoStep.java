package testesAutomatizados.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import testesAutomatizados.jsonMapper.jsonRequest;

public class CadastraProdutoStep{

    private static final String ENDPOINT = "http://localhost:8080/products";
    private String token;
    private Response response;
    private RequestSpecification request;
    private String responseBody;
    private AbstractStep step = new AbstractStep();

    @Given("Dado o endpoint Post\\/product")
    public void dado_o_endpoint_post_product() {
        Response responseToken = step.generateToken();
        token = step.extract(responseToken,null);

    }
    @When("Quando recebe uma requisicao post")
    public void quando_recebe_uma_requisicao_post() {
        String jsonSucess = new jsonRequest().jsonSucess();
        System.out.println(token);

        response = step.sendRequestPost(jsonSucess, ENDPOINT,token);

    }
    @Then("Entao retorna status http {string}")
    public void entao_retorna_status_http(String string) {
        String statusCode = Integer.toString(response.statusCode());
        Assert.assertEquals(string,statusCode);


    }
    @Then("O produto é cadastrado com sucesso.")
    public void o_produto_é_cadastrado_com_sucesso() {
        String title = "Grand Theft Auto IV";
        Double costPrice = 90.0;
        Double sellPrice = 120.0;
        String description = "Grand Theft Auto IV e um jogo eletronico de acao-aventura desenvolvido pela Rockstar North e publicado pela Rockstar Games";

        String titleResponse = step.extract(response,"title");
        String costPriceResponse = step.extract(response,"costPrice").toString();
        String sellPriceResponse = step.extract(response, "sellPrice").toString();
        String descriptionResponse = step.extract(response, "description");

        Assert.assertEquals(title,titleResponse);
        Assert.assertEquals(costPrice.toString(),costPriceResponse);
        Assert.assertEquals(sellPrice.toString(),sellPriceResponse);
        Assert.assertEquals(description,descriptionResponse);




    }


}
