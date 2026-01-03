package university.domain;

public class Assessment {

    private String name;
    private double weight;
    private double minGrade;

    public Assessment(String name, double weight, double minGrade) {
        this.name = name;
        this.weight = weight;
        this.minGrade = minGrade;
    }

    public double getWeight() {
        return weight;
    }

    public double getMinGrade() {
        return minGrade;
    }
    public String getName() {
        return name;
    }
}
