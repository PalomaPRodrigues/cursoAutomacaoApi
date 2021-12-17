package utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;

// Classe que irá indicar o caminho e leitura do Json
// Class JsonUtil, serve para recuperar um json ou fazer o udpate
public class JsonUtils {
    // metodo que recebe o caminho que está o Json .o readAllBytes
    public JSONObject parseJSONFile(String json) throws IOException, JSONException {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/jsons/" + json + ".json")));
        return new JSONObject(content);
    }

    // metodo que update independente da chave
    public JSONObject updateJson(JSONObject obj, String keyMain, String newValue) throws Exception {

        Iterator iterator = obj.keys();// armazena todas chaves do json
        String key = null;
        while (iterator.hasNext()) { // pega primeira, segunda e terceira chave e sai comparando
            key = (String) iterator.next();

            if ((obj.optJSONArray(key) == null) && (obj.optJSONObject(key) == null)) {// verifica se varaiavél é nula
                if ((key.equals(keyMain))) { //verifica se igual o valor esperado
                    obj.put(key, newValue);
                    return obj;
                }
            }

            if (obj.optJSONObject(key) != null) { //verifica se possui um novo valor
                updateJson(obj.getJSONObject(key), keyMain, newValue);
            }

            if (obj.optJSONArray(key) != null) {
                JSONArray jArray = obj.getJSONArray(key);
                for (int i = 0; i < jArray.length(); i++) {
                    updateJson(jArray.getJSONObject(i), keyMain, newValue);
                }
            }
        }
        return obj;
    }
   //faz alterações de valores e permite setar mais de uma chave e valor
    public JSONObject setJsonValues(JSONObject json, Map<String, String> values) {
        JSONObject newJson = null;
        for (Map.Entry<String, String> entry: values.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            try{
                newJson = updateJson(json, key, value);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return newJson;

    }
}

