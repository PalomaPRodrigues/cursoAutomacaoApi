package api;

import static io.restassured.RestAssured.given;

public class ApiRequest extends ApiUtils implements ApiVerbos {

    @Override
    public void GET() {
        response = given()
                .relaxedHTTPSValidation()
                .params(params)
                .headers(hearders)
                .get(uri);
        super.log( "Get");
    }

    @Override
    public void POST() {
        response = given()
                .relaxedHTTPSValidation()
                .params(params)
                .headers(hearders)
                .body(body.toString())
                .post(uri);

        super.log( "POST");


    }

    @Override
    public void PUT() {
        response = given()
                .relaxedHTTPSValidation()
                .params(params)
                .headers(hearders)
                .body(body.toString())
                .put(uri);

        super.log( "PUT");

    }

    @Override
    public void PATCH() {
        response = given()
                .relaxedHTTPSValidation()
                .params(params)
                .headers(hearders)
                .body(body.toString())
                .patch(uri);

        super.log( "PATCH");

    }

    @Override
    public void DELETE() {
        response = given()
                .relaxedHTTPSValidation()
                .params(params)
                .headers(hearders)
                .delete(uri);

        super.log( "DELETE");

    }
}
