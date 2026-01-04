package university.service;

import university.domain.*;
import java.util.List;

public interface GradingStrategy {
    double calculate(List<Grade> grades);
}