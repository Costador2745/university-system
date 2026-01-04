package university.service;

import university.domain.*;
import java.util.List;

public class AverageGradingStrategy implements GradingStrategy {

    @Override
    public double calculate(List<Grade> grades) {
        if (grades.isEmpty()) return 0;

        double total = 0;
        for (Grade g : grades) {
            total += g.getValue();
        }
        return total / grades.size();
    }
}