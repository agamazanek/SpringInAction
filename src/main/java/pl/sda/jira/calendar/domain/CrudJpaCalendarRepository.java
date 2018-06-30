package pl.sda.jira.calendar.domain;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.jira.calendar.domain.model.Calendar;

import java.util.BitSet;
import java.util.List;
import java.util.Optional;

@Repository
public interface CrudJpaCalendarRepository extends CrudRepository<Calendar, String>{

    List<Calendar> findByName(String name);

    int countByOwner(String owner);

    Optional<Calendar> findFirstByNameOrOwner(String name, String owner);

    Optional<Calendar> findFirstByNameAndOwner(String name, String owner);

    @Query("select name from Calendar c where c.owner=:owner")
    List<String> findCalendarByOwner(@Param("owner") String owner);

    @Query("select owner from Calendar c where c.name=:name")
    List<String> findOwnerByCalendarName(@Param ("name") String name);
}
