package pl.sda.jira.project.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import pl.sda.jira.project.model.Project;
import pl.sda.jira.project.model.ProjectName;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaDataProjectRepository implements ProjectRepository {
    private final CrudJpaProjectRepository repository;

    public JpaDataProjectRepository(CrudJpaProjectRepository repository) {

        this.repository = repository;
    }

    @Override
    public Project get(Long id) {
        return repository.findOne(id);
    }

    @Override
    public boolean isExist(long id) {
        return repository.exists(id);
    }

    @Override
    public boolean isExist(String name) {
        Optional<Project> optionalProject = repository.getProjectByName( new ProjectName(name));
        return optionalProject.isPresent();
    }

    @Override
    public void add(Project project) {
        repository.save(project);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public void update(Project project) {
        repository.save(project);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public List<Project> findAll(Specification<Project> specification) {
        return repository.findAll(specification);
    }


}
