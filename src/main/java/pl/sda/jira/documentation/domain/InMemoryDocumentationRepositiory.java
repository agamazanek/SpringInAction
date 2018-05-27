package pl.sda.jira.documentation.domain;

import pl.sda.jira.documentation.dto.DocumentationDto;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDocumentationRepositiory implements DocumentationRepository {

    private Map<Long, Documentation> documentationHashMap = new HashMap<Long, Documentation>();

    @Override
    public void add(Documentation documentation) {
        documentationHashMap.put(documentation.getId(), documentation);
    }

    @Override
    public boolean exists(Long documentationId) {
        boolean existing = false;
        existing = documentationHashMap.containsKey(documentationId) ? true : false;
        return existing;
    }

    @Override
    public Documentation get(Long documentationId) {
        return documentationHashMap.get(documentationId);
    }
}
