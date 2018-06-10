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
    @Autowired private MockMvc chrome;

    @Test
    public void shouldSayHelloToMarcin() throws Exception {
        MockHttpServletResponse response = chrome.perform(MockMvcRequestBuilders.get("/forum/hello?name=Marcin"))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Hello Marcin! What You want ?", response.getContentAsString());
    }

    @Test
    public void shouldSayHelloToMarcinSecondTime() throws Exception {
        MockHttpServletResponse response = chrome.perform(MockMvcRequestBuilders.get("/forum/hello")
                .param("name", "Marcin"))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Hello Marcin! What You want ?", response.getContentAsString());

    }

    @Test
    public void shouldSayHelloToMarcinWithFewParams() throws Exception {
        MockHttpServletResponse response = chrome.perform(MockMvcRequestBuilders.get("/forum/hello2/Marcin,Dziedzic"))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Hello Marcin Dziedzic! What You want ?", response.getContentAsString());

    }
}
