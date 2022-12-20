package ItemsBase;

import java.util.List;

public interface ItemsRepositoryInterface<T> {
    List<T> findAll();

    List<T> findAllWeapons();

    List<T> findAllArmors();

    T findArmorById(Integer id);

    T findWeaponById(Integer id);

    T findArmorByName(String name);
    T findWeaponByName(String name);

    Integer save(T t);

    Integer update(T t);

    Integer deleteFromArmorsById(Integer author_id);
    Integer deleteFromWeaponsById(Integer author_id);
}
