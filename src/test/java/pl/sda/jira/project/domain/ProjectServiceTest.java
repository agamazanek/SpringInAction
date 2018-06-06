package pl.sda.jira.project.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.jira.project.model.*;

public class ProjectServiceTest {
private ProjectService service;

    @Before
    public void setUp() throws Exception {
        service = new ProjectService(new ProjectRepositoryInmemory());
    }

    @Test(expected = ProjectDoesntExistException.class)
    public void shouldThrowExceptionWhenProjectDoesntExist() throws Exception {


        long projectId = 1L;
        service.get(projectId);

    }

    @Test
    public void shouldReturnProjectWhenProjectExists() throws Exception {
        Project project=new Project();
        long projectId = 1L;
        project.setId(projectId);
        service.add(project);
        Project result = service.get(projectId);
        Assert.assertEquals(project,result);
        
    }

    @Test
    public void name() throws Exception {
    }
}
