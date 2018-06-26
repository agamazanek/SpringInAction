package pl.sda.jira.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.jira.project.domain.Project;

import java.util.Optional;

@Repository
public interface CrudJpaProjectRepository extends CrudRepository<Project,Long>{
    Optional<Project> getProjectByName(@Param("name")String name);
}
