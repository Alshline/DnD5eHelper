package AuthorizationWithJWTandRest.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Document(collection = "Roles")
public class Role {

    @Id
    @Setter
    @Getter
    private String id;

    @Getter
    @Setter
    private Roles_Enum name;

    public Role (Roles_Enum name){
        this.name = name;
    }
}