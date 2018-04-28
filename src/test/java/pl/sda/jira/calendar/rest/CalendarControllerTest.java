package pl.sda.jira.calendar.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.calendar.domain.Calendar;
import pl.sda.jira.calendar.domain.CalendarRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jira-sda-app.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CalendarControllerTest {
    private static final String SOME_PERSON_ID = "13";

    @Autowired private CalendarRepository calendarRepository;
    @Autowired private CalendarController calendarController;

    @Test
    public void calendarShouldNotExistForGivenSpace() {
        boolean exists = calendarController.existsForPerson(SOME_PERSON_ID);

        assertFalse(exists);
    }

    @Test
    public void calendarShouldExistForGivenSpace() {
        calendarRepository.add(new Calendar());

        boolean exists = calendarController.existsForPerson(SOME_PERSON_ID);

        assertTrue(exists);
    }
}