package university.service;

import university.domain.*;

public class GradeCalculator {

    public double calculateFinalGrade(Enrollment enrollment) {
        return enrollment.getGrades() //lista de notas da inscrição
                .stream()
                .mapToDouble(Grade::getValue) // comverte cada nota em valor numerico
                .average()// calcula a média dos valores
                .orElse(0);
    }
}
