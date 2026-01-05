package university.service;

import org.junit.jupiter.api.Test;
import university.domain.Course;
import university.domain.Student;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PrerequisiteValidatorTest {

    @Test
    void shouldAllowEnrollmentWhenCourseHasNoPrerequisites() {
        Course course = new Course("MAT", "Math", 6, 30);
        Student student = new Student(new Date());

        PrerequisiteValidator validator = new PrerequisiteValidator(); // Instanciamos o validador de pré-requisitos para usar a função .checkEligibility

        assertTrue(validator.checkEligibility(student, course)); // Como o curso não tem pré-requisitos, a inscrição deve ser permitida
    }

    @Test
    void shouldRejectEnrollmentWhenCourseHasPrerequisites() {
        Course prerequisite = new Course("CS101", "Intro CS", 6, 30); // Criamos um curso pré-requisito
        Course advanced = new Course("CS201", "Advanced CS", 6, 30); // Criamos um curso avançado

        advanced.addPrerequisite(prerequisite); // Definimos o curso pré-requisito para o curso avançado. Sem o pré-requisito, a inscrição deve ser rejeitada

        Student student = new Student(new Date());

        PrerequisiteValidator validator = new PrerequisiteValidator();

        assertFalse(validator.checkEligibility(student, advanced));
    }
}
