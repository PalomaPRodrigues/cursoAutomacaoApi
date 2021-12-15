package users;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class UsersLombok {
    // atributos da class
    private String email;
    private String gender;
    private String name;
    private String status;
}
