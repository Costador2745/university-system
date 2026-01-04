package university.domain;

public class Advisor extends User {

    private String expertiseArea;

    public Advisor(String id, String name, String email, String password, String expertiseArea) {
        super(id, name, email, password);
        this.expertiseArea = expertiseArea;
    }
    public String getExpertiseArea() {
        return expertiseArea;
    }
}