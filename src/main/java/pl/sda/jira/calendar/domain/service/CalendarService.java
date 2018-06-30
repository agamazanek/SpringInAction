package pl.sda.jira.calendar.domain.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.sda.jira.calendar.domain.dto.CalendarDto;
import pl.sda.jira.calendar.domain.model.Calendar;
import pl.sda.jira.calendar.domain.CalendarRepository;
import pl.sda.jira.calendar.rest.exception.CalendarNotFoundException;


@Service
public class CalendarService {
    private final CalendarRepository calendarRepository;
    private final CalendarId calendarId;

    public CalendarService(@Qualifier("inMemoryCalendarRepository") CalendarRepository calendarRepository, CalendarId calendarId) {
        this.calendarRepository = calendarRepository;
        this.calendarId = calendarId;
    }

    public Calendar findBy(String id)  {
        if(calendarRepository.exists(id)) {
            return calendarRepository.findBy(id);
        } else {
            throw new CalendarNotFoundException(id);
        }
    }

    public String add(CalendarDto calendarDto) {
        String id = calendarId.createId();
        calendarRepository.add(new Calendar(id, calendarDto.getName()));
        return id;
    }

    public void remove(String id) {
        calendarRepository.remove(id);
    }

    public void update(String id, CalendarDto calendarDto) {
        if(calendarRepository.exists(id)) {
           Calendar calendar = calendarRepository.findBy(id);
           calendar.changeName(calendarDto.getName());
           calendarRepository.replace(calendar);
        } else {
            throw new CalendarNotFoundException(id);
        }
    }

}
