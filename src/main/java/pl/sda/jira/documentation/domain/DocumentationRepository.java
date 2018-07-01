package pl.sda.jira.documentation.domain;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface DocumentationRepository {
    Documentation add(Documentation documentation);

    boolean exists(Long documentationId);

    Documentation get(Long documentationId);

    void delete(Long documentationId);

    void update(Documentation documentation );

    List<Documentation> findAll(Specification<Documentation> specification);
}
