package pl.sda.jira.project.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.jira.project.model.*;

public class ProjectServiceTest {
    
    private ProjectService service;
    private Project project;
    private ProjectRepositoryInmemory repository;

    @Before
    public void setUp() throws Exception {
        repository = new ProjectRepositoryInmemory();
        service = new ProjectService(repository);
        project = new Project();
        project.setId(1L);
    }

    @Test(expected = ProjectDoesntExistException.class)
    public void shouldThrowExceptionWhenProjectDoesntExist() throws Exception {

        long projectId = 1L;
        service.get(projectId);

    }

    @Test
    public void shouldReturnProjectWhenProjectExists() throws Exception {

        service.add(project);
        Project result = service.get(project.getId());
        Assert.assertEquals(project, result);

    }

    @Test(expected = ProjectAlreadyExistsException.class)
    public void shouldThrowExceptionIfProjectAlreadyExists() throws Exception {

        Project project = new Project();
        project.setId(1L);
        service.add(project);
        service.add(project);
    }

    @Test(expected = ProjectDoesntExistException.class)
    public void shouldThrowExceptionIfWhenDeletedProjectIsNotExist() throws Exception {

        long projectId = 1L;
        service.delete(projectId);
    }

    @Test
    public void shouldDeleteProject() throws Exception {

        service.add(project);
        service.delete(project.getId());
        Assert.assertFalse(repository.isExist(project.getId()));

    }
}
