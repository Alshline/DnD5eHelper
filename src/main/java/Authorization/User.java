package Authorization;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

public class User {

    @Getter
    @Setter
    private String Id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String email;


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
