package university.domain;


public class Student extends User{
    private int registrationDate;
    private double gpa;
    private int totalEcts;
    
    public int getRegistrationDate() {
        return registrationDate;
    }
    public int gettotalEcts() {
        return totalEcts;
    }
    public double getGpa() {
        return gpa;
    }
}