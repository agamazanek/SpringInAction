package pl.sda.jira.project.controler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.sda.jira.project.model.Project;
import pl.sda.jira.project.model.ProjectDto;
import pl.sda.jira.project.repository.CrudJpaProjectRepository;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectQueriesControllerTest {

    private Long id;
    @Autowired
    CrudJpaProjectRepository repository;
    @Autowired
    private MockMvc chrome;

    @Before
    public void init() {
        Project firstProject = new Project(new ProjectDto("first", "mateusz"));
        repository.save(firstProject);

        Project secondProject = new Project(new ProjectDto("second", "marta"));
        repository.save(secondProject);

        Project anotherOne = new Project(new ProjectDto("third", "marta"));
        repository.save(anotherOne);

    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void shouldGetProjectsByAuthor() throws Exception {
        String columnName = "author";
        String type = "equals";
        String value="marta";

        MockHttpServletResponse projectList = chrome.perform(MockMvcRequestBuilders.
                post("/projects")
                .param("name", columnName)
                .param("type", type)
                .param("value",value)

        ).andReturn().getResponse();


        assertEquals(HttpStatus.OK.value(), projectList.getStatus());
        assertEquals("[{\"name\":\"" + columnName +"\"},{\"value\":\"" + value +"\"}]",projectList.getContentAsString());
    }

    @Test
    public void shouldGetProjectsByName() throws Exception {
        String columnName = "name";
        String type = "equals";
        String value="first";

        MockHttpServletResponse projectList = chrome.perform(MockMvcRequestBuilders.
                post("/projects")
                .param("name", columnName)
                .param("type", type)
                .param("value",value)


        ).andReturn().getResponse();


        assertEquals(HttpStatus.OK.value(), projectList.getStatus());
    }
}