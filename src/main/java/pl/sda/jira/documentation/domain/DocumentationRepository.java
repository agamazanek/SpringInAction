package pl.sda.jira.documentation.domain;

public interface DocumentationRepository {
    Documentation add(Documentation documentation);

    boolean exists(Long documentationId);

    Documentation get(Long documentationId);

    void delete(Long documentationId);

    void update(Documentation documentation );
}
