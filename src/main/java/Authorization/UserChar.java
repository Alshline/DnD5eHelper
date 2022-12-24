package Authorization;

import lombok.Getter;
import lombok.Setter;

public class UserChar {

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
