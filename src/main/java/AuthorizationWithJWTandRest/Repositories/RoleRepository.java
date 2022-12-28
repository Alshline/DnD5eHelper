package AuthorizationWithJWTandRest.Repositories;

import AuthorizationWithJWTandRest.Models.Role;
import AuthorizationWithJWTandRest.Models.Roles_Enum;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(Roles_Enum name);
}
