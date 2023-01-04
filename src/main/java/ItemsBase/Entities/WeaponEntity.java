package ItemsBase.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "weapons")
public class WeaponEntity {


    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long weapon_id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "cost")
    private Integer cost;

    @Getter
    @Setter
    @Column(name = "damage")
    private Double damage;

    @Getter
    @Setter
    @Column(name = "damage_modifier")
    private String damage_modifier;

    @Getter
    @Setter
    @Column(name = "weight")
    private Integer weight;

    @Getter
    @Setter
    @Column(name = "properties")
    private String properties;

    @Getter
    @Setter
    @Column(name = "author_id")
    private Integer author_id;

    @Getter
    @Setter
    @Column(name = "weapon_type")
    private String weapon_type;

    public WeaponEntity(Long weapon_id,
                        String name,
                        Integer cost,
                        Double damage,
                        String damage_modifier,
                        Integer weight,
                        String properties,
                        Integer author_id,
                        String weapon_type) {
        this.weapon_id = weapon_id;
        this.name = name;
        this.cost = cost;
        this.damage = damage;
        this.damage_modifier = damage_modifier;
        this.weight = weight;
        this.properties = properties;
        this.author_id = author_id;
        for (WeaponType type : WeaponType.values()) {
            if (weapon_type.equals(type)) {
                this.weapon_type = type.name();
            }
        }
        this.weapon_type = weapon_type;
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
