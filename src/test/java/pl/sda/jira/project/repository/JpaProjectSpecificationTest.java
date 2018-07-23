package pl.sda.jira.project.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.calendar.queries.QueryCriteriaDto;
import pl.sda.jira.project.model.Project;
import pl.sda.jira.project.model.ProjectDto;
import pl.sda.jira.project.model.ProjectName;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JpaProjectSpecificationTest {

    @Autowired
    private CrudJpaProjectRepository repository;

    @Before
    public void setUp() throws Exception {
        Project project1 = new Project(new ProjectDto("awesome", "marta"));
        repository.save(project1);

        Project project2 = new Project(new ProjectDto("super", "marta"));
        repository.save(project2);

        Project project3 = new Project(new ProjectDto("super-duper", "marta"));
        repository.save(project3);
    }
    @After
    public void tearDown() {
        repository.deleteAll();
    }


    @Test
    public void shouldReturnProjectWhenNameIsGiven() throws Exception {
        ProjectSpecification spec = givenSpecification("name", "equals", new ProjectName("awesome"));
        Project result = repository.findOne(spec);

        assertEquals("awesome",result.getName());
        assertEquals("marta",result.getAuthor());

    }

    private ProjectSpecification givenSpecification(String name, String type, Object value) {
        QueryCriteriaDto criteria=new QueryCriteriaDto(name,type,value);
        return new ProjectSpecification(criteria);
    }

    @Test
    public void shouldReturnProjectsWhenNameAndAuthorIsGiven() throws Exception {
        ProjectSpecification spec1=givenSpecification("name","equals",new ProjectName("awesome"));
        ProjectSpecification spec2=givenSpecification("author","equals","marta");
        List<Project> result = repository.findAll(Specifications.where(spec1).or(spec2));

        assertEquals(3,result.size());
    }

    @Test
    public void shouldReturnProjectsWithoutGivenAuthor() throws Exception {
        ProjectSpecification spec=givenSpecification("author","not","endrju");
        List<Project> result = repository.findAll(spec);

        assertEquals(3,result.size());
    }

    @Test
    public void shouldReturnProjectsWhenPartAuthorIsGiven() throws Exception {
        ProjectSpecification spec=givenSpecification("author","%like%","ar");
        List<Project> result = repository.findAll(spec);

        assertEquals(3,result.size());
    }
}
