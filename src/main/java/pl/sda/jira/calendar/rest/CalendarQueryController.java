package pl.sda.jira.calendar.rest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.jira.calendar.domain.dto.QueryCriteriaDto;
import pl.sda.jira.calendar.domain.service.CalendarQueryService;

@RestController
@RequestMapping("/calendars")
public class CalendarQueryController {
    private CalendarQueryService queryService;

    @RequestMapping(method = RequestMethod.POST)
    public String post(@ModelAttribute QueryCriteriaDto queryCriteriaDto) {
        return  queryCriteriaDto.getName() + queryCriteriaDto.getValue() + queryCriteriaDto.getType();
    }



}
