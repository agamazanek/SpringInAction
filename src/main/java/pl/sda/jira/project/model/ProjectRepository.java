package pl.sda.jira.project.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProjectRepository {
    Project get(Long id);

    boolean isExist(long projectId);
    boolean isExist(String name);

    void add(Project project);

    void delete(long projectId);

    void update(Project project);
}
