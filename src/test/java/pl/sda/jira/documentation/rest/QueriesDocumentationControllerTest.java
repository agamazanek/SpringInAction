package pl.sda.jira.documentation.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.sda.jira.documentation.domain.CrudJpaDocumentationRepository;
import pl.sda.jira.documentation.domain.Documentation;
import pl.sda.jira.documentation.domain.DocumentationRepository;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class QueriesDocumentationControllerTest {

    @Autowired
    private MockMvc chrome;
    @Autowired
    private CrudJpaDocumentationRepository repository;

    Documentation documentation1 = new Documentation("JIRA");
    Documentation documentation2 = new Documentation("JIRA2");
    Documentation documentation = new Documentation("JIRA2");

    @Before
    public void setUp() {
        repository.save(documentation);
        repository.save(documentation1);
        repository.save(documentation2);
    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test

    public void shouldReturnTwoDocuments() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.post("/documents")
                        .param("name", "title")
                        .param("value", "JIRA2")
                        .param("type", "equal"))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("[{\"title\":\"JIRA2\"},{\"title\":\"JIRA2\"}]", response.getContentAsString());
    }

    @Test
    public void shouldReturnThreeDocumentsByUseLike() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.post("/documents")
                        .param("name", "title")
                        .param("value", "JIRA")
                        .param("type", "like"))
                .andReturn().getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("[{\"title\":\"JIRA2\"},{\"title\":\"JIRA\"},{\"title\":\"JIRA2\"}]"
                ,response.getContentAsString());
    }
}