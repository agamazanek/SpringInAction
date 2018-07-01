package pl.sda.jira.calendar.rest.rest;

import org.junit.After;
import org.junit.Before;
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
import pl.sda.jira.calendar.domain.CrudJpaCalendarRepository;
import pl.sda.jira.calendar.domain.dto.CalendarDto;
import pl.sda.jira.calendar.domain.service.CalendarService;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalendarQueryControllerTest {
    @Autowired
    private MockMvc restClient;

    @Autowired private CalendarService service;

    @Autowired private CrudJpaCalendarRepository repository;
    @Before
    public void init(){
        CalendarDto calendarDto = new CalendarDto(CalendarDto.Builder.aCalendar("calendar0", "Ola"));
        CalendarDto calendarDto1 = new CalendarDto(CalendarDto.Builder.aCalendar("calendar1", "Ola"));
        CalendarDto calendarDto2= new CalendarDto(CalendarDto.Builder.aCalendar("calendar0", "Ala"));
        CalendarDto calendarDto3= new CalendarDto(CalendarDto.Builder.aCalendar("calendar2", "AlaPe"));

        service.add(calendarDto);
        service.add(calendarDto1);
        service.add(calendarDto2);
        service.add(calendarDto3);
    }

    @After
    public void tearDown() throws Exception {
        repository.deleteAll();
    }

    @Test
    public void shouldGetCalendarEqualToName() throws Exception {

        MockHttpServletResponse response = restClient.perform(
                MockMvcRequestBuilders.post("/calendars")
                        .param("name", "name")
                        .param("value", "calendar0")
                        .param("type", "equals"))
                .andReturn().getResponse();


        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("[{\"name\":\"calendar0\",\"owner\":\"Ola\"},{\"name\":\"calendar0\",\"owner\":\"Ala\"}]", response.getContentAsString());

    }


}
