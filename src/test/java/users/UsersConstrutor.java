package users;

import com.google.gson.Gson;
import org.json.JSONObject;

import java.util.Objects;

// Gera json e XML
public class UsersConstrutor {

    // atributos da class
    private String email;
    private String gender;
    private String name;
    private String status;

    // construtor recebe os parametros email, gender, name, status
    public UsersConstrutor(String email, String gender, String name, String status) {
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.status = status;
    }

    // converte o objeto do tipo class para obejto do tipo json
    public JSONObject getJson() {
        return new JSONObject(new Gson().toJson(this));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersConstrutor that = (UsersConstrutor) o;
        return Objects.equals(email, that.email)
                && Objects.equals(gender, that.gender)
                && Objects.equals(name, that.name)
                && Objects.equals(status, that.status);
    }

    @Override
    public String toString() {
        return "UsersConstrutor{" +
                "email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
