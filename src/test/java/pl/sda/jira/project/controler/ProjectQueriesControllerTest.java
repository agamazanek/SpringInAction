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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.sda.jira.project.model.Project;
import pl.sda.jira.project.model.ProjectName;
import pl.sda.jira.project.repository.CrudJpaProjectRepository;

import java.util.Collection;
import java.util.List;

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
        Project firstProject = new Project("first", "mateusz");
        id = repository.save(firstProject).getId();

        Project secondProject = new Project("second", "marta");
        repository.save(secondProject);

        Project projectWithSameName = new Project("first", "marta");
        repository.save(projectWithSameName);

    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void shouldGetProjectsByName() throws Exception {
        String columnName = "name";
        String name = "first";
        String type = "equals";

        MockHttpServletResponse projectList = chrome.perform(MockMvcRequestBuilders.
                post("/projects")
                .param("columnName", columnName)
                .param("value", name)
                .param("type", type)

        ).andReturn().getResponse();


        assertEquals(HttpStatus.OK.value(), projectList.getStatus());
//        assertEquals("[{\"name\":\"" + name +"\"},{\"name\":\"" + name +"\"}]",projectList.getContentAsString());
    }
}