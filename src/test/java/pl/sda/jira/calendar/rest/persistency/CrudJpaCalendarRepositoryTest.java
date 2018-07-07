package pl.sda.jira.calendar.rest.persistency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.calendar.domain.CrudJpaCalendarRepository;
import pl.sda.jira.calendar.domain.CrudJpaOwnerRepository;
import pl.sda.jira.calendar.domain.model.Calendar;
import pl.sda.jira.calendar.domain.model.Meeting;
import pl.sda.jira.calendar.domain.model.Name;
import pl.sda.jira.calendar.domain.model.Owner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CrudJpaCalendarRepositoryTest {
    @Autowired private CrudJpaCalendarRepository repository;
    @Autowired private CrudJpaOwnerRepository ownerRepository;


    private String name = "calendar1";

    @Test
    public void shouldAddCalendar() {
        Owner owner1 = new Owner("Jon", "Snow", "Night's Watch");
        Calendar calendar = new Calendar(name, owner1);
        ownerRepository.save(owner1);
        calendar.assignToOwner(owner1);

        Calendar saved = repository.save(calendar);

        assertEquals(name, saved.asDto().getName());
        assertTrue(saved.belongsTo(owner1));
        assertNotNull(saved.getId());
    }

    @Test
    public void shouldRemoveCalendar() {
        Owner owner2 = new Owner("Cersei", "Lannister", "King's Landing");
        Calendar calendar = new Calendar(name, owner2);

        ownerRepository.save(owner2);
        calendar.assignToOwner(owner2);
        Calendar saved = repository.save(calendar);
        assertTrue(saved.belongsTo(owner2));
        repository.delete(saved.getId());
        assertFalse(repository.exists(saved.getId()));
    }

    @Test
    public void shouldUpdateCalendar() {
        Owner owner3 = new Owner("Jaime", "Lannister", "King's Landing");
        Calendar calendar = new Calendar(name, owner3);
        ownerRepository.save(owner3);
        calendar.assignToOwner(owner3);
        String newName = "calendarium";
        Calendar saved = repository.save(calendar);
        saved.changeName(newName);
        assertTrue(saved.belongsTo(owner3));
        assertEquals(newName, saved.asDto().getName());
    }

    @Test
    public void shouldGetCalendar(){
        Owner owner4 = new Owner("Daenerys", "Targaryen", "House Targaryen");
        Calendar calendar = new Calendar(name, owner4);
        ownerRepository.save(owner4);
        calendar.assignToOwner(owner4);
        Calendar saved = repository.save(calendar);
        Calendar sameCalendar = repository.findOne(saved.getId());
        assertTrue(saved.belongsTo(owner4));
        assertEquals(saved.asDto().getName(), sameCalendar.asDto().getName());
    }

    @Test
    public void shouldAddMeeting(){
        Name name = new Name("superCalendar");
        Owner owner5 = new Owner("Frodo", "Baggins", "Fellowship of the Ring");
        ownerRepository.save(owner5);
        Meeting meeting = new Meeting("Let's party!", "your place");
        Calendar calendar = new Calendar(name, owner5);
        calendar.addMeeting(meeting);
        repository.save(calendar);

        assertEquals("superCalendar", calendar.asDto().getName());
        assertEquals("Let's party!", meeting.getTitle());
    }
}
