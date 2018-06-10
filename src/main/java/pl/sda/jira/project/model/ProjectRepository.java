package pl.sda.jira.project.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProjectRepository {
    Project get(Long id);

    boolean isExist(long projectId);

    void add(Project project);

    void delete(long projectId);

    void update(Long projectId, String newProjectname);
}
