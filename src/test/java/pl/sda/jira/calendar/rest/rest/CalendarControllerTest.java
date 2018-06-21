package pl.sda.jira.calendar.rest.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.sda.jira.calendar.domain.dto.CalendarDto;
import pl.sda.jira.calendar.domain.model.Calendar;
import pl.sda.jira.calendar.domain.service.CalendarService;
import pl.sda.jira.calendar.rest.CalendarController;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalendarControllerTest {
    private static final String NAME = "calendar1";
    @Autowired private MockMvc restClient;


   @Mock
   private CalendarService calendarService;

   @InjectMocks
   private CalendarController calendarController;

   @Before
   public void setUp() throws Exception {
       restClient = MockMvcBuilders.standaloneSetup(calendarController).build();
   }

//    @Test
//    public void shouldSayHello() throws Exception {
//        MockHttpServletResponse response = restClient.perform(
//                MockMvcRequestBuilders.get("/calendar/hello")
//        ).andReturn().getResponse();
//
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//        assertEquals("Hello hello!", response.getContentAsString());
//    }

//    @Test
//    public void shouldGetCalendar() throws Exception {
//        MockHttpServletResponse response = restClient.perform(MockMvcRequestBuilders.get("/calendar/1356")).andReturn().getResponse();
//
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//        assertEquals("1356", response.getContentAsString());
//
//    }

    @Test
    public void shouldGetCalendar() throws Exception {
        MockHttpServletResponse response = restClient.perform(MockMvcRequestBuilders.get("/calendar").param("id", "789")).andReturn().getResponse();
        String id = "789";
        Calendar calendar = calendarService.findBy(id);
        calendarService.add(createCalendarDto());
        when(calendarService.findBy(id)).thenReturn(calendar);
        String result = calendar.getId();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(result, response.getContentAsString());
        verify(calendarService).findBy(id);
    }

    @Test
    public void shouldDeleteCalendar() throws Exception{
        MockHttpServletResponse response = restClient.perform(MockMvcRequestBuilders.delete("/calendar/789")).andReturn().getResponse();
        String id = "789";
        doNothing().when(calendarService).remove(id);
        verify(calendarService).remove(id);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("789", response.getContentAsString());
    }

    @Test
    public void shouldUpdateCalendar() throws Exception{
        MockHttpServletResponse response = restClient.perform((MockMvcRequestBuilders.put("/calendar/435/calendar2"))).andReturn().
                getResponse();
        String id = "435";
        doNothing().when(calendarService).update(id, createCalendarDto());
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        verify(calendarService).update(id, createCalendarDto());
        //assertEquals("Updated: 678 to new name: calendar1" , response.getContentAsString());
    }

    private CalendarDto createCalendarDto() {
       return new CalendarDto(CalendarDto.Builder.aCalendar(NAME));
    }

    @Test
    public void shouldAddCalendar() throws Exception{
        MockHttpServletResponse response = restClient.perform((MockMvcRequestBuilders.post("/calendar/calendar2"))).andReturn().getResponse();

    assertEquals(HttpStatus.OK.value(), response.getStatus());
    assertEquals("Added: calendar2", response.getContentAsString());
    }



}
