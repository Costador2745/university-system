package university.service;

import university.domain.*;

public class PrerequisiteValidator {

    public boolean checkEligibility(Student student, Course course) {
        return course.getPrerequisites().isEmpty(); // verificamos os pre-requisitos do curso estao vazios, no futuro tem de ser expandido
    }
}