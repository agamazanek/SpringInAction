package pl.sda.jira.documentation.domain;


import java.util.List;

public class FakeDocumentationRepository implements DocumentationRepository {
    private boolean somethingAdded = false;

    public FakeDocumentationRepository(List<Documentation> documentations) {
        this.documentations = documentations;
    }

    private final List<Documentation> documentations;

    public void add(Documentation documentation) {
        somethingAdded = true;
    }

    public boolean existForProject() {
        return somethingAdded;
    }

    @Override
    public List<Documentation> findAll() {
        return documentations;
    }
}
