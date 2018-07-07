package pl.sda.jira.calendar.domain.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.sda.jira.calendar.domain.CalendarRepository;
import pl.sda.jira.calendar.domain.dto.CalendarDto;
import pl.sda.jira.calendar.domain.model.Calendar;
import pl.sda.jira.calendar.domain.model.Name;
import pl.sda.jira.calendar.queries.QueryCriteriaDto;
import java.util.ArrayList;
import java.util.List;


@Service
public class CalendarQueryService {
   private final CalendarRepository calendarRepository;


    public CalendarQueryService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public List<CalendarDto> findAllBy(QueryCriteriaDto queryCriteriaDto) {
        Specification<Calendar> specification = createSpecificationsFrom(queryCriteriaDto);
        List<Calendar> calendars = calendarRepository.findAll(specification);
        return asDtos(calendars);
    }

    private List<CalendarDto> asDtos(List<Calendar> calendars) {
        List<CalendarDto> calendarsDto = new ArrayList<>();
        for (Calendar calendar : calendars) {
            calendar.asDto();
            calendarsDto.add(calendar.asDto());
        }
        return calendarsDto;
    }

    private Specification<Calendar> createSpecificationsFrom(QueryCriteriaDto queryCriteriaDto) {
        String columnName = queryCriteriaDto.getName();

        if ("name".equals(columnName)) {
            return ((root, criteriaQuery, criteriaBuilder)
                    -> criteriaBuilder.equal(root.get(columnName), new Name(queryCriteriaDto.getValue())));
        }

        return ((root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.equal(root.get(columnName), queryCriteriaDto.getValue()));
    }

}

