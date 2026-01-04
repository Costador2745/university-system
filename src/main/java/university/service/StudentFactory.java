package university.service;

import university.domain.*;
import java.util.Date;

public class StudentFactory {

    public static Student createStudent() {
        return new Student(new Date());
    }
}
