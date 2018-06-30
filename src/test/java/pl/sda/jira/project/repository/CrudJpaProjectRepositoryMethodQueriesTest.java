package pl.sda.jira.project.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.project.model.Project;
import pl.sda.jira.project.model.ProjectDto;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CrudJpaProjectRepositoryMethodQueriesTest {

    @Autowired
    CrudJpaProjectRepository repository;

    @Before
    public void init(){
        Project firstProject = new Project("first","mateusz");
        repository.save(firstProject);

        Project secondProject = new Project("second","marta");
        repository.save(secondProject);

        Project projectWithSameName = new Project("first","marta");
        repository.save(projectWithSameName);

    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void shouldCountByName(){
        assertEquals(2,repository.countByName("first"));
    }

    @Test
    public void shouldFindFirstByName(){
        Project project = repository.findFirstByName("first");
        Long l = 1L;
        assertEquals(l, project.getId());
    }
    @Test
    public void shouldFindFirstByAuthorOrName() {
        assertTrue(repository.findFirstByAuthorOrName("marta","second").isPresent());

    }



}