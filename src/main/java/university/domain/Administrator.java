package university.domain;

public class Administrator extends User {

    private int accessLevel;

    public Administrator(String id, String name, String email, String password, int accessLevel) {
        super(id, name, email, password);
        this.accessLevel = accessLevel;
    }
    public int getAccessLevel() {
        return accessLevel;
    }
}
