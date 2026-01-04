package university.service;

import university.domain.*;
import java.util.List;

public class ScheduleService {

    public boolean validateTimeSlots(List<Schedule> schedules, Schedule newSchedule) 
    {
        return schedules.stream() //percorre todos os horarios
        .noneMatch(s -> s.hasConflict(newSchedule)); //verifica se nenhum entra em conflito com o outro
    }
}