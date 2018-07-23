package pl.sda.jira.project.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.jira.project.model.Project;
import org.springframework.data.repository.CrudRepository;
import pl.sda.jira.project.model.ProjectName;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudJpaProjectRepository extends CrudRepository<Project,Long>, JpaSpecificationExecutor<Project> {
    Optional<Project> getProjectByName(ProjectName name);

}
