package utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Classe que irá indicar o caminho e leitura do Json
public class JsonUtils {
    // metodo que recebe o caminho que está o Json .o readAllBytes
    public JSONObject parseJSONFile(String json) throws IOException, IOException, JSONException {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/jsons/"+ json +".json")));
        return new JSONObject(content);
    }
}
