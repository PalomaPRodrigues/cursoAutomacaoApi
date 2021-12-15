package users;

import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

public record UsersRecord(String email,
                          String gender,
                          String name,
                          String status)
{
    public JSONObject getJson() throws JSONException {
        return new JSONObject(new Gson().toJson(this));
    }
}
