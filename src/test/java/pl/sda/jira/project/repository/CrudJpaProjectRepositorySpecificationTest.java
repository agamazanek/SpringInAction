package pl.sda.jira.project.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.project.model.Project;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CrudJpaProjectRepositorySpecificationTest {

    private Long id;
    @Autowired
    CrudJpaProjectRepository repository;

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
    public void shouldFindProjectByName()  {
       List<Project> projects = repository.findAll(new ByNameProjectSpecification("first"));
       assertEquals(2,projects.size());
    }

    @Test
    public void findProjectById()  {
        Project project = repository.findOne(new ByIdProjectSpecification(id));
        assertEquals("mateusz",project.getAuthor());
    }

    @Test
    public void findProjectByAuthorOrName() {
        Specification<Project> specification = Specifications
                .where(new ByNameProjectSpecification("second"))
                .or(new ByAuthorProjectSpecification("mateusz"));

        List<Project> projects = repository.findAll(specification);

        assertEquals(2,projects.size());
    }

    @Test
    public void findAuthorByProjectName() {
    }

    @Test
    public void findProjectsByAuthor() {
       List <Project> projects = repository.findAll(new ByAuthorProjectSpecification("marta"));
       assertEquals(2,projects.size());
    }

    @Test
    public void findById() throws Exception {
    }

}