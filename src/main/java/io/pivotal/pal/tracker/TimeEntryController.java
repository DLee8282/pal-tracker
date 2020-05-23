package io.pivotal.pal.tracker;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryController controller;
    private TimeEntryRepository repo = new InMemoryTimeEntryRepository();;
    private final DistributionSummary timeEntrySummary;
    private final Counter actionCounter;

    public TimeEntryController(TimeEntryRepository timeEntryRepository, MeterRegistry meterRegistry) {
        this.repo = timeEntryRepository;
        timeEntrySummary = meterRegistry.summary("timeEntry.summary");
        actionCounter = meterRegistry.counter("timeEntry.actionCounter");
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        TimeEntry createNewEntry = repo.create(timeEntry);
        actionCounter.increment();
        timeEntrySummary.record(repo.list().size());
        return new ResponseEntity<TimeEntry>(createNewEntry,HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{userId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long userId) {
            TimeEntry timeEntry = repo.find(userId);
            if (timeEntry == null) {
                return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);}
            else {
                actionCounter.increment();
                return new ResponseEntity<TimeEntry>(timeEntry,HttpStatus.OK);
            }

    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        actionCounter.increment();
        return new ResponseEntity<List<TimeEntry>>(repo.list(),HttpStatus.OK);
    }

    @PutMapping("/time-entries/{userId}")
    public ResponseEntity<TimeEntry> update(@PathVariable long userId, @RequestBody TimeEntry timeEntry) {
            TimeEntry newTimeEntry = repo.update(userId,timeEntry);
            if (newTimeEntry == null) {
                return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
            }
            else {
                actionCounter.increment();
                return new ResponseEntity<TimeEntry>(newTimeEntry,HttpStatus.OK);
            }
    }

    @DeleteMapping("/time-entries/{userId}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long userId) {
        repo.delete(userId);
        actionCounter.increment();
        timeEntrySummary.record(repo.list().size());
        return new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);
    }
}
