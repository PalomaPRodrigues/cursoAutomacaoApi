package users;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

// Gera json e XML
@Data
@Builder
@Setter
public class UsersLombok {
    // atributos da class
    private String email;
    private String gender;
    private String name;
    private String status;


}

