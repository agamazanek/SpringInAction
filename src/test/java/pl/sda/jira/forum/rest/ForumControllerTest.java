package pl.sda.jira.forum.rest;

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
import pl.sda.jira.forum.domain.ForumService;
import pl.sda.jira.forum.dto.ForumDto;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ForumControllerTest {

    @Autowired
    private MockMvc chrome;
    @Autowired
    private ForumService forumService;

    private final String FORUMID = "123";
    private final String NAME = "FirstForum";
    private final String NAME1 = "SecondForum";

    @Test
    public void shouldGet() throws Exception {
        long id = forumService.add(new ForumDto(NAME));

        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.get("/forum/{id}", id)
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("{\"name\":\"" + NAME + "\"}", response.getContentAsString());
    }

    @Test
    public void shouldAdd() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.put("/forum")
                        .param(NAME, "FirstForum")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(1, response.getContentAsString().length());
    }

    @Test
    public void shouldUpdate() throws Exception {
        long id = forumService.add(new ForumDto(NAME));

        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.post("/forum/{id}", id)
                        .param("name", NAME1)
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Forum name has been changed: " + NAME1, response.getContentAsString());
    }

    @Test
    public void shouldDelete() throws Exception {
        long id = forumService.add(new ForumDto(NAME));

        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.delete("/forum/{id}", id)
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void shouldThrowException() throws Exception {
        String id = "1234";

        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.get("/forum/{id}", id)
        ).andReturn().getResponse();

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }

    @Test
    public void shouldThrowAnotherException() throws Exception {
        long id = 1234;

        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.get("/forum/{id}", id)
        ).andReturn().getResponse();

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
        assertEquals("Forum with id: " + id + " does not exist!", response.getContentAsString());
    }
}


