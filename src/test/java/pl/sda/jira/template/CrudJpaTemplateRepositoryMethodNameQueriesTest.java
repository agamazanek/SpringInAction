package pl.sda.jira.template;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CrudJpaTemplateRepositoryMethodNameQueriesTest {
    @Autowired private CrudJpaTemplateRepository repository;

    @Before
    public void init() {
        Template peterParker = new Template("peter", "parker");
        peterParker.setDescription("some spider");
        repository.save(peterParker);

        Template maryJane = new Template("mary jane", "watson");
        maryJane.setDescription("strong woman");
        repository.save(maryJane);

        Template peterDoe = new Template("peter", "doe");
        peterDoe.setDescription("some strong guy");
        repository.save(peterDoe);

        Template peterR = new Template("peter", "rasputin");
        peterR.setDescription("some strong guy");
        repository.save(peterR);
    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void shouldFindByName() {
        assertEquals(2, repository.findFirst2ByName("peter").size());
        assertEquals(1, repository.findFirst2ByName("mary jane").size());
    }

    @Test
    public void shouldCountByName() {
        assertEquals(3, repository.countByName("peter"));
    }

    @Test
    public void shouldFindFirstByName() {
        Template template = repository.findFirstByName("peter");

        assertEquals("peter parker", template.getFullName());
    }

    @Test
    public void shouldFindFirstByDescriptionOrName() {
        assertEquals("mary jane watson", repository.findFirstByDescriptionOrName("not found", "mary jane").get().getFullName());
        assertEquals("mary jane watson", repository.findFirstByDescriptionOrName("strong woman", "not found").get().getFullName());
        assertFalse(repository.findFirstByDescriptionOrName("should not found", "not found").isPresent());
    }

    @Test
    public void shouldFindFirstByDescriptionAndName() {
        assertEquals("mary jane watson", repository.findFirstByDescriptionOrName("strong woman", "mary jane").get().getFullName());
        assertFalse(repository.findFirstByDescriptionAndName("not found", "mary jane").isPresent());
        assertFalse(repository.findFirstByDescriptionAndName("strong woman", "not found").isPresent());
        assertFalse(repository.findFirstByDescriptionAndName("should not found", "not found").isPresent());
    }

    @Test
    public void shouldFindLastByName() {
        Template template = repository.findFirstByNameOrderByLastNameDesc("peter");

        assertEquals("peter rasputin", template.getFullName());
    }
}
