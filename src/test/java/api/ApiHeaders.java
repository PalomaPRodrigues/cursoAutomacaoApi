package api;

import java.util.HashMap;
import java.util.Map;

// classe que irá intergrar a Api como automação, onde irá receber chave e valor(Map)
public class ApiHeaders {

    protected static Map<String, String> headers = new HashMap<>();

    // este método faz a chamada para api gorest
    public Map<String, String> gorestHeaders(String token) {
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", token);
        return headers;
    }

}
