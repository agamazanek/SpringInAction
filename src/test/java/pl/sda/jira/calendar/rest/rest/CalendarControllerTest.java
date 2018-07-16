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


    @Autowired private MockMvc restClient;
    @Autowired private CalendarService calendarService;

    @Test
    public void shouldGetCalendar() throws Exception {
        Name name = new Name("calendar909");
        Owner owner = new Owner("Ela", "Pe", "NewDept");
        CalendarDto calendarDto = new CalendarDto(CalendarDto.Builder.buildACalendar(name.value()).withOwner(owner.getName(), owner.getLastName(), owner.getDepartment()));
        Long id = calendarService.add(calendarDto);

        MockHttpServletResponse response = aCalendarBy(id);

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("{\"name\":\"calendar909\",\"ownerName\":\"Ela\",\"ownerLastName\":\"Pe\",\"ownerDepartment\":\"NewDept\"}", response.getContentAsString());
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
        Name name = new Name("calendar934");
        Owner owner = new Owner("Ala", "Pepe", "SomeDept");
        CalendarDto calendarDto = new CalendarDto(CalendarDto.Builder.buildACalendar(name.value()).withOwner(owner.getName(), owner.getLastName(), owner.getDepartment()));
        Long id = calendarService.add(calendarDto);

        MockHttpServletResponse response = restClient.perform(MockMvcRequestBuilders.delete("/calendar/{id}", id)).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }


    @Test
    public void shouldUpdateCalendar() throws Exception{
        Name name = new Name("calendar93434");
        Owner owner = new Owner("Ula", "Pepepe", "SomeDept");
        Name newName = new Name("myCalendar");
        CalendarDto calendarDto = new CalendarDto(CalendarDto.Builder.buildACalendar(name.value()).withOwner(owner.getName(), owner.getLastName(), owner.getDepartment()));
        Long id = calendarService.add(calendarDto);

        MockHttpServletResponse response = restClient.perform(
                        MockMvcRequestBuilders.put("/calendar/{id}", id)
                                .param("name", newName.value()))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        MockHttpServletResponse created = aCalendarBy(id);
         assertEquals("{\"name\":\"myCalendar\",\"ownerName\":\"Ula\",\"ownerLastName\":\"Pepepe\",\"ownerDepartment\":\"SomeDept\"}", created.getContentAsString());
    }


    @Test
    public void shouldAddCalendar() throws Exception{
        Name name = new Name("calendar9");
        Owner owner = new Owner("Ola", "Pe", "SomeDept");
        MockHttpServletResponse response = restClient.perform(
                        MockMvcRequestBuilders.post("/calendar")
                                .param("name", name.value())
                                .param("ownerName", owner.getName())
                                .param("ownerLastName", owner.getLastName())
                                .param("ownerDepartment", owner.getDepartment()))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        String id = response.getContentAsString();
        MockHttpServletResponse created = aCalendarBy(Long.valueOf(id));
        assertEquals("{\"name\":\"" + name.value() +"\",\"ownerName\":\""+ owner.getName() +"\",\"ownerLastName\":\""+ owner.getLastName() +"\",\"ownerDepartment\":\""+ owner.getDepartment()  + "\"}", created.getContentAsString());
    }


}
