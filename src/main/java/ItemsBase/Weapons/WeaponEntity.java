package ItemsBase.Weapons;

import lombok.Getter;
import lombok.Setter;

public class WeaponEntity {

    @Getter
    public String weapon_type;
    @Getter
    private long weapon_id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Integer cost;
    @Getter
    @Setter
    private Double damage;
    @Getter
    @Setter
    private String damage_modifier;
    @Getter
    @Setter
    private Integer weight;
    @Getter
    @Setter
    private String properties;

    @Getter
    private Integer author_id;


    public WeaponEntity(Integer weapon_id,
                        String name,
                        Integer cost,
                        Double damage,
                        String damage_modifier,
                        Integer weight,
                        String properties,
                        String weapon_type,
                        Integer author_id) {
        this.weapon_id = weapon_id;
        this.name = name;
        this.cost = cost;
        this.damage = damage;
        this.damage_modifier = damage_modifier;
        this.weight = weight;
        this.properties = properties;
        this.author_id = author_id;
        for (WeaponType type : WeaponType.values()) {
            if (weapon_type.equals(type.toString())) this.weapon_type = type.toString();
        }
    }

    private enum WeaponType {
        martial_melee_weapons, martial_ranged_weapons, simple_ranged_weapons, simple_melee_weapons
    }

    @Override
    public String toString() {
        return "WeaponEntity{" +
                "weapon_type='" + weapon_type + '\'' +
                ", weapon_id=" + weapon_id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", damage=" + damage +
                ", damage_modifier='" + damage_modifier + '\'' +
                ", weight=" + weight +
                ", properties='" + properties + '\'' +
                ", author_id=" + author_id +
                '}';
    }
}
