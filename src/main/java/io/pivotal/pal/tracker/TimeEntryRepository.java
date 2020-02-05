package io.pivotal.pal.tracker;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TimeEntryRepository {
    public TimeEntry find(long query);

    public List<TimeEntry> list();

    public TimeEntry create(TimeEntry entry);

    public TimeEntry update(long id, TimeEntry timeEntry);

    public void delete(long query);
}
