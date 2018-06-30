package pl.sda.jira.calendar.rest.persistency;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.calendar.domain.CrudJpaCalendarRepository;
import pl.sda.jira.calendar.domain.model.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CrudJpaCalendarRepositoryMethodQueriesTest {
    @Autowired private CrudJpaCalendarRepository repository;
    @Before
    public void init(){
        Calendar calendar = new Calendar("343", "calendar0", "Ola");
        Calendar calendar1 = new Calendar("4556", "calendar1", "Ala");
        Calendar calendar2 = new Calendar("5765", "calendar3", "Ola");

        repository.save(calendar);
        repository.save(calendar1);
        repository.save(calendar2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldFindByName() {
        assertEquals(1, repository.findByName("calendar1").size());
    }

    @Test
    public void shouldCountByOwner(){
        assertEquals (2, repository.countByOwner("Ola"));
    }

    @Test
    public void shouldFindFirstByNameOrOwner(){
        assertEquals("calendar3", repository.findFirstByNameOrOwner("calendar3", "Ola"));
        assertFalse(repository.findFirstByNameAndOwner("not found", "Ola").isPresent());
        assertFalse(repository.findFirstByNameAndOwner("calendar1", "not found").isPresent());
        assertFalse(repository.findFirstByNameAndOwner("should not found", "not found").isPresent());
    }
}
