package users;

import com.google.gson.Gson;
import org.json.JSONObject;

public class UserConstutor {

    // atributos da class
    private String email;
    private String gender;
    private String name;
    private String status;

    // construtor recebe os parametros email, gender, name, status
    public UserConstutor(String email, String gender, String name, String status) {
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.status = status;
    }

    // converte o objeto do tipo class para obejto do tipo json
    public JSONObject getJson() {
        return new JSONObject(new Gson().toJson(this));
    }

}
