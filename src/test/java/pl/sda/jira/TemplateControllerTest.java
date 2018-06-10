package pl.sda.jira;

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
public class TemplateControllerTest {
    @Autowired private MockMvc chrome;

    @Test
    public void shouldSayHelloToSebastian() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.get("/hello?name=Sebastian")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Hello Sebastian! Are you lost?", response.getContentAsString());
    }

    @Test
    public void shouldSayHelloToSebastianSecondTime() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.get("/hello")
                .param("name", "Sebastian")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Hello Sebastian! Are you lost?", response.getContentAsString());
    }
}







