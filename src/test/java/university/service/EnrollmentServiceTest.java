package university.service;

import org.junit.jupiter.api.Test;
import university.domain.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EnrollmentServiceTest {

    @Test
    void shouldEnrollStudentWhenNoConflictsAndNoPrerequisites() {
        Student student = new Student(new Date()); // Criamos um estudante sem inscrições prévias

        Course course = new Course("CS101", "Intro CS", 6, 30); // Criamos um curso sem pré-requisitos
        course.addSchedule(new Schedule(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0), "A1")); // Adicionamos um horário ao curso

        EnrollmentService service = new EnrollmentService(); // Instanciamos o serviço de inscrição para ter acesso a função .enrollStudent

        boolean enrolled = service.enrollStudent(student, course); // Tentamos inscrever o estudante no curso

        assertTrue(enrolled); // A inscrição deve ser bem-sucedida
        assertEquals(1, student.getEnrollments().size()); // O estudante deve ter uma inscrição
        assertEquals(course, student.getEnrollments().get(0).getCourse()); // A inscrição deve ser para o curso correto
    }

    @Test
    void shouldRejectEnrollmentWhenScheduleConflicts() {
        Student student = new Student(new Date());

        Course existingCourse = new Course("CS101", "Intro CS", 6, 30);
        existingCourse.addSchedule(new Schedule(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0), "A1"));

        Course newCourse = new Course("CS201", "Advanced CS", 6, 30);
        newCourse.addSchedule(new Schedule(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0), "A2"));

        student.addEnrollment(new Enrollment(new Date(), existingCourse)); // Inscreve o estudante no curso existente

        EnrollmentService service = new EnrollmentService(); // Instanciamos o serviço de inscrição para ter acesso a função .enrollStudent

        boolean enrolled = service.enrollStudent(student, newCourse); // Tentamos inscrever o estudante no novo curso com conflito de horário

        assertFalse(enrolled); // A inscrição deve ser rejeitada devido ao conflito de horário
        assertEquals(1, student.getEnrollments().size()); // O estudante deve continuar com apenas uma inscrição
    }

    @Test
    void shouldCancelEnrollmentSuccessfully() {
        Student student = new Student(new Date());

        Course course = new Course("CS101", "Intro CS", 6, 30);
        Enrollment enrollment = new Enrollment(new Date(), course);

        student.addEnrollment(enrollment); // Inscreve o estudante no curso

        EnrollmentService service = new EnrollmentService(); // Instanciamos o serviço de inscrição para ter acesso a função .cancelEnrollment

        boolean removed = service.cancelEnrollment(student, course); // Tentamos cancelar a inscrição do estudante no curso

        assertTrue(removed); // O cancelamento deve ser bem-sucedido
        assertTrue(student.getEnrollments().isEmpty()); // O estudante não deve ter mais inscrições
    }

    @Test
    void shouldNotifyObserverWhenFinalGradeIsRecorded() {
        Student student = new Student(new Date());

        GPAService gpaService = new GPAService(); // Serviço de GPA que atua como observador
        EnrollmentService enrollmentService = new EnrollmentService(); // Serviço que notifica observadores

        enrollmentService.addObserver(gpaService); // Registramos o GPAService como observador no EnrollmentService
                                                   // Assim, sempre que uma nota final for registrada, o GPAService será notificado para atualizar o GPA do estudante

        Course course = new Course("CS101", "Intro CS", 6, 30);
        Enrollment enrollment = new Enrollment(new Date(), course); // Criamos uma inscrição para o curso

        enrollment.addGrade(new Grade(14, new Date()));
        enrollment.addGrade(new Grade(16, new Date())); // média = 15

        student.addEnrollment(enrollment); // Adicionamos a inscrição ao estudante

        enrollmentService.recordFinalGrade(student); // Registramos a nota final, o que deve notificar o GPAService
                                                     // EnrollmentService chama notifyFinalGradeRecorded, que vai percorrer a lista de observadores 
                                                     // e chamar onFinalGradeRecorded no GPAService que depois executa updateStudentGPA

        assertEquals(15.0, student.getGpa(), 0.01); // O GPA do estudante deve ser atualizado para 15.0
    }
}
