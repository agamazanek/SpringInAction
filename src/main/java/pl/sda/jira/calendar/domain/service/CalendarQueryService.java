package pl.sda.jira.calendar.domain.service;

import org.springframework.stereotype.Service;
import pl.sda.jira.calendar.domain.CalendarRepository;


@Service
public class CalendarQueryService {
   private final CalendarRepository calendarRepository;


    public CalendarQueryService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }
}

