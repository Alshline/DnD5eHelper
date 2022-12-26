package Authorization.Service;

import Authorization.Models.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
