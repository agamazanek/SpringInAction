package pl.sda.jira.project.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.project.model.Project;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CrudJpaProjectRepositoryAnnotationQueriesTest {

    @Autowired
    CrudJpaProjectRepository repository;
    private Long id;

    @Before
    public void init(){
        Project firstProject = new Project("first","mateusz");
        id = repository.save(firstProject).getId();

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
    public void shouldFindAuthorByProjectName(){
        List<Project> result = repository.findAuthorByProjectName("first");
        assertEquals(2,result.size());
    }

    @Test
    public void shouldFindProjectsByAuthor(){
        List<Project> result = repository.findProjectsByAuthor("marta");
        assertEquals(2,result.size());
     }

    @Test
   public void shouldFindProjectById(){
        Optional<Project> result = repository.findById(id);
        assertEquals("mateusz",result.get().getAuthor());
    }

}