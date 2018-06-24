package pl.sda.jira.template;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudJpaTemplateRepository extends CrudRepository<Template, String> {
}
