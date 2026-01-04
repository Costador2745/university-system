package university.service;

import university.domain.*;

public class TeacherFactory {

    public static Teacher createTeacher(
            String id,
            String name,
            String email,
            String password,
            String department,
            String officeLocation) {

        return new Teacher(id, name, email, password, department, officeLocation);
    }
}
