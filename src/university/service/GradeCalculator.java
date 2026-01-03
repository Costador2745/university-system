package university.service;

import university.domain.*;

public class GradeCalculator {

    public double calculateFinalGrade(Enrollment enrollment) {
        double total = 0;
        double totalPeso = 0;

        for (Grade g : enrollment.getGrades()) //percorre todas as notas da inscrição
        {
            total += g.getValue(); // soma o valor da nota á variável total
            totalPeso++; // incrementa o peso (número de notas)
        }

        if (totalPeso == 0) {
        return 0;
        }

        return total / totalPeso; //calcula a média de notas dividindo o total pelo peso
    }
}
