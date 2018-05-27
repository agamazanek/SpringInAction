package pl.sda.jira.forum.domain;

import org.junit.Test;
import pl.sda.jira.forum.domain.Forum;
import pl.sda.jira.forum.domain.ForumRepository;
import pl.sda.jira.forum.domain.ForumService;
import pl.sda.jira.persistance.inmemory.InMemoryForumRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ForumServiceTest {


    @Test(expected = ForumDoesNotExistExcepton.class)
    public void shouldThrowExceptionWhenForumDoesNotExist(){
        ForumService forumService = new ForumService(new InMemoryForumRepository());
        int forumId = 123;

        forumService.get(forumId);

    }

    @Test
    public void shouldReturnForumWhenExist() {
        InMemoryForumRepository forumRepository = new InMemoryForumRepository();
        ForumService forumService = new ForumService(forumRepository);
        int forumId = 123;
        Forum forum = new Forum(forumId);
        forumRepository.add(forum);

        ForumDto forumDto = forumService.get(forumId);

        ForumDto expected = new ForumDto();
        expected.setId(forumId);

        assertEquals(expected, forumDto);
    }
}
