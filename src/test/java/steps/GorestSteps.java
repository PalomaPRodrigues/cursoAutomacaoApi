package steps;

import api.ApiHeaders;
import api.ApiRequest;
import api.ApiUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import utils.JsonUtils;
import utils.PropertiesUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Classe que indica o passo a passo da automação atráves da escrita do bdd
public class GorestSteps extends ApiRequest {

    //instanciação de classes:
    PropertiesUtils prop = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();//biblioteca randomico

    @Dado("que possou gorest token valido")
    public void que_possou_gorest_token_valido() {
        token = prop.getProp("token_gorest");
    }

    @Quando("envio um request de cadastro de usuario com dados validos")
    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() throws IOException {
        super.uri = prop.getProp("uri_gorest");
        headers = apiHeaders.gorestHeaders(token);//envia as informação da API
        body = jsonUtils.parseJSONFile("create_user");
        super.body.put("email", faker.internet().emailAddress());
        super.POST();
    }

    @Entao("o usuario deve ser criado corretamente")
    public void o_usuario_deve_ser_criado_corretamente() {
        assertEquals(body.getString("email"), response.jsonPath().get("data.email"));
        assertEquals(body.getString("name"), response.jsonPath().get("data.name"));


    }

    @Entao("o status code do request deve ser {int}")
    public void o_status_code_do_request_deve_ser(Integer statusEsperado) {
        assertEquals(statusEsperado, response.statusCode(), "Status code diferente do esperado!");
    }

}
