package pl.sda.jira.calendar.domain;

import org.springframework.data.jpa.domain.Specification;
import pl.sda.jira.calendar.domain.model.Calendar;

import java.util.List;

public interface CalendarRepository {
    void add(Calendar calendar);

    boolean exists(Long id);

    Calendar findBy(Long id);

    void remove(Long id);

    void replace(Calendar calendar);

    List<Calendar> findAll(Specification<Calendar> specification);

    boolean existsName(String name);

}
