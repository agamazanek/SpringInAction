package pl.sda.jira.calendar.rest.persistency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.calendar.domain.CrudJpaCalendarRepository;
import pl.sda.jira.calendar.domain.model.Calendar;
import pl.sda.jira.calendar.domain.model.Owner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CrudJpaCalendarRepositoryTest {
    @Autowired private CrudJpaCalendarRepository repository;


    private String name = "calendar1";
    private Owner owner = new Owner("OlaPe", "Pe", "IT");
    private Calendar calendar = new Calendar(name, owner);

    @Test
    public void shouldAddCalendar() {

        Calendar saved = repository.save(calendar);

        assertEquals(name, saved.asDto().getName());
        assertNotNull(saved.getId());
    }

    @Test
    public void shouldRemoveCalendar() {

        Calendar saved = repository.save(calendar);
        repository.delete(saved.getId());
        assertFalse(repository.exists(saved.getId()));
    }

    @Test
    public void shouldUpdateCalendar() {
        String newName = "calendarium";
        Calendar saved = repository.save(calendar);
        saved.changeName(newName);
        assertEquals(newName, saved.asDto().getName());
    }

    @Test
    public void shouldGetCalendar(){
        Calendar saved = repository.save(calendar);
        Calendar sameCalendar = repository.findOne(saved.getId());
        assertEquals(saved.asDto().getName(), sameCalendar.asDto().getName());

    }

}
