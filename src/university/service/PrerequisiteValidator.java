package university.service;

import university.domain.*;

public class PrerequisiteValidator {

    public boolean checkEligibility(Student student, Course course) {
        return course.getPrerequisites().isEmpty();
    }
}