package pl.sda.jira.calendar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.jira.calendar.domain.dto.CalendarDto;
import pl.sda.jira.calendar.queries.QueryCriteriaDto;
import pl.sda.jira.calendar.domain.service.CalendarQueryService;

import java.util.List;

@RestController
@RequestMapping("/calendars")
public class CalendarQueryController {
   private CalendarQueryService queryService;

    @Autowired public CalendarQueryController(CalendarQueryService queryService) {
        this.queryService = queryService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<CalendarDto> post(@ModelAttribute QueryCriteriaDto queryCriteriaDto) {
       // return  queryCriteriaDto.getName() + queryCriteriaDto.getValue() + queryCriteriaDto.getType();
        return queryService.findAllBy(queryCriteriaDto);
    }
}
