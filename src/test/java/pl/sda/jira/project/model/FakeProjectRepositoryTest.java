package pl.sda.jira.project.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/fake-project-repository.xml")
public class FakeProjectRepositoryTest {
    @Autowired private FakeProjectRepository fakeProjectRepository;

    @Test
    public void shouldContainThreeProjects() {
        assertEquals(5, fakeProjectRepository.getAllProjects().size());
    }



}