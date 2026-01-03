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
        for (Enrollment e : student.getEnrollments()) //percorre todas as inscrições do aluno
        {
            for (Schedule s1 : e.getCourse().getSchedules()) //percorre todos os horarios do curso da inscrição
            {
                for (Schedule s2 : course.getSchedules()) //percorre todos os horarios do curso que o aluno quer se inscrever
                {
                    if (s1.hasConflict(s2)) //verifica se ha conflito entre os dois horarios
                    {
                    return false; // conflito encontrado
                    }
                }
            }
        }
        Enrollment e = new Enrollment(new Date(), course); // cria uma nova inscrição com a data atual e curso escolhido
        student.addEnrollment(e); //adiciona a lista de inscrições do aluno
        return true;
    }

    public boolean cancelEnrollment(Student student, Course course) {
        return student.getEnrollments()
                .removeIf(e -> e.getCourse().equals(course)); //remove a inscrição cujo curso seja igual ao do argumento
    }
    public ScheduleService getScheduleService() {
        return scheduleService;
    }
}