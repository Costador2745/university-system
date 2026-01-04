package university.domain;

import java.util.*;

public class Course {

    private String code;
    private String name;
    private int ects;
    private int maxStudents;
    private List<Schedule> schedules = new ArrayList<>(); // lista de horarios do curso
    private Set<Course> prerequisites = new HashSet<>(); // pode ter varios pre-requisitos e sao diferentes sempre

    public Course(String code, String name, int ects, int maxStudents) {
        this.code = code;
        this.name = name;
        this.ects = ects;
        this.maxStudents = maxStudents;
    }

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }
    public List<Schedule> getSchedules() {
        return schedules;
    }
    
    public void addPrerequisite(Course c) {
        prerequisites.add(c);
    }

    public Set<Course> getPrerequisites() {
        return prerequisites;
    }

    public int getEcts() {
        return ects;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public int getMaxStudents() {
        return maxStudents;
    }
}