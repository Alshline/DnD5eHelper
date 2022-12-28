package Security.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@NoArgsConstructor
@Document(collection = "Users")
public class User {

    @Id
    @Getter
    @Setter
    @NotBlank
    private String id;

    @Getter
    @Setter
    @NotBlank
    private String username;

    @Getter
    @Setter
    @NotBlank
    private String email;

    @Getter
    @Setter
    @NotBlank
    private String password;

    @Getter
    @Setter
    @NotBlank
    private String passwordConfirm;

    @DBRef
    @Getter
    @Setter
    @NotBlank
    private Set<Role> roles;

    public User(String username, String email, String password, String passwordConfirm, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.roles = roles;
    }
}
