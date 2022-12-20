package Authorization;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "Users")
public class User {

    @Id
    @Getter
    @Setter
    private String Id;

    @NotBlank
    @Size(min = 6, max = 20)
    @Getter
    @Setter
    private String username;

    @NotBlank
    @Size(min = 8, max = 50)
    @Getter
    @Setter
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private Set<enumRole> enumRoles = new HashSet<>();

    public User() {

    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
