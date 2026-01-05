package university.service;

import org.junit.jupiter.api.Test;
import university.domain.Schedule;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleServiceTest {

    @Test
    void shouldAllowScheduleWhenThereIsNoConflict() {
        Schedule existing = new Schedule(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0), "A1"); // Horário existente

        Schedule newSchedule = new Schedule(DayOfWeek.MONDAY, LocalTime.of(11, 0), LocalTime.of(13, 0), "A2"); // Novo horário que não conflita. Como o horário existente termina às 11:00, o novo pode começar às 11:00

        List<Schedule> schedules = new ArrayList<>(); // Lista de horários existentes
        schedules.add(existing);

        ScheduleService service = new ScheduleService(); // Instancia responsável pela validação

        assertTrue(service.validateTimeSlots(schedules, newSchedule)); // Não existe conflito, logo deve devolver true
    }

    @Test
    void shouldRejectScheduleWhenThereIsConflict() {
        Schedule existing = new Schedule(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0), "A1"); 

        Schedule newSchedule = new Schedule(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0), "A2"); // Novo horário que se sobrepõe ao existente

        List<Schedule> schedules = new ArrayList<>();
        schedules.add(existing);

        ScheduleService service = new ScheduleService();

        assertFalse(service.validateTimeSlots(schedules, newSchedule)); // Como há sobreposição, o método deve devolver false
    }

    @Test
    void shouldAllowScheduleOnDifferentDay() {
        Schedule existing = new Schedule(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0), "A1"); // Horário existente numa segunda-feira

        Schedule newSchedule = new Schedule(DayOfWeek.TUESDAY, LocalTime.of(9, 0), LocalTime.of(11, 0), "A1"); // Novo horário no mesmo intervalo horário, mas noutro dia

        List<Schedule> schedules = List.of(existing);

        ScheduleService service = new ScheduleService();

        assertTrue(service.validateTimeSlots(schedules, newSchedule)); // Como o dia é diferente, não há conflito
    }
}
