package users;

import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
// Gera json e XML
//define os atributos
public record UsersRecord(String email,
                          String name,
                          String gender,
                          String status)
{
    public JSONObject getJson() throws JSONException {
        return new JSONObject(new Gson().toJson(this));
    }
    // json para xml
    public String getXml(){
        return XML.toString(getJson());
    }
}
