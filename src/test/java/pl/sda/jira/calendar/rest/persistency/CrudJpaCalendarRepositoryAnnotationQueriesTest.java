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

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CrudJpaCalendarRepositoryAnnotationQueriesTest {
    @Autowired private CrudJpaCalendarRepository repository;


    @Before
    public void init(){
        Calendar calendar = new Calendar("454", "calendarium0", "OlaP");
        Calendar calendar1 = new Calendar("565", "calendarium1", "AlaP");
        Calendar calendar2 = new Calendar("243", "calendarium3", "OlaP");

        repository.save(calendar);
        repository.save(calendar1);
        repository.save(calendar2);
    }
    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void shouldFindCalendarByOwner() {
        List<String> result = repository.findCalendarByOwner("OlaP");

        assertEquals(2, result.size());
        assertEquals("calendarium0", result.get(0));
    }
}
