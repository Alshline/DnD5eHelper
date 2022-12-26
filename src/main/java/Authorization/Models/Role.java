package Authorization.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@NoArgsConstructor
@Document(collection = "Roles")
public class Role {

    @Id
    @Setter
    @Getter
    private String id;

    @Getter
    @Setter
    private String name;

    @Setter
    @Getter
    private Set<User> users;
}