package pl.sda.jira.calendar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.jira.calendar.domain.CalendarRepository;

public class CalendarController {
    private final CalendarRepository calendarRepository;

    @Autowired
    public CalendarController(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public boolean existsForPerson(String personId) {
        return calendarRepository.existsFor(personId);
    }

}
