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
import pl.sda.jira.calendar.domain.model.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalendarQueryControllerTest {
    @Autowired private CrudJpaCalendarRepository repository;

    @Before
    public void init(){
        Calendar calendar = new Calendar("344535643", "calendar0", "Ola");
        Calendar calendar1 = new Calendar("44ty6556", "calendar1", "Ala");
        Calendar calendar2 = new Calendar("574t65", "calendar3", "Ola");

        repository.save(calendar);
        repository.save(calendar1);
        repository.save(calendar2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Autowired
    private MockMvc restClient;

    @Test
    public void shouldGetCalendarEqualToName() throws Exception {

        MockHttpServletResponse response = restClient.perform(
                MockMvcRequestBuilders.post("/calendars")
                        .param("name", "name")
                        .param("value", "calendar0")
                        .param("type", "equals"))
                        .andReturn().getResponse();


        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("namecalendar0equals", response.getContentAsString());

    }
}
