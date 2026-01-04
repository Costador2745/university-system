package university.service;

import university.domain.Student;

public interface GradeObserver {
    void onFinalGradeRecorded(Student student);
}
