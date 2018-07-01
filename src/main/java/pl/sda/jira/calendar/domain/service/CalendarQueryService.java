package pl.sda.jira.calendar.domain.service;

import pl.sda.jira.calendar.domain.dto.QueryCriteriaDto;

public class CalendarQueryService {
    QueryCriteriaDto queryCriteriaDto;


    public String read(String value) {
        //return ( queryCriteriaDto.getValue().equals(value));
        return value;
    }

}
