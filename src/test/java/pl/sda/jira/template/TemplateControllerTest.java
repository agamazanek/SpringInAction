package pl.sda.jira.template;

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
    @Autowired private MockMvc client;

    @Test
    public void shouldPass() throws Exception {
        MockHttpServletResponse response = client.perform(
                MockMvcRequestBuilders.get("/template/13")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Lucky 13", response.getContentAsString());
    }

    @Test
    public void shouldFail() throws Exception {
        MockHttpServletResponse response = client.perform(
                MockMvcRequestBuilders.get("/template/69")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.NOT_ACCEPTABLE.value(), response.getStatus());
    }
}