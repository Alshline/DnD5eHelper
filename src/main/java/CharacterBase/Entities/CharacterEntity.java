package CharacterBase.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Document(collection = "Characters")
public class CharacterEntity {

    @Id
    @NotBlank
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    @NotBlank
    private String char_name;

    @Getter
    @Setter
    @NotBlank
    private Integer strength;

    @Getter
    @Setter
    @NotBlank
    private Integer dexterity;

    @Getter
    @Setter
    @NotBlank
    private Integer constitution;

    @Getter
    @Setter
    @NotBlank
    private Integer intelligence;

    @Getter
    @Setter
    @NotBlank
    private Integer wisdom;

    @Getter
    @Setter
    @NotBlank
    private Integer charisma;

    @Getter
    @Setter
    private String author_id;

    @Getter
    @Setter
    private List<String> itemsList;

    public CharacterEntity(String char_name,
                           Integer strength,
                           Integer dexterity,
                           Integer constitution,
                           Integer intelligence,
                           Integer wisdom,
                           Integer charisma,
                           String author_id,
                           List<String> itemsList) {
        this.char_name = char_name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.author_id = author_id;
        this.itemsList = itemsList;
    }
}
