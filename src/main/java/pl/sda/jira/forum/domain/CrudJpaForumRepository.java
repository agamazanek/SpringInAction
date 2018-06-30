package pl.sda.jira.forum.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudJpaForumRepository extends CrudRepository<Forum, String> {
}
