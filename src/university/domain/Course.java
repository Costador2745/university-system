package university.domain;

public class Course {
    String code;
    String name;
    int maxStudents;
    int ects;

    public boolean isAvailable() {
        return true;
    }
}