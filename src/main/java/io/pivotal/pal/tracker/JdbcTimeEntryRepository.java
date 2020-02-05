package io.pivotal.pal.tracker;

import javax.sql.DataSource;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTimeEntryRepository implements  TimeEntryRepository {
        private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public JdbcTimeEntryRepository(DataSource dataSource) {

    }

    @Override
    public TimeEntry find(long query) {
        return null;
    }

    @Override
    public List<TimeEntry> list() {
        return null;
    }

    @Override
    public TimeEntry create(TimeEntry entry) {
        return null;
    }

    @Override
    public TimeEntry update(long param, TimeEntry timeEntry) {
        return null;
    }

    @Override
    public void delete(long query) {

    }
}
