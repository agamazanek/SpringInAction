package pl.sda.jira.documentation.domain.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.sda.jira.documentation.domain.Documentation;
import pl.sda.jira.documentation.domain.DocumentationRepository;

import static org.junit.Assert.assertEquals;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

@AutoConfigureMockMvc
public class DocumentDoestExistTest {
    @Autowired
    private MockMvc chrome;

    @Autowired
    private DocumentationRepository documentationRepository;

    @Test
    public void shouldThrowException() throws Exception {

        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.get("/document/14")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
        assertEquals("document not exist" , response.getContentAsString());
    }

    @Test
    public void shouldPassTest() throws Exception {

        Documentation documentation = documentationRepository.add(new Documentation("JIRA"));
        final Long id = documentation.getId();
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.get("/document/{id}" ,id)
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("{\"title\":\"" + "JIRA" + "\"}", response.getContentAsString());

    }
}