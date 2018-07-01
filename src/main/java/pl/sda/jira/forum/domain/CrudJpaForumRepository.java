package pl.sda.jira.forum.domain;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudJpaForumRepository extends CrudRepository<Forum, String>, JpaSpecificationExecutor<Forum> {

    List<Forum> findByName(String name);

    Forum findByForumId(String forumId);

    int countByName(String name);

    @Query("select f.forumId from Forum f where f.name=:name")
    List<String> countByNameQuery(@Param("name") String name);

    @Query("select f from Forum f where f.forumId=:forumId")
    Forum findByForumIdQuery(@Param("forumId")String forumId);

    @Query("select f from Forum f where f.name=:name and f.forumId=:forumId")
    Forum findByNameAndForumId(@Param("name") String name, @Param("forumId")String forumId);
}

