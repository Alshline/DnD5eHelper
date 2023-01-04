package ItemsBase.Repositories;

import ItemsBase.Entities.ArmorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmorRepository extends JpaRepository<ArmorEntity, Long> {
    public ArmorEntity getArmorEntityByName();
}
