package university.service;

import university.domain.*;

public class GradeCalculator {

    private GradingStrategy strategy;

    public GradeCalculator(GradingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateFinalGrade(Enrollment enrollment) {
        return strategy.calculate(enrollment.getGrades());
    }
}