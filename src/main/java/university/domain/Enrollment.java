package university.domain;

import java.util.*;

public class Enrollment {

    private Date enrollmentDate;
    private double finalGrade;
    private Course course;
    private List<Grade> grades = new ArrayList<>(); // uma inscrição pode ter varias notas

    public Enrollment(Date enrollmentDate, Course course) {
        this.enrollmentDate = enrollmentDate;
        this.course = course;
    }

    public void addGrade(Grade g) {
        grades.add(g);
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public Course getCourse() {
        return course;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }
    public double getFinalGrade() {
        return finalGrade;
    }
    public Date getEnrollmentDate() {
        return enrollmentDate;
    }
}