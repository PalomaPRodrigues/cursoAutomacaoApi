package users;

import lombok.Builder;
import lombok.Data;

// Gera json e XML
@Data
@Builder
public class UsersLombok {
    // atributos da class
    private String email;
    private String gender;
    private String name;
    private String status;


}

