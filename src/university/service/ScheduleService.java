package university.service;

import university.domain.*;
import java.util.List;

public class ScheduleService {

    public boolean validateTimeSlots(List<Schedule> schedules, Schedule newSchedule) {
        return schedules.stream().noneMatch(s -> s.hasConflict(newSchedule));
    }
}