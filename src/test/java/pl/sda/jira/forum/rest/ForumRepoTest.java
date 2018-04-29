package pl.sda.jira.forum.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.forum.domain.Forum;
import pl.sda.jira.forum.domain.ForumRepo;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jira-sda-app-test.xml")
public class ForumRepoTest {
    @Autowired
    private ForumRepo forumRepo;

    @Test
    public void shouldContainTwoParameters() {
        assertEquals(3, forumRepo.getAll().size());
    }
}
