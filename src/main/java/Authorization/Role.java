package Authorization;

public class Role {
    private String id;

    private enumRole name;

    public Role() {

    }

    public Role(enumRole name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public enumRole getName() {
        return name;
    }

    public void setName(enumRole name) {
        this.name = name;
    }
}
