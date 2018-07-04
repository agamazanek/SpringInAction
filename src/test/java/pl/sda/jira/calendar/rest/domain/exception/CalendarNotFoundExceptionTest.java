package pl.sda.jira.calendar.rest.domain.exception;

import org.junit.Test;
import pl.sda.jira.calendar.rest.exception.CalendarNotFoundException;


import static org.junit.Assert.assertEquals;

public class CalendarNotFoundExceptionTest {

    private static final Long SOME_ID = 675l;

    @Test
    public void shouldShowAppropriateMessage(){
        CalendarNotFoundException exception = new CalendarNotFoundException(SOME_ID);
        assertEquals("Calendar id: " + SOME_ID + " does not exist.", exception.getMessage());
    }
}
