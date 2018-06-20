package pl.sda.jira.calendar.rest.rest;

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
public class CalendarControllerTest {
    @Autowired private MockMvc restClient;

    @Test
    public void shouldSayHello() throws Exception {
        MockHttpServletResponse response = restClient.perform(
                MockMvcRequestBuilders.get("/calendar/hello")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Hello hello!", response.getContentAsString());
    }

    @Test
    public void shouldGetCalendar() throws Exception {
        MockHttpServletResponse response = restClient.perform(MockMvcRequestBuilders.get("/calendar/1356")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Retrieved: 1356", response.getContentAsString());

    }

    @Test
    public void shouldDeleteCalendar() throws Exception{
        MockHttpServletResponse response = restClient.perform(MockMvcRequestBuilders.delete("/calendar/789")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Removed: 789", response.getContentAsString());
    }

    @Test
    public void shouldUpdateCalendar() throws Exception{
        MockHttpServletResponse response = restClient.perform((MockMvcRequestBuilders.put("/calendar/678/calendar1"))).andReturn().
                getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Updated: 678 to new name: calendar1" , response.getContentAsString());
    }

    @Test
    public void shouldAddCalendar() throws Exception{
        MockHttpServletResponse response = restClient.perform((MockMvcRequestBuilders.post("/calendar/calendar2"))).andReturn().getResponse();

    assertEquals(HttpStatus.OK.value(), response.getStatus());
    assertEquals("Added: calendar2", response.getContentAsString());
    }



}
