package steps;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import utils.JsonUtils;

import java.io.IOException;

public class UpdateJson {

    JsonUtils jsonUtils = new JsonUtils();

    @Test
    public void update() throws IOException, JSONException {
        JSONObject js = jsonUtils.parseJSONFile("json_update");
        System.out.println(js);
    }
}
