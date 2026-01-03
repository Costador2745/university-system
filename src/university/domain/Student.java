package university.domain;
import java.util.*;

public class Student {

    private Date registrationDate;
    private double gpa;
    private int totalECTS;
    private List<Enrollment> enrollments = new ArrayList<>(); // pode ter multiplas disciplinas

    public Student(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void addEnrollment(Enrollment e) {
        enrollments.add(e);
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getTotalECTS() {
        return totalECTS;
    }

    public void addECTS(int ects) {
        this.totalECTS += ects;
    }
    public Date getRegistrationDate() {
        return registrationDate;
    }
}