package pl.sda.jira.calendar.rest.domain.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.calendar.domain.dto.CalendarDto;
import pl.sda.jira.calendar.domain.model.Name;
import pl.sda.jira.calendar.domain.model.Owner;
import pl.sda.jira.calendar.domain.service.CalendarService;
import pl.sda.jira.calendar.rest.exception.CalendarNotFoundException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static pl.sda.jira.calendar.domain.dto.CalendarDto.Builder.buildACalendar;
//import static pl.sda.jira.calendar.domain.dto.CalendarDto.Builder.aCalendar;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CalendarServiceTest {

    @Autowired private CalendarService calendarService;

    private Name calendarName;
    private Owner ownerName;


    @Test (expected = CalendarNotFoundException.class)

    public void shouldThrowExceptionWhenCalendarDoesNotExist(){
       Long id = 324354l;
       calendarService.findBy(id);
    }

    @Test

    public void shouldFindCalendar() throws Exception{
        calendarName = new Name("Calendar 1");
        ownerName = new Owner("Ola", "Pe", "SomeDept");
        Name newName = new Name("Calendar 1234");


        CalendarDto calendarDto = createCalendarDto();
        Long id = calendarService.add(calendarDto);
        CalendarDto saved = calendarService.findBy(id);
        assertEquals(calendarDto.getName().value(), saved.getName().value());
        calendarService.remove(id);
    }

    @Test
    public void shouldAddCalendar() throws Exception {
        calendarName = new Name("Calendar 2");
        ownerName = new Owner("Olga", "Pe", "SomeDept");
        Name newName = new Name("Calendar 123434");
        CalendarDto calendarDto = createCalendarDto();
        Long id = calendarService.add(calendarDto);
        CalendarDto created = calendarService.findBy(id);
        assertEquals(calendarDto.getName().value(), created.getName().value());
        calendarService.remove(id);
    }

    @Test
    public void shouldRemoveCalendar()throws Exception {
        calendarName = new Name("Calendar 23");
        ownerName = new Owner("Olga", "Pepe", "SomeDept");
        Name newName = new Name("Calendar 3434");
        Long id = calendarService.add(createCalendarDto());
        calendarService.remove(id);

        assertCalendarDoesNotExist(id);
    }

    private void assertCalendarDoesNotExist(Long id) {
        calendarName = new Name("Calendar 23");
        ownerName = new Owner("Olga", "Pepe", "SomeDept");
        Name newName = new Name("Calendar 3434");
        id = 353254L;
        try {
            calendarService.findBy(id);
            fail("Calendar should not be found.");
        } catch (CalendarNotFoundException exception) {
            assertEquals("Calendar id: " + id + " does not exist.", exception.getMessage());
        }
    }

    @Test
    public void shouldUpdateCalendar() throws Exception {
        calendarName = new Name("Calendar 2343");
        ownerName = new Owner("Ola", "Pepe", "SomeDept");
        Name newName = new Name("Calendar 335434");
        Long id = calendarService.add(createCalendarDto());
        CalendarDto created = calendarService.findBy(id);
        calendarService.update(id, aCalendarDtoWith(newName));
        CalendarDto updated = calendarService.findBy(id);
        assertEquals(newName.value(), updated.getName().value());
        //assertTrue(created.hasSameName(NEW_NAME));
        calendarService.remove(id);
    }

    private CalendarDto createCalendarDto() {
        return aCalendarDtoWith(calendarName);
    }

//    private CalendarDto aCalendarDtoWith(String name) {
//        return aCalendar(name, OWNER_NAME).build();
//    }
    private CalendarDto aCalendarDtoWith(Name name){
        return buildACalendar(name, ownerName).build();
    }

}
