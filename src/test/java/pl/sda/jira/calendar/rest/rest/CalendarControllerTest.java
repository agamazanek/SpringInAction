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
import pl.sda.jira.calendar.domain.model.Name;
import pl.sda.jira.calendar.domain.model.Owner;
import pl.sda.jira.calendar.domain.service.CalendarService;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalendarControllerTest {


    private static final Name NAME = new Name("calendar9");
    private static final Owner OWNER = new Owner("Ola", "Pe", "SomeDept");
    private static final Name NEW_NAME = new Name("myCalendar");
    @Autowired private MockMvc restClient;
    @Autowired private CalendarService calendarService;

    @Test
    public void shouldGetCalendar() throws Exception {
        Name name = new Name("calendar909");
        Owner owner = new Owner("Ola", "Pe", "NewDept");
        CalendarDto calendarDto = new CalendarDto(CalendarDto.Builder.buildACalendar(name.value(), owner));
        Long id = calendarService.add(calendarDto);

        MockHttpServletResponse response = aCalendarBy(id);

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("{\"name\":\"calendar909\",\"owner\":{\"name\":\"Ola\",\"lastName\":\"Pe\",\"department\":\"NewDept\"}}", response.getContentAsString());
        calendarService.remove(id);
    }

    @Test
    public void shouldNotGetCalendar() throws Exception {
        Long id = 243l;
        MockHttpServletResponse response = aCalendarBy(id);
        assertEquals(HttpStatus.NOT_ACCEPTABLE.value(), response.getStatus());
    }

    private MockHttpServletResponse aCalendarBy(Long id) throws Exception {
        return restClient.perform(MockMvcRequestBuilders.get("/calendar/{id}", id)).andReturn().getResponse();
    }

    @Test
    public void shouldDeleteCalendar() throws Exception{
        CalendarDto calendarDto = new CalendarDto(CalendarDto.Builder.buildACalendar(NAME.value(), OWNER));
        Long id = calendarService.add(calendarDto);

        MockHttpServletResponse response = restClient.perform(MockMvcRequestBuilders.delete("/calendar/{id}", id)).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }


    @Test
    public void shouldUpdateCalendar() throws Exception{
        CalendarDto calendarDto = new CalendarDto(CalendarDto.Builder.buildACalendar(NAME.value(), OWNER));
        Long id = calendarService.add(calendarDto);

        MockHttpServletResponse response = restClient.perform(
                        MockMvcRequestBuilders.put("/calendar/{id}", id)
                                .param("name", NEW_NAME.value()))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        MockHttpServletResponse created = aCalendarBy(id);
        assertEquals("{\"name\":\"myCalendar\",\"owner\":{\"name\":\"Ola\",\"lastName\":\"Pe\",\"department\":\"SomeDept\"}}", created.getContentAsString());
        calendarService.remove(id);
    }


    @Test
    public void shouldAddCalendar() throws Exception{
        MockHttpServletResponse response = restClient.perform(
                        MockMvcRequestBuilders.post("/calendar")
                                .param("name", NAME.value())
                                .param("owner", OWNER.value()))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        String id = response.getContentAsString();
        MockHttpServletResponse created = aCalendarBy(Long.valueOf(id));
        assertEquals("{\"name\":\"" + NAME.value() +"\",\"owner\":\""+ OWNER.value() + "\"}", created.getContentAsString());
        calendarService.remove(Long.valueOf(id));
    }
}
