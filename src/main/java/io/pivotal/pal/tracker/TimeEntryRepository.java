package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository {
    public TimeEntry find(long query);

    public List<TimeEntry> list();

    public TimeEntry create(TimeEntry entry);

    public TimeEntry update(long param, TimeEntry timeEntry);

    public void delete(long query);
}
