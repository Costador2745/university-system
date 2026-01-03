package university.domain;

import java.util.Date;

public class AcademicRecord {

    private Date issueDate;

    public AcademicRecord(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String generateTranscript() {
        return "Histórico académico gerado em " + issueDate;
    }
}