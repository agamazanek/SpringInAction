package pl.sda.jira.calendar.rest.domain.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.calendar.domain.dto.CalendarDto;
import pl.sda.jira.calendar.domain.service.CalendarService;
import pl.sda.jira.calendar.rest.exception.CalendarNotFoundException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static pl.sda.jira.calendar.domain.dto.CalendarDto.Builder.aCalendar;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CalendarServiceTest {

    @Autowired private CalendarService calendarService;

    private static final String CALENDAR_NAME = "Calendar 1";
    private static final String OWNER = "OlaPe";
    private static final String NEW_NAME = "Calendar 1234";
    private static final Long ID = 324354l;


    @Test (expected = CalendarNotFoundException.class)
    public void shouldThrowExceptionWhenCalendarDoesNotExist(){
        calendarService.findBy(ID);
    }

    @Test
    public void shouldFindCalendar() throws Exception{
        CalendarDto calendarDto = createCalendarDto();
        Long id = calendarService.add(calendarDto);
        CalendarDto saved = calendarService.findBy(id);
        assertEquals(calendarDto.getName(), saved.getName());
        calendarService.remove(id);
    }

    @Test
    public void shouldAddCalendar() throws Exception {
        CalendarDto calendarDto = createCalendarDto();
        Long id = calendarService.add(calendarDto);
        CalendarDto created = calendarService.findBy(id);
        assertTrue(created.hasSameNameAs(CALENDAR_NAME));
        calendarService.remove(id);
    }

    @Test
    public void shouldRemoveCalendar()throws Exception {
        Long id = calendarService.add(createCalendarDto());
        calendarService.remove(id);

        assertCalendarDoesNotExist(id);
    }

    private void assertCalendarDoesNotExist(Long id) {
        try {
            calendarService.findBy(id);
            fail("Calendar should not be found.");
        } catch (CalendarNotFoundException exception) {
            assertEquals("Calendar id: " + id + " does not exist.", exception.getMessage());
        }
    }

    @Test
    public void shouldUpdateCalendar() throws Exception {
        Long id = calendarService.add(createCalendarDto());
        calendarService.update(id, aCalendarDtoWith(NEW_NAME));

        CalendarDto created = calendarService.findBy(id);
        assertTrue(created.hasSameNameAs(NEW_NAME));
        calendarService.remove(id);
    }

    private CalendarDto createCalendarDto() {
        return aCalendarDtoWith(CALENDAR_NAME);
    }

    private CalendarDto aCalendarDtoWith(String name) {
        return aCalendar(name, OWNER).build();
    }

}
