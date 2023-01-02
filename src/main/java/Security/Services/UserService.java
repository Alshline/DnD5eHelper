package Security.Services;

import Security.Entities.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
