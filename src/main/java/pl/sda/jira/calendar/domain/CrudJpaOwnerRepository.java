package pl.sda.jira.calendar.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.jira.calendar.domain.model.Owner;

@Repository
public interface CrudJpaOwnerRepository extends CrudRepository <Owner, Long>{
}
