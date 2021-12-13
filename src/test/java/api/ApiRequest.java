package api;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

//metodo das chamadas de requisição da api verbos, que na qual herdar os atributos da classe ApiUtils
public class ApiRequest extends ApiUtils implements ApiVerbos {

    @Override
    public void GET() {
        response = given()
                .relaxedHTTPSValidation()
                .params(params)
                .headers(headers)
                .get(uri);
        super.log("Get");
    }

    @Override
    public void POST() {
        //response é responsavel por setar o valor
        response = given()
                .relaxedHTTPSValidation()
                .params(params)
                .headers(headers)
                .body(body.toString())
                .post(uri);

        super.log("POST");


    }

    @Override
    public void PUT() {
        response = given()
                .relaxedHTTPSValidation()
                .params(params)
                .headers(headers)
                .body(body.toString())
                .put(uri);

        super.log("PUT");

    }

    @Override
    public void PATCH() {
        response = given()
                .relaxedHTTPSValidation()
                .params(params)
                .headers(headers)
                .body(body.toString())
                .patch(uri);

        super.log("PATCH");

    }

    @Override
    public void DELETE() {
        response = given()
                .relaxedHTTPSValidation()
                .params(params)
                .headers(headers)
                .delete(uri);

        super.log("DELETE");

    }
}
