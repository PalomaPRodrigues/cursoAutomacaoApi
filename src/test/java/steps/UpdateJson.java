package steps;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import utils.JsonUtils;

import java.io.IOException;
// Metodo de test, porém essa class é utilizada para
public class UpdateJson {

    JsonUtils jsonUtils = new JsonUtils();
// esse test só chama o json update e altera o valor do json
    @Test
    public void updateJson() throws Exception {
        JSONObject js = jsonUtils.parseJSONFile("json_update");
        // imprime na tela ,para validar que realmente está imprimindo
        System.out.println(jsonUtils.updateJson(js, "type","10"));

    }

}
