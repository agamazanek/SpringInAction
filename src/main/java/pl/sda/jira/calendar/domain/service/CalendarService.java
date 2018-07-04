package pl.sda.jira.calendar.domain.service;

import org.springframework.stereotype.Service;
import pl.sda.jira.calendar.domain.dto.CalendarDto;
import pl.sda.jira.calendar.domain.model.Calendar;
import pl.sda.jira.calendar.domain.CalendarRepository;
import pl.sda.jira.calendar.rest.exception.CalendarAlreadyExistsException;
import pl.sda.jira.calendar.rest.exception.CalendarNotFoundException;


@Service
public class CalendarService {
    private final CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }
    public CalendarDto findBy(Long id)  {
        if(calendarRepository.exists(id)) {
            return calendarRepository.findBy(id).asDto();
        } else {
            throw new CalendarNotFoundException(id);
        }
    }

    public Long add(CalendarDto calendarDto) {
        if(calendarRepository.existsName(calendarDto.getName())) {
            throw new CalendarAlreadyExistsException(calendarDto.getName());
        }
        else {
            Calendar calendar = new Calendar(calendarDto);
            calendarRepository.add(calendar);
            return calendar.getId();
        }
    }

    public void remove(Long id) {
        if(calendarRepository.exists(id)) {
            calendarRepository.remove(id);
        } else {
            throw new CalendarNotFoundException(id);
        }
    }

    public void update(Long id, CalendarDto calendarDto) {
        if(calendarRepository.exists(id)) {
           Calendar calendar = calendarRepository.findBy(id);
           calendar.changeName(calendarDto.getName());
           calendarRepository.replace(calendar);
        } else {
            throw new CalendarNotFoundException(id);
        }
    }

}
