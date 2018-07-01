package pl.sda.jira.calendar.persistency.inmemory;

import org.springframework.data.jpa.domain.Specification;
import pl.sda.jira.calendar.domain.model.Calendar;
import pl.sda.jira.calendar.domain.CalendarRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryCalendarRepository implements CalendarRepository {

    private Map<String, Calendar> calendarHashMap = new HashMap<>();


    @Override
    public void add(Calendar calendar) {
        calendarHashMap.put(calendar.getId(), calendar);
    }

    @Override
    public void remove(String id) {
        calendarHashMap.remove(id);
    }

    @Override
    public void replace(Calendar calendar) {
        calendarHashMap.replace(calendar.getId(), calendar);
    }

    @Override
    public List<Calendar> findAll(Specification<Calendar> specification) {
        return null;
    }

    @Override
    public boolean exists(String id) {
        return calendarHashMap.containsKey(id);
    }

    @Override
    public Calendar findBy(String id) {
        return calendarHashMap.get(id);
    }
}

