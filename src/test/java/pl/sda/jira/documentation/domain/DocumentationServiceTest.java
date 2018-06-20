package pl.sda.jira.documentation.domain;

import org.junit.Test;
import pl.sda.jira.documentation.domain.exception.DocumentDoestExist;
import pl.sda.jira.documentation.domain.exception.ThisSameDocumentExist;
import pl.sda.jira.documentation.dto.DocumentationDto;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;


public class DocumentationServiceTest {
    private DocumentationRepository documentationRepository = new InMemoryDocumentationRepository();
    private DocumentationService documentationService = new DocumentationService(documentationRepository);
    private final long DOCUMENTATION_ID = 2L;
    private final DocumentationDto DOCUMENTATION_DTO = new DocumentationDto("JIRA") ;
    private final String DOCUMENT_NAME_UPDATE = "JIRA2";


    @Test(expected = DocumentDoestExist.class)
    public void shouldThrowDocumentDoestExistWhenDocumentationNotExist() {

        documentationService.get(DOCUMENTATION_ID);
    }

    @Test
    public void shouldReturnDocumentationWhenExist() {
        documentationService.add(DOCUMENTATION_DTO);
        documentationService.get(DOCUMENTATION_ID);
    }

    @Test
    public void shouldDeleteDocumentWhenExist() {
        documentationService.add(DOCUMENTATION_DTO);
        documentationService.delete(DOCUMENTATION_ID);
        assertFalse(documentationService.exists(DOCUMENTATION_ID));
    }

    @Test(expected = DocumentDoestExist.class)
    public void shouldThrowsExceptionWhenDocumentNotExist() {
        documentationService.delete(DOCUMENTATION_ID);
    }

    @Test(expected = DocumentDoestExist.class)
    public void shouldNotUpdateWhenDocumentNotExist() {
        documentationService.update(DOCUMENTATION_DTO , DOCUMENTATION_ID);
    }

    @Test
    public void shouldUpdateDocument() {


        documentationService.add(DOCUMENTATION_DTO);
        documentationService.update(DOCUMENTATION_DTO, DOCUMENTATION_ID);
        Documentation documentation = documentationRepository.get(DOCUMENTATION_ID);
        assertEquals(documentation.getTitle() , DOCUMENT_NAME_UPDATE);
    }

    @Test(expected = ThisSameDocumentExist.class)
    public void shouldNotAddWhenThisSameDocumentExist() {
        documentationService.add(DOCUMENTATION_DTO);
        documentationService.add(DOCUMENTATION_DTO);
    }
}