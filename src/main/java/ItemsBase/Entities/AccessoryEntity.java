package ItemsBase.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Accessories")
public class AccessoryEntity {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accessory_id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String properties;

    @Getter
    @Setter
    private String author_id;

    @Override
    public String toString() {
        return "AccessoryEntity{" +
                "accessory_id=" + accessory_id +
                ", name='" + name + '\'' +
                ", properties='" + properties + '\'' +
                ", author_id='" + author_id + '\'' +
                '}';
    }
}
