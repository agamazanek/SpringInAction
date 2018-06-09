package pl.sda.jira.project.model;

import java.util.HashMap;
import java.util.Map;

public class ProjectRepositoryInmemory implements ProjectRepository {

    private Map<Long, Project> projects = new HashMap<>();

    @Override
    public Project get(Long id) {
            return projects.get(id);
    }

    @Override
    public boolean isExist(long projectId) {
        return projects.containsKey(projectId);
    }

    @Override
    public void add(Project project) {
        projects.put(project.getId(),project);
    }

    @Override
    public void delete(long projectId) {
        projects.remove(projectId);
    }

    @Override
    public void update(Long projectId, String newProjectname) {
        Project projectToUpdate = projects.get(projectId);
        projectToUpdate.setProjectName(newProjectname);
    }

}