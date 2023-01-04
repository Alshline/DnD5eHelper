package ItemsBase.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Items")
public class ItemEntity {

    @Id
    @Column
    @Getter
    @Setter
    private Long item_id;

    @Getter
    @Setter
    @Column
    private String name;

    @Getter
    @Setter
    @Column
    private String properties;

    @Getter
    @Setter
    @Column
    private Long author_id;

    @Override
    public String toString() {
        return "ItemEntity{" +
                "item_id=" + item_id +
                ", name='" + name + '\'' +
                ", properties='" + properties + '\'' +
                ", author_id=" + author_id +
                '}';
    }
}
