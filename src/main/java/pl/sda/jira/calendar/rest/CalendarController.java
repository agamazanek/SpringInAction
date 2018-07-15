package pl.sda.jira.calendar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.jira.calendar.domain.dto.CalendarDto;
import pl.sda.jira.calendar.domain.service.CalendarService;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    private CalendarService calendarService;

    @Autowired
    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CalendarDto get(@PathVariable Long id) {
        return calendarService.findBy(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        calendarService.remove(id);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void put(@PathVariable Long id, @ModelAttribute CalendarDto calendarDto) {
        calendarService.update(id, calendarDto);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Long post(@ModelAttribute CalendarDto calendarDto) {
        return calendarService.add(calendarDto);
    }

}

