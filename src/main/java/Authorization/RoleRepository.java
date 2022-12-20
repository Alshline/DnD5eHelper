package Authorization;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<enumRole, String> {
    Optional<enumRole> findByName(enumRole name);
}
