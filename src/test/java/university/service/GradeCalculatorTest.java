package university.service;

import org.junit.jupiter.api.Test;
import university.domain.Course;
import university.domain.Enrollment;
import university.domain.Grade;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    @Test
    void shouldCalculateAverageFinalGrade() {
        Course course = new Course("CS101", "Intro CS", 6, 30); // Criamos um curso
        Enrollment enrollment = new Enrollment(new Date(), course); // Criamos uma inscrição para o curso

        //Adicionamos notas à inscrição
        enrollment.addGrade(new Grade(10, new Date()));
        enrollment.addGrade(new Grade(14, new Date()));
        enrollment.addGrade(new Grade(16, new Date()));

        GradingStrategy averageStrategy = grades -> // Estratégia que calcula a média das notas
                grades.stream() //busca as notas
                      .mapToDouble(Grade::getValue) //converte as notas para double
                      .average() //calcula a média
                      .orElse(0.0); //se não houver notas, retorna 0.0

        GradeCalculator calculator = new GradeCalculator(averageStrategy); //Calculador de notas usando a estratégia definida

        double finalGrade = calculator.calculateFinalGrade(enrollment);

        assertEquals(13.33, finalGrade, 0.01); // A média esperada é aproximadamente 13.33
    }

    @Test
    void shouldReturnZeroWhenNoGradesExist() {
        // Inscrição sem notas
        Course course = new Course("CS101", "Intro CS", 6, 30);
        Enrollment enrollment = new Enrollment(new Date(), course);

        GradingStrategy averageStrategy = grades ->
                grades.stream()
                      .mapToDouble(Grade::getValue)
                      .average()
                      .orElse(0.0);

        GradeCalculator calculator = new GradeCalculator(averageStrategy);

        double finalGrade = calculator.calculateFinalGrade(enrollment);

        assertEquals(0.0, finalGrade);
    }

    @Test
    void shouldUseProvidedStrategy() {
        Course course = new Course("CS101", "Intro CS", 6, 30);
        Enrollment enrollment = new Enrollment(new Date(), course);

        enrollment.addGrade(new Grade(8, new Date()));
        enrollment.addGrade(new Grade(20, new Date()));

        // Strategy personalizada (ex.: nota máxima)
        GradingStrategy maxStrategy = grades ->
                grades.stream()
                      .mapToDouble(Grade::getValue)
                      .max() // pega a nota máxima
                      .orElse(0.0);

        GradeCalculator calculator = new GradeCalculator(maxStrategy); // Calculador de notas usando a estratégia personalizada

        double finalGrade = calculator.calculateFinalGrade(enrollment); // Deve retornar a nota máxima

        assertEquals(20.0, finalGrade);
    }
}
