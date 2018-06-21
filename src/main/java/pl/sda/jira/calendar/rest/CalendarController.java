package pl.sda.jira.calendar.rest;

import org.springframework.web.bind.annotation.*;
import pl.sda.jira.calendar.domain.dto.CalendarDto;
import pl.sda.jira.calendar.domain.model.Calendar;
import pl.sda.jira.calendar.domain.service.CalendarService;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    private CalendarService calendarService;


    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello hello!";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Calendar get(@PathVariable String id) {
        return calendarService.findBy(id);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        calendarService.remove(id);
    }

    @RequestMapping(path = "/{id}/{name}", method = RequestMethod.PUT)
    public void put(@PathVariable String id, @PathVariable CalendarDto name) {
        calendarService.update(id, name);}

    @RequestMapping(path = "/{name}", method = RequestMethod.POST)
    public String post(@PathVariable CalendarDto calendarDto){
        return calendarService.add(new CalendarDto(CalendarDto.Builder.aCalendar(calendarDto.getName())));
    }
}
