package ItemsBase.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
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
