package pl.sda.jira.documentation.domain;

import java.util.List;

public interface DocumentationRepository {
    boolean existForProject();

    void add(Documentation documentation);

    List<Documentation> findAll();
}
