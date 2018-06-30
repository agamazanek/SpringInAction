package pl.sda.jira.documentation.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
import pl.sda.jira.documentation.domain.DocumentationService;
import pl.sda.jira.documentation.domain.exception.DocumentDoestExist;
import pl.sda.jira.documentation.dto.DocumentationDto;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DocumentationControllerTest {
    @Autowired
    private MockMvc chrome;
    @Autowired
    private DocumentationService service;

    final private String TITLE = "JIRA";

    @Test
    public void shouldDelete() throws Exception {
        final long id = createDocument(TITLE);
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.delete("/document/{id}", id)
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void shouldNotDeleteWhenDocumentNotExist() throws Exception {
        createDocument(TITLE);
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.delete("/document/16")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());

    }

    @Test
    public void shouldGet() throws Exception {
        final long id = createDocument(TITLE);
        MockHttpServletResponse response = aDocumentBy(id);

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("{\"title\":\"" + TITLE + "\"}", response.getContentAsString());

    }

    private long createDocument(String name) {
        DocumentationDto documentationDto = new DocumentationDto(name);
        return service.add(documentationDto);
    }

    private MockHttpServletResponse aDocumentBy(long id) throws Exception {
        return chrome.perform(
                MockMvcRequestBuilders.get("/document/" + id)
        ).andReturn().getResponse();
    }

    @Test
    public void shouldNotGetWhenDocumentNotExist() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.get("/document/15")
        ).andReturn().getResponse();


        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
        assertEquals("document not exist", response.getContentAsString());

    }

    @Test
    public void shouldCreate() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.put("/document")
                        .param("title", TITLE)
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        String id = response.getContentAsString();
        assertEquals("{\"title\":\"" + TITLE + "\"}", aDocumentBy(Long.parseLong(id)).getContentAsString());

    }

    @Test
    public void shouldUpdate() throws Exception {
        final long id = createDocument(TITLE);
        String newTitle = "JIREA2";
        MockHttpServletResponse response = chrome.perform
                (MockMvcRequestBuilders.post("/document/{id}", id)
                        .param("title", newTitle)
                ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        MockHttpServletResponse create = aDocumentBy(id);
        assertEquals("{\"title\":\"" + newTitle + "\"}", create.getContentAsString());

    }
}
