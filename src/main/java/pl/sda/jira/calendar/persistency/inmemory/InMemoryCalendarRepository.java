package pl.sda.jira.calendar.persistency.inmemory;

import pl.sda.jira.calendar.domain.Calendar;
import pl.sda.jira.calendar.domain.CalendarRepository;

import java.util.List;

public class InMemoryCalendarRepository implements CalendarRepository {

    private final List<Calendar> calendars;

    public InMemoryCalendarRepository (List <Calendar> calendars) {
        this.calendars = calendars;
    }
    private boolean added = false;

    public void add(Calendar calendar) {
        added = true;
    }

    public boolean existsForPersonWith(String personId) {
        return added;
    }

    public List<Calendar> getAll() {
        return calendars;
    }


    private boolean exists = false;

}
