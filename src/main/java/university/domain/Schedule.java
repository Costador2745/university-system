package university.domain;
import java.time.*;

public class Schedule {

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private String room;

    public Schedule(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, String room) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
    }

    public boolean hasConflict(Schedule other) // verifica se ha conflito de horarios
    {
        return dayOfWeek.equals(other.dayOfWeek) && startTime.isBefore(other.endTime) && endTime.isAfter(other.startTime);
    }
    public String getRoom() {
        return room;
    }
}