package pl.sda.jira.project.model;

import java.util.List;

public interface ProjectRepository {
    Project get(Long id);

    boolean isExist(long projectId);

    void add(Project project);

    void delete(long projectId);

    void update(Long projectId, String newProjectname);
}
