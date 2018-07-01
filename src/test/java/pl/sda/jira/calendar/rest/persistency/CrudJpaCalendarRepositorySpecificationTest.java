package pl.sda.jira.calendar.rest.persistency;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.calendar.domain.CrudJpaCalendarRepository;
import pl.sda.jira.calendar.domain.model.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CrudJpaCalendarRepositorySpecificationTest {
    @Autowired private CrudJpaCalendarRepository repository;

    @Before
    public void init(){
        Calendar calendar0 = new Calendar("445454", "calendarium01", "OlaPe", "meeting0");
        Calendar calendar1 = new Calendar("554665", "calendarium11", "AlaPe", "meeting1");
        Calendar calendar2 = new Calendar("254643", "calendarium33", "OlaPe", "meeting1");
        Calendar calendar3 = new Calendar("5464", "calendarium33", "EwaPe", "meeting2");

        repository.save(calendar0);
        repository.save(calendar1);
        repository.save(calendar2);
        repository.save(calendar3);
    }
    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void shouldFindByName() {
        Calendar calendar = repository.findOne(new ByNameCalendarSpecification("calendarium01"));
        assertEquals("OlaPe", calendar.getOwner());
    }

    @Test
    public void shouldFindAllExceptName() {
        Specification<Calendar> specifications = Specifications
                .not(new ByNameCalendarSpecification("calendarium33"));

        List<Calendar> result = repository.findAll(specifications);
        assertEquals(2, result.size());
        assertEquals("calendarium01", result.get(0).asDto().getName());
        assertEquals("calendarium11", result.get(1).asDto().getName());
    }

    @Test
    public void shouldFindByEvent(){

        List<Calendar> result = repository.findAll(new ByEventCakendarSpecification("meeting1"));
        assertEquals(2, result.size());
        assertEquals("calendarium11", result.get(0).asDto().getName());
        assertEquals("calendarium33", result.get(1).asDto().getName());
    }

    @Test
    public void shouldFindAllExceptNameOrEqualToEvent() {
        Specification<Calendar> specifications = Specifications
                .not(new ByNameCalendarSpecification("calendarium33"))
                .or(new ByEventCakendarSpecification("meeting1"));

        List<Calendar> calendars = repository.findAll(specifications);

        assertEquals(3, calendars.size());
        assertEquals("calendarium11", calendars.get(1).asDto().getName());
        assertEquals("calendarium01", calendars.get(0).asDto().getName());
        assertEquals("calendarium33", calendars.get(2).asDto().getName());

    }

}
