package ItemsBase.Repositories;

import ItemsBase.Entities.WeaponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponsRepository extends JpaRepository<WeaponEntity, Long> {

}