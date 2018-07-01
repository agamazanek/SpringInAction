package pl.sda.jira.documentation.rest;

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

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class QueriesDocumentationControllerTest {

    @Autowired
    private MockMvc chrome;

    @Test
    public void shouldReturnCriteria() throws Exception {
        MockHttpServletResponse response = chrome.perform(
                MockMvcRequestBuilders.post("/documents")
                        .param("name", "title")
                        .param("value" ,"JIRA")
                        .param("type" , "equals"))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(),response.getStatus());
        assertEquals("name title, value JIRA,type equals" , response.getContentAsString());
    }
}