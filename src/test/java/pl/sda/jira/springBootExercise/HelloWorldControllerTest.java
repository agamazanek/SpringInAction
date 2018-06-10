package pl.sda.jira.springBootExercise;

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
public class HelloWorldControllerTest {

    @Autowired private MockMvc chrome;

    @Test
    public void shouldSayHelloToAga() throws Exception{
        MockHttpServletResponse response = chrome.perform(MockMvcRequestBuilders.get("/hello?name=Aga")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Hello Aga! Are you lost?", response.getContentAsString());
    }

    @Test
    public void shouldSayHelloToAgaSecodTime() throws Exception {
        MockHttpServletResponse response = chrome.perform(MockMvcRequestBuilders.get("/hello")
                .param("name", "Aga")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Hello Aga! Are you lost?", response.getContentAsString());
    }

    @Test
    public void shouldSayHelloUsingDefaultName() throws Exception{
        MockHttpServletResponse response = chrome.perform(MockMvcRequestBuilders.get("/hello")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Hello NEW COMER! Are you lost?", response.getContentAsString());
    }

    @Test
    public void shouldSayHelloToAgaAndRedirectToNewSite() throws Exception{
        MockHttpServletResponse response = chrome.perform((MockMvcRequestBuilders.get("/helloWorld"))
                .param("name", "Aga").param("newLocation", "new site")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Hello Aga! Are you lost? You are being redirected to: new site", response.getContentAsString());
    }

    @Test
    public void shouldSayHelloToAgandRedirectToNewSiteSecondTime() throws Exception{
        MockHttpServletResponse response = chrome.perform(MockMvcRequestBuilders.get("/helloHello/Aga/new site")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Hello Aga. You're being redirected to: new site", response.getContentAsString());
    }




}
