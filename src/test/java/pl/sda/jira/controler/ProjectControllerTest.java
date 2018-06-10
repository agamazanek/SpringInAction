package pl.sda.jira.controler;

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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectControllerTest {

    @Autowired private MockMvc chrome;

    @Test
    public void shouldReturnHelloWorld() throws Exception {
        MockHttpServletResponse response=chrome.perform(
        MockMvcRequestBuilders.get("/project/hello")).andReturn().getResponse();
        assertEquals(HttpStatus.OK.value(),response.getStatus());
        assertEquals("Hello world!",response.getContentAsString());
    }

}