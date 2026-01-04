package university.domain;

public class Teacher extends User {

    private String department;
    private String officeLocation;

    public Teacher(String id, String name, String email, String password, String department, String officeLocation) 
    {
        super(id, name, email, password);
        this.department = department;
        this.officeLocation = officeLocation;
    }
    public String getDepartment() {
        return department;
    }
    public String getOfficeLocation() {
        return officeLocation;
    }
}