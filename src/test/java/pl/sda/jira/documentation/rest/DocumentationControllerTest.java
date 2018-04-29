package pl.sda.jira.documentation.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.documentation.domain.Documentation;
import pl.sda.jira.documentation.domain.DocumentationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/jira-sda-app.xml")
@ContextConfiguration("/fake-documentation-repository.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DocumentationControllerTest {

    private static final String SOME_NAME = "Spring";

    @Autowired
    private DocumentationRepository documentationRepository;
    @Autowired
    private DocumentationController documentationController;

    @Test
    public void shouldNotFindDocumentationForGivenProject() {


        boolean result = documentationController.existForProject(SOME_NAME);

        Assert.assertFalse(result);
    }

    @Test
    public void shouldFindDocumentationForGivenProject() {
        documentationRepository.add(new Documentation("test", 111L));

        boolean result = documentationController.existForProject(SOME_NAME);

        Assert.assertTrue(result);
    }

    @Test
    public void shouldCheckThatClassFromBeanIsCorrect() {


        Assert.assertEquals(3, documentationRepository.findAll().size());
        Assert.assertEquals("doc1", documentationRepository.findAll()
                .get(0).getDocumentationName());
        Assert.assertEquals(Long.valueOf("1"),documentationRepository.findAll()
                .get(0).getProjectId());

    }

}
