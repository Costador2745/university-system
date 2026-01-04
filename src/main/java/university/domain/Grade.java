package university.domain;

import java.util.Date;

public class Grade {

    private double value;
    private Date dateRegistered;

    public Grade(double value, Date dateRegistered) {
        this.value = value;
        this.dateRegistered = dateRegistered;
    }

    public double getValue() {
        return value;
    }
    public Date getDateRegistered() {
        return dateRegistered;
    }
}