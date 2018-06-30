package pl.sda.jira.project.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.jira.project.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudJpaProjectRepository extends CrudRepository<Project,Long>, JpaSpecificationExecutor<Project> {
    Optional<Project> getProjectByName(@Param("name")String name);

    int countByName(String name);

    Project findFirstByName(String name);

    Optional<Project> findFirstByAuthorOrName(String author, String name);

    @Query("select p.author from Project p where p.name=:name")
    List<Project> findAuthorByProjectName(@Param("name") String projectName);

    @Query("select p from Project  p where p.author=:author")
    List<Project> findProjectsByAuthor(@Param("author") String author);

    @Query("select p from Project p where p.id=:id")
    Optional<Project> findById(@Param("id") Long id);
}
