package pl.sda.jira.project.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.calendar.queries.QueryCriteriaDto;
import pl.sda.jira.project.model.Project;
import pl.sda.jira.project.model.ProjectDto;
import pl.sda.jira.project.model.ProjectQueriesService;
import pl.sda.jira.project.repository.ProjectRepository;



import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProjectQueriesServiceTest {

    @Autowired
    private ProjectRepository repository;
    private ProjectQueriesService service;

    @Before
    public void setUp() throws Exception {
        service = new ProjectQueriesService(repository);
        Project project1 = new Project(new ProjectDto("awesome", "marta"));
        repository.add(project1);

        Project project2 = new Project(new ProjectDto("super", "marta"));
        repository.add(project2);

        Project project3 = new Project(new ProjectDto("super-duper", "marta"));
        repository.add(project3);
    }

    @After
    public void tearDown() throws Exception {
        repository.deleteAll();
    }

    @Test
    public void shouldReturnListProjectsDtoWhenAuthorIsGiven() throws Exception {

       QueryCriteriaDto query=new QueryCriteriaDto("author","equals","marta");
        List<ProjectDto> projectsBy = service.getProjectsBy(query);
        assertEquals(3,projectsBy.size());
        assertEquals("marta",projectsBy.get(0).getAuthor());
    }

    @Test
    public void shouldReturnEmptyListWhenAuthorIsNotExists() throws Exception {

    QueryCriteriaDto query=new QueryCriteriaDto("author","equals","olaboga");
        List<ProjectDto> projectsBy = service.getProjectsBy(query);
        assertTrue(projectsBy.isEmpty());
}}
