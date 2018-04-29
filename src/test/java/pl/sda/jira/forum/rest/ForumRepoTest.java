package pl.sda.jira.forum.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.forum.domain.ForumRepo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jira-sda-app-test.xml")
public class ForumRepoTest {
    @Autowired
    private ForumRepo forumRepo;

    @Test
    public void shouldContainTwoParameters() {
        assertEquals(5, forumRepo.getAll().size());
    }

    @Test
    public void shouldHaveCorrectElements() {
        assertEquals("NAME", forumRepo.getAll().get(0).getName());
        assertEquals("SPACE_ID", forumRepo.getAll().get(1).getSpaceId());
        assertTrue(forumRepo.getAll().get(0).getTopics().isEmpty());
    }
}
