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
    private final String DOCUMENT_DTO_NAME = "JIRA2";
    private final DocumentationDto NEW_DOCUMENT_DTO = new DocumentationDto("jira2");

    private final DocumentationDto DOCUMENTATION_DTO = new DocumentationDto(DOCUMENT_DTO_NAME);

    @Test(expected = DocumentDoestExist.class)
    public void shouldThrowDocumentDoestExistWhenDocumentationNotExist() {
        documentationService.get(DOCUMENTATION_ID);
    }

    @Test
    public void shouldReturnDocumentationWhenExist() {
        Long ID = documentationService.add(DOCUMENTATION_DTO);
        documentationService.get(ID);
    }

    @Test
    public void shouldDeleteDocumentWhenExist() {
        final Long Id = documentationService.add(DOCUMENTATION_DTO);
        documentationService.delete(Id);

        assertFalse(documentationService.exists(DOCUMENTATION_ID));

    }

    @Test(expected = DocumentDoestExist.class)
    public void shouldThrowsExceptionWhenDocumentNotExist() {
        documentationService.delete(DOCUMENTATION_ID);
    }

    @Test(expected = DocumentDoestExist.class)
    public void shouldNotUpdateWhenDocumentNotExist() {
        documentationService.update(DOCUMENTATION_DTO, DOCUMENTATION_ID);
    }

    @Test
    public void shouldUpdateDocument() {
        Long ID = documentationService.add(DOCUMENTATION_DTO);
        documentationService.update(NEW_DOCUMENT_DTO, ID);
        Documentation documentation = documentationRepository.get(DOCUMENTATION_ID);
        assertEquals(documentation.getTitle(), DOCUMENT_DTO_NAME);
    }

    @Test(expected = ThisSameDocumentExist.class)
    public void shouldNotAddWhenThisSameDocumentExist() {
        Long Id = documentationService.add(DOCUMENTATION_DTO);
        documentationRepository.add(new Documentation(Id ,DOCUMENTATION_DTO.getTitle()));
    }
}