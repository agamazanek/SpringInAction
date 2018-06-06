package pl.sda.jira.calendar.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.calendar.domain.Calendar;
import pl.sda.jira.calendar.persistency.inmemory.InMemoryCalendarRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/fake-calendar-repository.xml")
public class CalendarRepositoryTest {
    @Autowired private InMemoryCalendarRepository inMemoryCalendarRepository;
    @Autowired private Calendar calendar1;
    @Autowired private Calendar calendar2;
    @Autowired private Calendar calendar3;
    @Autowired private Calendar calendar4;
    @Autowired private Calendar calendar5;

    @Test
    public void shouldContainThreeCalendars() {
        assertEquals(5, inMemoryCalendarRepository.getAll().size());
    }

    @Test
    public void shouldExistCalendar1() {
        assertTrue(inMemoryCalendarRepository.isExist(calendar1));
    }

    @Test
    public void shouldExistCalendar2() {
        assertTrue(inMemoryCalendarRepository.isExist(calendar2));
    }

    @Test
    public void shouldExistCalendar4() {
        assertTrue(inMemoryCalendarRepository.isExist(calendar4));
    }

    @Test
    public void shouldExistCalendar5() {
        assertTrue(inMemoryCalendarRepository.isExist(calendar5));
    }

    @Test
    public void shouldBeTrueIfNamesOfCalendarOneAdnTwoIsTheSame() {
        assertEquals(calendar1.getCalendarName(), calendar2.getCalendarName());
    }

}