package pl.sda.jira.calendar.domain;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.jira.calendar.domain.model.Calendar;

import java.util.Optional;

@Repository
public interface CrudJpaCalendarRepository extends CrudRepository<Calendar, Long>, JpaSpecificationExecutor<Calendar> {

    Optional<Calendar> findByName(@Param("name")String name);
}
