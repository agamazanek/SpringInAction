package pl.sda.jira.template;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudJpaTemplateRepository extends CrudRepository<Template, Long>, JpaSpecificationExecutor<Template> {
    List<Template> findByName(String name);

    List<Template> findByDescription(String description);

    int countByName(String name);

    Template findFirstByName(String name);

    Optional<Template> findFirstByDescriptionOrName(String description, String name);

    Optional<Template> findFirstByDescriptionAndName(String description, String name);

    List<Template> findFirst2ByName(String name);

    Template findFirstByNameOrderByLastNameDesc(String name);

    @Query("select concat('name: ',t.name,', last name:',t.lastName) from Template t where t.name=:name or t.description=:description order by t.lastName")
    List<String> findDescriptionByName(@Param("name") String name, @Param("description") String desc);
}
