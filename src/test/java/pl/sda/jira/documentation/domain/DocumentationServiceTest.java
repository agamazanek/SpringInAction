package pl.sda.jira.documentation.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.documentation.domain.exception.DocumentDoestExist;
import pl.sda.jira.documentation.domain.exception.ThisSameDocumentExist;
import pl.sda.jira.documentation.dto.DocumentationDto;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DocumentationServiceTest {
    private static final long DOCUMENTATION_ID = 1234L;
    private static final String DOCUMENT_DTO_NAME = "JIRA2";
    private static final DocumentationDto NEW_DOCUMENT_DTO = new DocumentationDto(DOCUMENT_DTO_NAME);

    @Autowired private DocumentationRepository documentationRepository;
    @Autowired private DocumentationService documentationService;
    @Autowired private AuthorRepository authorRepository;

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

        assertFalse(documentationService.exists(Id));

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

        final Documentation documentation = documentationRepository.add(new Documentation("JIRA"));
        documentation.setAuthor(new Author("Jacek" , "Placek"));

        documentationService.update(NEW_DOCUMENT_DTO, documentation.getId());


        Documentation documentation1 = documentationRepository.get(documentation.getId());
        assertEquals(documentation1.getTitle(), DOCUMENT_DTO_NAME);
    }

    @Test
    public void shouldAddThemAll() {
        Long id1 = documentationService.add(new DocumentationDto("Peter Parker"));
        Long id2 = documentationService.add(new DocumentationDto("Mary Jane Watson"));
        Long id3 = documentationService.add(new DocumentationDto("Gwen Stacy"));
        List<Page> pages = new ArrayList<>();
        Page page1 = new Page("cos tam na koniec");
        page1.setContent("cos tam na koniec");
        pages.add(page1);
        pages.add(new Page("cos tam"));
        pages.add(new Page("cos tam innego"));
        pages.add(new Page("cos tam wiecej"));

        Documentation documentation = documentationRepository.get(id1);
        documentation.setAuthor(new Author("Jacek" , "Placek"));
        documentation.setPages(pages);
//        authorRepository.save(documentation.getAuthor());
        documentationRepository.update(documentation);

        Documentation documentation1 = documentationRepository.get(id2);
        documentation1.setAuthor(new Author("Kamil" , "Nowak"));
        authorRepository.save(documentation1.getAuthor());
        documentationRepository.update(documentation1);

        Documentation documentation2 = documentationRepository.get(id3);
        documentation2.setAuthor(new Author("Marcin" , "Dziedzic"));
        authorRepository.save(documentation2.getAuthor());
        documentationRepository.update(documentation2);

        assertEquals(documentation.getTitle(), "Peter Parker");
        assertEquals(documentation.getAuthor().fullName(),"Jacek Placek");

        assertEquals(documentation1.getTitle(), "Mary Jane Watson");
        assertEquals(documentation1.getAuthor().fullName() ,"Kamil Nowak" );

        assertEquals(documentation2.getAuthor().fullName() , "Marcin Dziedzic");
        assertEquals(documentation2.getTitle(), "Gwen Stacy");
    }

}