package testesAutomatizados.steps;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import testesAutomatizados.jsonMapper.jsonRequest;

import static io.restassured.RestAssured.given;

public class AbstractStep {
    private Response response;
    private RequestSpecification request;

    public Response generateToken(){
        String bodyRequest = new jsonRequest().jsonToken();

        RequestSpecification requestPost = configRequest();
        requestPost.header("Content-Type", "application/json");
        requestPost.body(bodyRequest);

        response = requestPost.post("http://localhost:8080/login");

        return response;
    }

    public Response sendRequestGet(String token, String url){
        RequestSpecification requestGet = configRequest();
        requestGet.header("Authorization","Bearer "+token);

        response = requestGet.get(url);
        return response;
    }

    public Response sendRequestPost(String body, String url, String token){
        RequestSpecification requestPost = configRequest();
        requestPost.header("Content-Type", "application/json");
        requestPost.header("Authorization","Bearer "+token);
        requestPost.body(body);

        response = request.post(url);

        return response;
    }

    private RequestSpecification configRequest(){
        request = given();
        return request;
    }

    public String extract(Response response, String field){
        if(field == null){
           return extractBody(response);
        }else{
            return extractField(response,field);
        }
    }

    private String extractBody(Response response) {
        return response.body().asString();
    }

    private String extractField(Response response, String field){
        String body = extractBody(response);
        if(field == "costPrice" || field == "sellPrice"){
            Float value = JsonPath.from(body).get(field);
            return value.toString();
        }else{
            String value = JsonPath.from(body).get(field);
            return value;
        }
    }
}
