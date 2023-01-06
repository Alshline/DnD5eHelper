package ItemsBase.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "Armors")
public class ArmorEntity {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "armor_id")
    private Long armor_id;

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
    @Column(name = "armor_class")
    private Integer armor_class;

    @Getter
    @Setter
    @Column(name = "armor_modifier")
    private String armor_modifier;

    @Getter
    @Setter
    @Column(name = "strength_require")
    private Integer strength_require;

    @Getter
    @Setter
    @Column(name = "stealth_modifier")
    private String stealth_modifier;

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

    public ArmorEntity(String name,
                       Integer cost,
                       Integer armor_class,
                       String armor_modifier,
                       Integer strength_require,
                       String stealth_modifier,
                       Integer weight,
                       String properties,
                       Integer author_id) {
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
                ", stealth_modifier='" + stealth_modifier + '\'' +
                ", weight=" + weight +
                ", properties='" + properties + '\'' +
                ", author_id=" + author_id +
                '}';
    }
}
