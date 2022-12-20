package ItemsBase.Armors;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class ArmorEntity {
    @Getter
    private long armor_id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer cost;

    @Getter
    @Setter
    private Integer armor_class;

    @Getter
    @Setter
    private String armor_modifier;

    @Getter
    @Setter
    private Integer strength_require;

    @Getter
    @Setter
    private String stealth_modifier;

    @Getter
    @Setter
    private Integer weight;

    @Getter
    @Setter
    private String properties;

    @Getter
    private Integer author_id;

    public ArmorEntity(Integer armor_id,
                       String name,
                       Integer cost,
                       Integer armor_class,
                       String armor_modifier,
                       Integer strength_require,
                       String stealth_modifier,
                       Integer weight,
                       String properties,
                       Integer author_id){
        this.armor_id = armor_id;
        this.name = name;
        this.cost = cost;
        this.armor_class = armor_class;
        this.armor_modifier = armor_modifier;
        this.strength_require = strength_require;
        this.stealth_modifier = stealth_modifier;
        this.weight = weight;
        this.properties = properties;
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "ArmorEntity{" +
                "armor_id=" + armor_id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", armor_class=" + armor_class +
                ", armor_modifier='" + armor_modifier + '\'' +
                ", strength_require=" + strength_require +
                ", stealth_modifier=" + stealth_modifier +
                ", weight=" + weight +
                ", properties='" + properties + '\'' +
                ", author_id=" + author_id +
                '}';
    }
}
