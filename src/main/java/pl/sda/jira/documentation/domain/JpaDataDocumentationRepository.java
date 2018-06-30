package pl.sda.jira.documentation.domain;

import org.springframework.stereotype.Repository;
@Repository
public class JpaDataDocumentationRepository implements DocumentationRepository {
    private final CrudJpaDocumentationRepository repository;

    public JpaDataDocumentationRepository(CrudJpaDocumentationRepository repository) {
        this.repository = repository;
    }


    @Override
    public Documentation add(Documentation documentation) {
        return repository.save(documentation);
    }

    @Override
    public boolean exists(Long documentationId) {
       return repository.exists(documentationId);
    }

    @Override
    public Documentation get(Long documentationId) {
        return repository.findOne(documentationId);
    }

    @Override
    public void delete(Long documentationId) {
        repository.delete(documentationId);
    }

    @Override
    public void update(Documentation documentation) {
        repository.save(documentation);
    }
}
