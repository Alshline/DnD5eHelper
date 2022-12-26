package Authorization.Repositories;

import Authorization.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

    User findById(Long id);

    User findByUsername(String username);
}
