package steps;

import api.ApiHeaders;
import api.ApiRequest;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import users.*;
import utils.JsonUtils;
import utils.PropertiesUtils;

import java.util.HashMap;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Classe que indica o passo a passo da automação atráves da escrita do bdd
// controla  tudo
public class GorestSteps extends ApiRequest {

    //instanciação de classes:
    PropertiesUtils prop = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();//biblioteca randomico no pom.xml
    UsersLombok userEnvio;

    @Dado("que possou gorest token valido")
    public void que_possou_gorest_token_valido() {

        token = prop.getProp("token_gorest");
    }

    @Quando("envio um request de cadastro de usuario com dados validos")
    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() throws JSONException {
        super.uri = prop.getProp("uri_gorest");
        super.headers = apiHeaders.gorestHeaders(token);//envia as informação da API
        userEnvio = UsersLombok.builder()
                .email(faker.internet().emailAddress())
                .name(faker.name().fullName())
                .gender("female")
                .status("active")
                .build();

        super.body = new JSONObject(new Gson().toJson(userEnvio));
        super.POST();
    }

    @Entao("o usuario deve ser criado corretamente")
    public void o_usuario_deve_ser_criado_corretamente() throws JSONException {
        assertEquals(userEnvio, response.jsonPath().getObject("data", UsersLombok.class),
                "Erro na comparação do objeto.");

        // faz a comparação do que foi enviado e do que está retornando
        // faz a validação
        // toLowerCase(), converte tudo para minusculo
        // validaçao(resposta da requisição);
//        //assertEquals(body.getString("gender").toLowerCase(), response.jsonPath().get("data.gender"));validaçao(resposta da requisição)
    }

    @Entao("o status code do request deve ser {int}") // retorno do staus
    public void o_status_code_do_request_deve_ser(Integer statusEsperado) {
        assertEquals(statusEsperado, response.statusCode(), "Status code diferente do esperado!");
    }

    @Dado("existe um usuario cadastrado no api")
    public void existe_um_usuario_cadastrado_no_api() {
        envio_um_request_de_cadastro_de_usuario_com_dados_validos();

    }

    @Quando("buscar esse usuario")
    public void buscar_esse_usuario() {
        super.uri = prop.getProp("uri_gorest") + "/" + response.jsonPath().getJsonObject("data.id");
        super.headers = apiHeaders.gorestHeaders(token);
        super.body = new JSONObject();
        super.GET();
    }

    @Entao("os dados dos usuario devem ser retornados")
    public void os_dados_dos_usuario_devem_ser_retornados() {
        assertEquals(userEnvio, response.jsonPath().getObject("data", UsersLombok.class),
                "Erro na comparação do objeto.");

    }
    @Quando("altero os dados do usuario")
    public void altero_os_dados_do_usuario() {
        super.uri = prop.getProp("uri_gorest") + "/" + response.jsonPath().getJsonObject("data.id");
        super.headers = apiHeaders.gorestHeaders(token);
        userEnvio.setStatus("inactive");
        super.body = new JSONObject(new Gson().toJson(userEnvio));
        super.PUT();

    }
    @Entao("o usuario deve ser alterado com sucesso")
    public void o_usuario_deve_ser_alterado_com_sucesso() {
        assertEquals(userEnvio, response.jsonPath().getObject("data", UsersLombok.class),
                "Erro na comparação do objeto.");
    }


    @Quando("altero  um ou mais dados do usuario")
    public void alteroUmOuMaisDadosDoUsuario() {
        super.uri = prop.getProp("uri_gorest") + "/" + response.jsonPath().getJsonObject("data.id");
        super.headers = apiHeaders.gorestHeaders(token);
        userEnvio.setGender("male");
        super.body = new JSONObject("{\"gender\": \"male\"}");
        super.PATCH();
    }

    @Quando("delete esse usuario")
    public void delete_esse_usuario() {
        super.uri = prop.getProp("uri_gorest") + "/" + response.jsonPath().getJsonObject("data.id");
        super.headers = apiHeaders.gorestHeaders(token);
        super.body = new JSONObject();
        super.DELETE();
    }

    @Entao("o usuario é deletado corretamente")
    public void o_usuario_é_deletado_corretamente() {
        assertEquals("",response.asString());

    }
}
