package io.pivotal.pal.tracker;

import java.sql.Time;
import java.time.LocalDate;

public class TimeEntry {
    private long id = 1L;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry() {

    }
    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this. projectId = projectId;
        this.date = date;
        this.hours = hours;
        this.userId = userId;
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this. projectId = projectId;
        this.date = date;
        this.hours = hours;
        this.userId = userId;
    }

    public long getId(TimeEntry timeEntry) {
        return  timeEntry.id;
    }

    public long getId() {
        return this.id;
    }


}
