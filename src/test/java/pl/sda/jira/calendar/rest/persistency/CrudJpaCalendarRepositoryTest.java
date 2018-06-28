package pl.sda.jira.calendar.rest.persistency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.calendar.domain.CrudJpaCalendarRepository;
import pl.sda.jira.calendar.domain.model.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CrudJpaCalendarRepositoryTest {
    @Autowired private CrudJpaCalendarRepository repository;

    @Test
    public void shouldAddCalendar() {
        String id = "3423423";
        String name = "calendar1";
        Calendar calendar = new Calendar(id, name);

       Calendar saved = repository.save(calendar);

        assertEquals(name, saved.asDto().getName());
        assertNotNull(saved.getId());
    }
}
