package ItemsBase.Repositories;

import ItemsBase.Entities.AccessoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoriesRepository extends JpaRepository<AccessoryEntity, Long> {
}
