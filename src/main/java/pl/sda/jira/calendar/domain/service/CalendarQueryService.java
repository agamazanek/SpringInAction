package pl.sda.jira.calendar.domain.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.sda.jira.calendar.domain.CalendarRepository;
import pl.sda.jira.calendar.domain.dto.CalendarDto;
import pl.sda.jira.calendar.domain.model.Calendar;
import pl.sda.jira.calendar.queries.QueryCriteriaDto;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CalendarQueryService {
   private final CalendarRepository calendarRepository;


    public CalendarQueryService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public List<CalendarDto>  findAllBy(QueryCriteriaDto queryCriteriaDto) {
        Specification<Calendar> specification = createSpecificationsFrom(queryCriteriaDto);
        List<Calendar> calendars = calendarRepository.findAll(specification);
        return asDtos(calendars);
    }

    private Specification<Calendar> createSpecificationsFrom(QueryCriteriaDto queryCriteriaDto) {
        switch (queryCriteriaDto.getType()) {
            case "equals":
                return ((root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(queryCriteriaDto.getColumnName()), (queryCriteriaDto.getValue())));
            case "like":
                return ((root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.like(root.get(queryCriteriaDto.getColumnName()),"%" + queryCriteriaDto.getValue()+ "%"));
            case "not":
                return ((root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.notEqual(root.get(queryCriteriaDto.getColumnName()), queryCriteriaDto.getValue()));
        }
        throw new IllegalArgumentException();

    }

    private List<CalendarDto> asDtos(List<Calendar> calendars) {
        return calendars.stream().map(Calendar::asDto).collect(Collectors.toList());
    }



}

