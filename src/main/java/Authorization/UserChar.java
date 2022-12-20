package Authorization;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UsersChar")
public class UserChar {

    @Id
    @Getter
    @Setter
    String Id;

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    String description;

    @Getter
    @Setter
    Double price;

    @Getter
    @Setter
    String image;

    public UserChar() {

    }

    public UserChar(String name, String description, Double price, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }
}
