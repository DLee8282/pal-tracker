package io.pivotal.pal.tracker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private HashMap<Long,TimeEntry> storage;

    public InMemoryTimeEntryRepository() {

    }

    public TimeEntry create(TimeEntry timeEntry) {
        long getID = timeEntry.getId(timeEntry);
        //storage.put(timeEntry.getId(timeEntry),timeEntry);
        return timeEntry;
    }
    public TimeEntry find(long query) {
        return storage.get(query);
    }

    public List<TimeEntry> list() {
        List<TimeEntry> listofTimeEntries = new ArrayList<>();
        for (Long key : storage.keySet()) {
            listofTimeEntries.add(storage.get(key));
        }
        return listofTimeEntries;
    }

    public void delete(long query) {
        storage.remove(query);
    }

    public TimeEntry update(long param, TimeEntry timeEntry) {
        TimeEntry gottenEntry = storage.put(param,timeEntry);
        return gottenEntry;
    }
}
