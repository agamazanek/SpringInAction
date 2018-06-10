package pl.sda.jira.project.model;

import org.springframework.stereotype.Service;
import pl.sda.jira.project.domain.ProjectAlreadyExistsException;
@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project get(long projectId) {
        if (repository.isExist(projectId)) {
            return repository.get(projectId);
        } else {
            throw new ProjectDoesntExistException();
        }
    }

    public void add(Project project) {
        if (repository.isExist(project.getId())) {
            throw new ProjectAlreadyExistsException();
        } else {
            repository.add(project);
        }
    }

    public void delete(long projectId) {
        if (repository.isExist(projectId)) {
            repository.delete(projectId);
        } else {
            throw new ProjectDoesntExistException();
        }
    }

    public void update(Long projectId, String newProjectname) {
        if(repository.isExist(projectId)){
            repository.update(projectId, newProjectname);
        }
    }
}
