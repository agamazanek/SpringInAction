package pl.sda.jira.documentation.domain;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.jira.calendar.persistency.inmemory.InMemoryCalendarRepository;
import pl.sda.jira.documentation.dto.DocumentationDto;

import static org.junit.Assert.*;

public class DocumentationServiceTest {



    @Test (expected = DocumentDoesntExist.class)
    public void shouldThowExceptionWhenDocumentationDoesntExist(){
        DocumentationRepository documentationRepository = new InMemoryDocumentationRepositiory();
        DocumentationService documentationService = new DocumentationService(documentationRepository);
        Long documentationId = 1L;
        documentationService.get(documentationId);
    }

    @Test
    public void shouldReturnDocumentationIdWhenExists() {
        DocumentationRepository documentationRepository = new InMemoryDocumentationRepositiory();
        DocumentationService documentationService = new DocumentationService(documentationRepository);
        Long documentationID = 2L;
        documentationRepository.add(new Documentation(documentationID ));

        DocumentationDto result = documentationService.get(documentationID);
        DocumentationDto expected = new DocumentationDto();

        expected.setId(documentationID);
        assertEquals(expected, result);
    }


}