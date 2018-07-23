package pl.sda.jira.project.repository;


import org.springframework.data.jpa.domain.Specification;
import pl.sda.jira.project.model.Project;

import java.util.List;

public interface ProjectRepository {

    Project get(Long id);

    boolean isExist(long projectId);

    boolean isExist(String name);

    void add(Project project);

    void delete(long projectId);

    void update(Project project);

    void deleteAll();

    List<Project> findAll(Specification<Project> specification);
}
