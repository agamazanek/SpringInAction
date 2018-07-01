package pl.sda.jira.documentation.domain;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import pl.sda.jira.documentation.domain.exception.DocumentDoestExist;
import pl.sda.jira.documentation.domain.exception.ThisSameDocumentExist;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InMemoryDocumentationRepository implements DocumentationRepository {

    private List<Documentation> documentations = new ArrayList<>();

    @Override
    public Documentation add(Documentation documentation) {
        setId(documentation);
        if (!exists(documentation.getId())) {
            documentations.add(documentation);
            return documentation;
        } else {
            throw new ThisSameDocumentExist(documentation.getId());
        }
    }

    private void setId(Documentation documentation) {
        Long id = UUID.randomUUID().getMostSignificantBits();
        documentation.setId(id);
    }

    public boolean exists(Long documentationId) {
        for (Documentation documentation : documentations) {
            if (documentation.getId().equals(documentationId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Documentation get(Long documentationId) {
        if (exists(documentationId)) {
            return findDocumentation(documentationId);
        }
        throw new DocumentDoestExist(documentationId);
    }

    @Override
    public void delete(Long documentationId) {
        if (exists(documentationId)) {
            Documentation documentation = findDocumentation(documentationId);
            documentations.remove(documentation);
        } else {
            throw new DocumentDoestExist(documentationId);
        }
    }

    @Override
    public void update(Documentation documentation) {
        setId(documentation);
        delete(documentation.getId());
        add(documentation);
    }

    @Override
    public List<Documentation> findAll(Specification<Documentation> specification) {
        return null;
    }

    private Documentation findDocumentation(Long documentationId) {
        Documentation documentation = null;
        for (int i = 0; i < documentations.size(); i++) {
            if (documentations.get(i).getId().equals(documentationId)) {
                documentation = documentations.get(i);
            }

        }
        return documentation;
    }
}

