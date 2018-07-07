package pl.sda.jira.documentation.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudJpaAuthorRepository extends CrudRepository<Author, Long> {
}
