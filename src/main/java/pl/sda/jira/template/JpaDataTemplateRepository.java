package pl.sda.jira.template;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaDataTemplateRepository implements TemplateRepository {
    private final CrudJpaTemplateRepository repository;

    public JpaDataTemplateRepository(CrudJpaTemplateRepository repository) {
        this.repository = repository;
    }

    @Override
    public Template getBy(String id) {
        return repository.findOne(id);
    }

    @Override
    public void remove(String id) {
        repository.delete(id);
    }

    @Override
    public Template create(Template template) {
        return repository.save(template);
    }

    @Override
    public Template update(Template template) {
        return repository.save(template);
    }

    @Override
    public List<Template> findAll(Specification<Template> specification) {
        return repository.findAll(specification);
    }
}
