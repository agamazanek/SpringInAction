package pl.sda.jira.forum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jira-sda-app.xml")

public class ForumControllerTest {

    @Test
    public void shouldExistSpaceForum() {
        ForumController forumController = new ForumController();
        String spaceId = UUID.randomUUID().toString();

        boolean notExist = forumController.existForum(spaceId);

        Assert.assertFalse(notExist);
    }

}
// Czy jest forum, czy jest space