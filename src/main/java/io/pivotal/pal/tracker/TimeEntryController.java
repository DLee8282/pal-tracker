package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryController controller;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {

    }
    public ResponseEntity<TimeEntry> create(TimeEntry timeEntry) {
        return null;
    }
    public ResponseEntity<TimeEntry> read(long query) {
        return null;
    }

    public ResponseEntity<List<TimeEntry>> list() {
        return null;
    }
    public ResponseEntity<TimeEntry> update(long param, TimeEntry timeEntry) {
        return null;
    }
    public ResponseEntity<TimeEntry> delete(long query) {
        return null;
    }
}
