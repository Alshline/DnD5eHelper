package AuthorizationWithJWTandRest.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Document(collection = "Users")
public class User {

    @Id
    @Getter
    @Setter
    private String id;

    @NotBlank
    @Size(max = 30)
    @Getter
    @Setter
    private String username;

    @NotBlank
    @Size(max = 30)
    @Getter
    @Setter
    private String password;

    @NotBlank
    @Size(max = 40)
    @Email
    @Getter
    @Setter
    private String email;

    @DBRef
    @Getter
    @Setter
    private Set<Role> roles = new HashSet<>();

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}