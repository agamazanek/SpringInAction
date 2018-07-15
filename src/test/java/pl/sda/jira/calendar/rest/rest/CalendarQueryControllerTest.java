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
import pl.sda.jira.calendar.domain.model.Name;
import pl.sda.jira.calendar.domain.model.Owner;
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
        Name calendar0 = new Name("calenadr0");
        Owner owner0 = new Owner("Ola", "Pe", "SomeDept");
        CalendarDto calendarDto = new CalendarDto(CalendarDto.Builder.buildACalendar(calendar0.value()).withOwner(owner0.getName(), owner0.getLastName(), owner0.getDepartment()));

        Name calendar1 = new Name("calenadr1");
        Owner owner1 = new Owner("Ola", "Pe", "SomeDept");
        CalendarDto calendarDto1 = new CalendarDto(CalendarDto.Builder.buildACalendar(calendar1.value()).withOwner(owner1.getName(), owner1.getLastName(), owner1.getDepartment()));

        Name calendar3 = new Name("calenadr3");
        Owner owner3 = new Owner("Ala", "Pe", "SomeDept");
        CalendarDto calendarDto2= new CalendarDto(CalendarDto.Builder.buildACalendar(calendar3.value()).withOwner(owner3.getName(), owner3.getLastName(), owner3.getDepartment()));

        Name calendar2 = new Name("calenadr2");
        Owner owner2 = new Owner("AlaPe", "Pe", "SomeDept");
        CalendarDto calendarDto3= new CalendarDto(CalendarDto.Builder.buildACalendar(calendar2.value()).withOwner(owner2.getName(), owner2.getLastName(), owner2.getDepartment()));

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
        assertEquals("[{\"name\":\"calendar0\",\"owner\":\"Ola\"}]", response.getContentAsString());

    }

}
