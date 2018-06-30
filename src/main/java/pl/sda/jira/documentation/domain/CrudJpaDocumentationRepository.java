package pl.sda.jira.documentation.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudJpaDocumentationRepository extends CrudRepository<Documentation , Long> {
}
