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
import pl.sda.jira.calendar.domain.dto.CalendarDto;
import pl.sda.jira.calendar.domain.service.CalendarService;
import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalendarControllerTest {

    private static final String NAME = "calendar9";
    private static final String NEW_NAME = "myCalendar";
    @Autowired private MockMvc restClient;
    @Autowired private CalendarService calendarService;

    @Test
    public void shouldGetCalendar() throws Exception {
        CalendarDto calendarDto = new CalendarDto(CalendarDto.Builder.aCalendar(NAME));
        String id = calendarService.add(calendarDto);

        MockHttpServletResponse response = restClient.perform(MockMvcRequestBuilders.get("/calendar/{id}", id)).andReturn().getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("{\"id\":\"" + id + "\"}", response.getContentAsString());
    }

    @Test
    public void shouldDeleteCalendar() throws Exception{
        CalendarDto calendarDto = new CalendarDto(CalendarDto.Builder.aCalendar(NAME));
        String id = calendarService.add(calendarDto);

        MockHttpServletResponse response = restClient.perform(MockMvcRequestBuilders.delete("/calendar/{id}", id)).andReturn().getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }


    @Test
    public void shouldUpdateCalendar() throws Exception{

        CalendarDto calendarDto = new CalendarDto(CalendarDto.Builder.aCalendar(NAME));
        String id = calendarService.add(calendarDto);

        MockHttpServletResponse response = restClient.perform((MockMvcRequestBuilders.put("/calendar/{id}/{name}", id, NEW_NAME))).andReturn().
                getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }


    @Test
    public void shouldAddCalendar() throws Exception{
        CalendarDto calendarDto = new CalendarDto(CalendarDto.Builder.aCalendar(NAME));
        String id = calendarService.add(calendarDto);

        MockHttpServletResponse response = restClient.perform((MockMvcRequestBuilders.post("/calendar/"))
                .param("calendarDto", calendarDto.getName())).andReturn().getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(id, response.getContentAsString());
    }
}
