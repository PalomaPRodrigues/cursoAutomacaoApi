package users;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.XML;

// Gera json e XML
public class UsersGettersSetters {
    // atributos da class
    private String email;
    private String gender;
    private String name;
    private String status;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // converte o objeto do tipo class para obejto do tipo json
    public JSONObject getJson() {
        return new JSONObject(new Gson().toJson(this));
    }
    // converte o objeto do tipo json para objeto do tipo xml
    public String getXml(){return XML.toString(getJson());
    }
}
