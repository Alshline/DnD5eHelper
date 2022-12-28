package Security.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "Roles")
public class Role {

    @Id
    @Getter
    @Setter
    @NotBlank
    private String id;
    @Getter
    @Setter
    @NotBlank
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
