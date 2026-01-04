package university.service;

import university.domain.*;


public class GPAService implements GradeObserver{
    
    private GradeCalculator calculator = new GradeCalculator(new AverageGradingStrategy());

    @Override
    public void onFinalGradeRecorded(Student student) {
        updateStudentGPA(student);
    }

    public double calculateGPA(Student student) 
    {
        return student.getEnrollments()
                .stream()
                .mapToDouble(e -> calculator.calculateFinalGrade(e)) //Converte cada inscrição em nota final
                .average() // calcula a média das notas finais
                .orElse(0);// se não houver notas, retorna 0
    }

    public void updateStudentGPA(Student student) //metodo pra atualizar o GPA
    {
        student.setGpa(calculateGPA(student));
    }
}

