package pl.sda.jira.template;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface TemplateRepository {
    Template getBy(String id);

    void remove(String id);

    Template create(Template template);

    Template update(Template template);

    List<Template> findAll(Specification<Template> specification);
}
