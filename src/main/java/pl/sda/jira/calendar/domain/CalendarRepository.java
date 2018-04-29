package pl.sda.jira.calendar.domain;

import java.util.List;

public interface CalendarRepository {


    void add(Calendar calendar);

    boolean existsForPersonWith(String personId);
}
