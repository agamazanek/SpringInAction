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
                MockMvcRequestBuilders.get("/template/hello?name=Sebastian&lastName=Malaca")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Hello Sebastian! Malaca are you lost?", response.getContentAsString());
    }

    @Test
    public void shouldSayHelloToSebastianSecondTime() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.get("/template/hello")
                .param("name", "Sebastian")
                .param("lastName", "Malaca")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Hello Sebastian! Malaca are you lost?", response.getContentAsString());
    }

    @Test
    public void shouldSayHelloToSebastianThirdTime() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.get("/template/hello-world/Sebastian")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Hello " + "Sebastian" + "! Good to see you again :)", response.getContentAsString());
    }

    @Test
    public void shouldRemove() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.delete("/template/13")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Removed: 13", response.getContentAsString());
    }

    @Test
    public void shouldGet() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.get("/template/13")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Retrieved: 13", response.getContentAsString());
    }

    @Test
    public void shouldAdd() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.put("/template")
                .param("name", "Sebastian")
                .param("lastName", "Malaca")
                .param("mail", "sebastian.malaca@gmail.com")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Malaca Sebastian, mail: sebastian.malaca@gmail.com", response.getContentAsString());
    }
}







