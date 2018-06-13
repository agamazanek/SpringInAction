package pl.sda.jira.project.model;

import org.springframework.stereotype.Service;
import pl.sda.jira.project.domain.ProjectAlreadyExistsException;

import java.util.UUID;

@Service
public class ProjectService {
    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public ProjectDto get(long projectId) {
        if (!repository.isExist(projectId)) {
            throw new ProjectDoesntExistException();
        } else {
            return repository.get(projectId).asDto();
        }
    }

    public long add(ProjectDto projectDto) {
        if (repository.isExist(projectDto.getName())) throw new ProjectAlreadyExistsException(projectDto.getName());
        else {
            long id = UUID.randomUUID().getMostSignificantBits();
            Project project = new Project(id, projectDto.getName());
            repository.add(project);
         return  id;}}

    public void delete(long projectId) {
        if (repository.isExist(projectId)) {
            repository.delete(projectId);
        } else {
            throw new ProjectDoesntExistException();
        }
    }

    public void update(Long id, ProjectDto projectDto) {
        if (repository.isExist(id)) {
            Project project = repository.get(id);
            project.update(projectDto);
            repository.replace(project);
        } else throw new ProjectDoesntExistException();
    }
}
