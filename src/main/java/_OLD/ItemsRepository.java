package _OLD;

import ItemsBase.Entities.ArmorEntity;
import ItemsBase.Entities.WeaponEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ItemsRepository implements ItemsRepositoryInterface {

    JdbcTemplate jdbcTemplate;

    Mapper mapper;

    public ItemsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List findAll() {
        return jdbcTemplate.query("select * from weapons,armors", mapper);
    }

    @Override
    public List findAllWeapons() {
        return jdbcTemplate.query("select * from weapons", mapper);
    }

    @Override
    public List findAllArmors() {
        return jdbcTemplate.query("select * from armors", mapper);
    }

    @Override
    public Object findArmorById(Integer id) {
        return jdbcTemplate.queryForObject("select * from armors where armor_id = ?", mapper, id);
    }

    @Override
    public Object findWeaponById(Integer id) {
        return jdbcTemplate.queryForObject("select * from weapons where weapon_id = ?", mapper, id);
    }

    @Override
    public Object findArmorByName(String name) {
        return jdbcTemplate.queryForObject("select * from armors where name = ?", mapper, name);
    }

    @Override
    public Object findWeaponByName(String name) {
        return jdbcTemplate.queryForObject("select * from weapons where name = ?", mapper, name);
    }

    @Override
    public Integer save(Object o) {
        if (o.getClass().equals(WeaponEntity.class)) {
            WeaponEntity weaponEntity = (WeaponEntity) o;
            return jdbcTemplate.update("insert into weapons " +
                            "(name, cost, damage, damage_modifier, weight, properties, weapon_type) " +
                            "values ( ?,?,?,?,?,?,? )",
                    weaponEntity.getName(),
                    weaponEntity.getCost(),
                    weaponEntity.getDamage(),
                    weaponEntity.getDamage_modifier(),
                    weaponEntity.getWeight(),
                    weaponEntity.getProperties(),
                    weaponEntity.getWeapon_type());
        } else if (o.getClass().equals(ArmorEntity.class)) {
            ArmorEntity armorEntity = (ArmorEntity) o;
            return jdbcTemplate.update("insert into armors " +
                            "(name, cost, armor_class, armor_modifier, strength_require, stealth_modifier, weight, properties) " +
                            "values ( ?,?,?,?,?,?,?,? )",
                    armorEntity.getName(),
                    armorEntity.getCost(),
                    armorEntity.getArmor_class(),
                    armorEntity.getArmor_modifier(),
                    armorEntity.getStrength_require(),
                    armorEntity.getStealth_modifier(),
                    armorEntity.getWeight(),
                    armorEntity.getProperties());
        }
        return -1;
    }

    @Override
    public Integer update(Object o) {
        if (o.getClass().equals(WeaponEntity.class)) {
            WeaponEntity weaponEntity = (WeaponEntity) o;
            return jdbcTemplate.update("update weapons set " +
                            "name = ?, " +
                            "cost = ?, " +
                            "damage = ?, " +
                            "damage_modifier = ?, " +
                            "weight = ?, " +
                            "properties = ?, " +
                            "weapon_type = ? " +
                            "where weapon_id = ?",
                    weaponEntity.getName(),
                    weaponEntity.getCost(),
                    weaponEntity.getDamage(),
                    weaponEntity.getDamage_modifier(),
                    weaponEntity.getWeight(),
                    weaponEntity.getProperties(),
                    weaponEntity.getWeapon_type(),
                    weaponEntity.getWeapon_id());
        } else if (o.getClass().equals(ArmorEntity.class)) {
            ArmorEntity armorEntity = (ArmorEntity) o;
            return jdbcTemplate.update("update armors set " +
                            "name = ?, " +
                            "cost = ?, " +
                            "armor_class = ?, " +
                            "armor_modifier = ?, " +
                            "strength_require = ?, " +
                            "stealth_modifier = ?, " +
                            "weight = ?, " +
                            "properties = ? " +
                            "where armor_id = ?",
                    armorEntity.getName(),
                    armorEntity.getCost(),
                    armorEntity.getArmor_class(),
                    armorEntity.getArmor_modifier(),
                    armorEntity.getStrength_require(),
                    armorEntity.getStealth_modifier(),
                    armorEntity.getWeight(),
                    armorEntity.getProperties(),
                    armorEntity.getArmor_id());
        }
        return -1;
    }

    @Override
    public Integer deleteFromArmorsById(Integer armor_id) {
        return jdbcTemplate.update("delete from armors where armor_id = ?", armor_id);
    }

    @Override
    public Integer deleteFromWeaponsById(Integer weapon_id) {
        return jdbcTemplate.update("delete from weapons where weapon_id = ?", weapon_id);
    }
}

