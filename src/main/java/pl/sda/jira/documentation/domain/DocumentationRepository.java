package pl.sda.jira.documentation.domain;

import pl.sda.jira.documentation.dto.DocumentationDto;

public interface DocumentationRepository {
   // boolean existForProject();

    void add(Documentation documentation);

    boolean exists(Long documentationId);

    Documentation get(Long documentationId);

}
