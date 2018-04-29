package pl.sda.jira.calendar.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.calendar.domain.Calendar;
import pl.sda.jira.calendar.domain.CalendarRepository;
import pl.sda.jira.calendar.persistency.inmemory.InMemoryCalendarRepository;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/fake-calendar-repository.xml")
public class CalendarRepositoryTest {

    @Autowired private InMemoryCalendarRepository inMemoryCalendarRepository;
    @Autowired private Calendar calendar;
    @Autowired private Calendar calendarium;

    @Test
    public void shouldContainTwoCalendars() {
        assertEquals(2, inMemoryCalendarRepository.getAll().size());
    }

    @Test
    public void shouldContainCalendarId() {Assert.assertTrue(inMemoryCalendarRepository.getAll().contains(calendar));}

    @Test
    public void shouldContainCalendariumId() {Assert.assertTrue(inMemoryCalendarRepository.getAll().contains(calendarium));}

    @Test
    public void shouldHaveSameNameAsCalendar() {assertEquals("myCalendar", calendar.getName());}

    @Test
    public void shouldHaveSameNameAsCalendarium() {assertEquals("myCalendarium", calendarium.getName());}


}
