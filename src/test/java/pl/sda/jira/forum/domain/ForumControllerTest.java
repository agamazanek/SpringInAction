package pl.sda.jira.forum.domain;

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

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ForumControllerTest {

    @Autowired
    private MockMvc chrome;

    private final String FORUMID = "123";
    private final String NAME = "FirstForum";
    private final String NAME1 = "SecondForum";

    @Test
    public void shouldGet() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.get("/forum/hello-forum/FirstForum")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Name of this forum is: " + NAME, response.getContentAsString());
    }

    @Test
    public void shouldAdd() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.put("/forum")
                        .param(NAME, "FirstForum")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(36, response.getContentAsString().length());
    }

    @Test
    public void shouldUpdate() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.post("/forum/FirstForum")
                        .param(NAME, "FirstForum")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Forum name has been changed: " + NAME1, response.getContentAsString());
    }

    @Test
    public void shouldDelete() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.delete("/forum/123")
                        .param(FORUMID, "123")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Forum with id: " + FORUMID + " deleted", response.getContentAsString());
    }
}


