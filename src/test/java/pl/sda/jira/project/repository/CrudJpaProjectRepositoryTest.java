package pl.sda.jira.project.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.project.model.Project;
import pl.sda.jira.project.model.ProjectDto;
import pl.sda.jira.project.model.ProjectManager;
import pl.sda.jira.project.model.ProjectName;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CrudJpaProjectRepositoryTest {

    @Autowired
    CrudJpaProjectRepository repository;

    @Test
    public void shouldAddProject() throws Exception {
        String name = "Wall";
        ProjectManager manager=new ProjectManager("sebastian","malaca","sda");
        Project project = createdProject(name);
        project.setManager(manager);
        repository.save(project);
        assertTrue(repository.exists(project.getId()));
    }

    public Project createdProject(String name) {
        return new Project(new ProjectDto(name));
    }

    @Test
    public void shouldGetProjectByName() throws Exception {
        String name = "Animals";
        Project project = createdProject(name);
        repository.save(project);

        Optional<Project> projectByName = repository.getProjectByName(new ProjectName(name));
        Project theSameProject = projectByName.get();

        assertEquals(name,theSameProject.getName());

    }

    @Test
    public void shouldDeleteProject() throws Exception {
        String name="FinalCut";
        Project project=createdProject(name);
        repository.save(project);
        repository.delete(project.getId());

        assertFalse(repository.exists(project.getId()));
    }

}
