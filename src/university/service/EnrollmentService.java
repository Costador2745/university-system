package university.service;

import university.domain.*;

import java.util.Date;

public class EnrollmentService {

    private PrerequisiteValidator prerequisiteValidator = new PrerequisiteValidator(); //instancia pra checkar pre-requisitos
    private ScheduleService scheduleService = new ScheduleService(); //instancia pra checkar horarios

    public boolean enrollStudent(Student student, Course course) {
        if (!prerequisiteValidator.checkEligibility(student, course)) //verifica se cumpre pre requisitos
        {
            return false;
        }
        Enrollment e = new Enrollment(new Date(), course); // cria uma nova inscrição com a data atual e curso escolhido
        student.addEnrollment(e); //adiciona a lista de inscrições do aluno
        return true;
    }

    public boolean cancelEnrollment(Student student, Course course) {
        return student.getEnrollments()
                .removeIf(e -> e.getCourse().equals(course)); //remove a inscrição cujo curso seja igual ao do argumento
    }
}