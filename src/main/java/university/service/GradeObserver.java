package university.service;

import university.domain.Student;

public interface GradeObserver //aplicação do padrão Observer
{
    void onFinalGradeRecorded(Student student);
}
