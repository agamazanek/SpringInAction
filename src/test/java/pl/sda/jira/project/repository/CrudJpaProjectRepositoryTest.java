package pl.sda.jira.project.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.project.domain.Project;
import pl.sda.jira.project.domain.ProjectDto;
import java.util.Optional;
import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CrudJpaProjectRepositoryTest {

    @Autowired
    CrudJpaProjectRepository repository;

    @Test
    public void shouldAddProject() throws Exception {
        String name = "Wall";
        Project project = createdProject(name);
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

        Optional<Project> projectByName = repository.getProjectByName(name);
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
