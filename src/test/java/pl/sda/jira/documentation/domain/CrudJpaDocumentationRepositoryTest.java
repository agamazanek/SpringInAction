package pl.sda.jira.documentation.domain;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CrudJpaDocumentationRepositoryTest {
    private static final String DOCUMENT_TITLE = "JIRA";
    @Autowired
    CrudJpaDocumentationRepository repository;
    @Autowired
    CrudJpaAuthorRepository authorRepository;

    private final Author AUTHOR = new Author("Jacek", "Placek");
    private final Author NEW_AUTHOR =  new Author("Marcin" , "Dziedzic");

    @Before
    public void setUp() {
        authorRepository.save(NEW_AUTHOR);
        authorRepository.save(AUTHOR);

    }

    @Test
    public void shouldAddDocumentWithCorrectAuthor() {


        Documentation documentation = new Documentation(DOCUMENT_TITLE);
        documentation.setAuthor(AUTHOR);

        Documentation saved = repository.save(documentation);

        assertEquals(DOCUMENT_TITLE, saved.getTitle());
        assertTrue(saved.isAuthor(AUTHOR));
        assertNotNull(saved.getId());

    }

    @Test
    public void shouldReturnDocumentWithCorrectAuthor() {
        ArrayList<Page> pages =  new ArrayList<>();
        Page page1 =  new Page();
        page1.setContents("COS TAM");
        Page page2 =  new Page();
        page2.setContents("COS TAM INNEGO");
        pages.add(page1);
        pages.add(page2);
        Documentation documentation = new Documentation(DOCUMENT_TITLE);
        documentation.setAuthor(AUTHOR);
        documentation.setPages(pages);

        Documentation saved = repository.save(documentation);
        Documentation result = repository.findOne(saved.getId());

        assertEquals(result, saved);
        assertNotSame(result ,saved);

    }

    @Test
    public void shouldUpdateDocumentNewAuthor() {
        Documentation documentation = new Documentation(DOCUMENT_TITLE);
        documentation.setAuthor(AUTHOR);
        Documentation saved = repository.save(documentation);

        saved.setAuthor(NEW_AUTHOR);
        repository.save(saved);
        Documentation result = repository.findOne(saved.getId());

        assertEquals(NEW_AUTHOR , result.getAuthor());
    }

    @Test
    public void shouldRemoveDocument() {
        Documentation saved = repository.save(new Documentation(DOCUMENT_TITLE));
        repository.delete(saved.getId());

        Assert.assertNull(repository.findOne(saved.getId()));
    }
}