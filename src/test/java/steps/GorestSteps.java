package steps;

import api.ApiHeaders;
import api.ApiRequest;
import api.ApiUtils;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.json.JSONObject;
import users.UserConstutor;
import users.UsersGettersSetters;
import users.UsersLombok;
import users.UsersRecord;
import utils.JsonUtils;
import utils.PropertiesUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Classe que indica o passo a passo da automação atráves da escrita do bdd
public class GorestSteps extends ApiRequest {

    //instanciação de classes:
    PropertiesUtils prop = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();//biblioteca randomico no pom.xml
    Map<String, String> jsonValues = new HashMap<>();


    @Dado("que possou gorest token valido")
    public void que_possou_gorest_token_valido() {
        token = prop.getProp("token_gorest");
    }

    @Quando("envio um request de cadastro de usuario com dados validos")
    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() throws Exception {
        super.uri = prop.getProp("uri_gorest");
        headers = apiHeaders.gorestHeaders(token);//envia as informação da API
        super.body = new UsersRecord(faker.internet().emailAddress(),
                "Female",
                faker.name().fullName(),
                "Active").getJson();
                //super.body = jsonUtils.setJsonValues(jsonUtils.parseJSONFile("create_user"),setJsoValues());
//        super.body = new Users(faker.internet().emailAddress(),"Female", faker.name().fullName(),"Inactive").getJson();
//        UsersGettersSetters users = new UsersGettersSetters();
//        users.setEmail(faker.internet().emailAddress());
//        users.setStatus("Active");
//        users.setGender("Female");
//        users.setName(faker.name().fullName());
//        super.body = users.getJson();
//        super.body = new JSONObject(new Gson().toJson(
//                UsersLombok.builder()
//                        .email(faker.internet().emailAddress())
//                        .name(faker.name().fullName())
//                        .gender("Female")
//                        .status("Active")
//                        .build()
//        ));
        super.POST();
    }
    // método para fazer update de varios valores
//    private Map<String, String> setJsoValues() {
//        jsonValues.put("email", faker.internet().emailAddress());
//        jsonValues.put("name", faker.name().fullName());
//        jsonValues.put("gender", "Female");
//        jsonValues.put("status", "Inactive");
//        return  jsonValues;
//    }

    @Entao("o usuario deve ser criado corretamente")
    public void o_usuario_deve_ser_criado_corretamente() {
        assertEquals(body.getString("email"), response.jsonPath().get("data.email"));// validaçao(resposta da requisição)
        assertEquals(body.getString("name"), response.jsonPath().get("data.name"));
    }

    @Entao("o status code do request deve ser {int}") // retorno do staus
    public void o_status_code_do_request_deve_ser(Integer statusEsperado) {
        assertEquals(statusEsperado, response.statusCode(), "Status code diferente do esperado!");
    }

}
