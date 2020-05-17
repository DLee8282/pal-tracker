package io.pivotal.pal.tracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private long currentID = 1L;
    private HashMap<Long,TimeEntry> storage = new HashMap<>();

    public InMemoryTimeEntryRepository() {

    }
    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry newTimeEntry = timeEntry;
        newTimeEntry.setId(currentID);
        storage.put(currentID,newTimeEntry);
        currentID++;
        return timeEntry;
    }
    public TimeEntry find(long userId) {
        return storage.get(userId);
    }

    public List<TimeEntry> list() {
        List<TimeEntry> listofTimeEntries = new ArrayList<>();
        for (Long key : storage.keySet()) {
            listofTimeEntries.add(storage.get(key));
        }
        return listofTimeEntries;
    }

    public void delete(long userId) {
        storage.remove(userId);
    }

    public TimeEntry update(long userId, TimeEntry timeEntry) {
        timeEntry.setId(userId);
        storage.replace(userId,timeEntry);
        TimeEntry getEntry = storage.get(userId);
        return getEntry;
    }
}
