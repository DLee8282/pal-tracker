package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryController controller;
    private TimeEntryRepository repo = new InMemoryTimeEntryRepository();;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.repo = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        TimeEntry createNewEntry = repo.create(timeEntry);
        return new ResponseEntity<TimeEntry>(createNewEntry,HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{userId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long userId) {
            TimeEntry timeEntry = repo.find(userId);
            if (timeEntry == null) {
                return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);}
            else {
                return new ResponseEntity<TimeEntry>(timeEntry,HttpStatus.OK);
            }

    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<List<TimeEntry>>(repo.list(),HttpStatus.OK);
    }

    @PutMapping("/time-entries/{userId}")
    public ResponseEntity<TimeEntry> update(@PathVariable long userId, @RequestBody TimeEntry timeEntry) {
            TimeEntry newTimeEntry = repo.update(userId,timeEntry);
            if (newTimeEntry == null) {
                return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
            }
            else {
                return new ResponseEntity<TimeEntry>(newTimeEntry,HttpStatus.OK);
            }
    }

    @DeleteMapping("/time-entries/{userId}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long userId) {
        repo.delete(userId);
        return new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);
    }
}
