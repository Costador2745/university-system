package university.service;

import org.junit.jupiter.api.Test;
import university.domain.Course;
import university.domain.Enrollment;
import university.domain.Grade;
import university.domain.Student;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GPAServiceTest {

    @Test
    void shouldReturnZeroWhenStudentHasNoEnrollments() {
        Student student = new Student(new Date());

        GPAService gpaService = new GPAService();

        double gpa = gpaService.calculateGPA(student); // Estudante sem inscrições

        assertEquals(0.0, gpa);
    }

    @Test
    void shouldCalculateGPAFromMultipleEnrollments() {
        Student student = new Student(new Date());

        Course c1 = new Course("CS101", "Intro CS", 6, 30);
        Course c2 = new Course("CS201", "Advanced CS", 6, 30);

        Enrollment e1 = new Enrollment(new Date(), c1);
        Enrollment e2 = new Enrollment(new Date(), c2);

        e1.addGrade(new Grade(12, new Date()));
        e1.addGrade(new Grade(14, new Date())); // média = 13

        e2.addGrade(new Grade(16, new Date()));
        e2.addGrade(new Grade(18, new Date())); // média = 17

        student.addEnrollment(e1);
        student.addEnrollment(e2);

        GPAService gpaService = new GPAService();

        double gpa = gpaService.calculateGPA(student);

        assertEquals(15.0, gpa, 0.01); // média de 13 e 17
    }

    @Test
    void shouldUpdateStudentGPA() {
        Student student = new Student(new Date());

        Course course = new Course("CS101", "Intro CS", 6, 30);
        Enrollment enrollment = new Enrollment(new Date(), course);

        enrollment.addGrade(new Grade(10, new Date()));
        enrollment.addGrade(new Grade(20, new Date())); // média = 15

        student.addEnrollment(enrollment);

        GPAService gpaService = new GPAService();

        gpaService.updateStudentGPA(student);

        assertEquals(15.0, student.getGpa(), 0.01);
    }

    @Test
    void observerShouldUpdateGPAWhenFinalGradeIsRecorded() {
        Student student = new Student(new Date());

        Course course = new Course("CS101", "Intro CS", 6, 30);
        Enrollment enrollment = new Enrollment(new Date(), course);

        enrollment.addGrade(new Grade(14, new Date()));
        enrollment.addGrade(new Grade(16, new Date())); // média = 15

        student.addEnrollment(enrollment);

        GPAService gpaService = new GPAService();

        gpaService.onFinalGradeRecorded(student); // Simula a notificação do EnrollmentService

        assertEquals(15.0, student.getGpa(), 0.01);
    }
}
