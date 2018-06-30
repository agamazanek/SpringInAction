package pl.sda.jira.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CrudJpaTemplateRepositoryTest {
    @Autowired private CrudJpaTemplateRepository repository;

    @Test
    public void shouldAddTemplate() {
        String name = "peter";
        Template template = new Template(name, "parker");

        Template saved = repository.save(template);

        assertEquals(name, saved.getName());
        assertNotNull(saved.getId());
    }
}