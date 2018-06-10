package pl.sda.jira.calendar.domain;

import pl.sda.jira.calendar.domain.model.Calendar;

public interface CalendarRepository {
    void add(Calendar calendar);

    boolean exists(String id);

    Calendar findBy(String id);

    boolean existsForPersonWith(String personId);

    void remove(String id);

    void replace(Calendar calendar);
}
