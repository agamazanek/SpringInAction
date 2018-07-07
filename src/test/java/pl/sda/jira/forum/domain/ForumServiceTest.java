package pl.sda.jira.forum.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.forum.domain.exceptions.ForumDoesNotExistException;
import pl.sda.jira.forum.dto.ForumDto;
import pl.sda.jira.persistance.inmemory.InMemoryForumRepository;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ForumServiceTest {

    @Autowired
    private ForumRepository forumRepository;
    private ForumService forumService;
    private final long FORUMID = 123L;
    private final String NAME = "OWNER_NAME";
    private final String NAME1 = "NAME1";

    @Before
    public void setUp() throws Exception {
        forumService=new ForumService(forumRepository);
    }

    @Test(expected = ForumDoesNotExistException.class)
    public void shouldThrowExceptionWhenForumDoesNotExist() {
        forumService.get(FORUMID);

    }

    @Test
    public void shouldReturnForumWhenExist() {
        Forum givenForum = forumRepository.add(new Forum(NAME));
        ForumDto expectedDto = forumService.get(givenForum.getForumId());

        assertTrue(forumRepository.exists(givenForum.getForumId()));
        assertEquals(expectedDto.getName(), givenForum.getName());
    }

    @Test
    public void shouldAddForumWhenDoesNotExist() {
        ForumDto forumDto = new ForumDto(NAME);
        long identifier = forumService.add(forumDto);
        ForumDto forumVerification = forumService.get(identifier);

        assertEquals(forumDto, forumVerification);

    }

    @Test
    public void shouldRemoveForumWhenExist() {
        ForumDto forumDto = new ForumDto(NAME);

        long identifireForum = forumService.add(forumDto);

        forumService.remove(identifireForum);

        String forumExist = assertForumDoesNotExist(identifireForum);

        assertEquals("Forum should be not found", forumExist);
    }

    private String assertForumDoesNotExist(long identifireForum) {
        if (forumService.exist(identifireForum)) {
            return "Forum exists";
        } else {
            return "Forum should be not found";
        }
    }

    @Test
    public void shouldUpdateForum() {
        ForumDto forumDto = new ForumDto(NAME);

        long identifireForum = forumService.add(forumDto);

        forumService.update(identifireForum, new ForumDto(NAME1));

        ForumDto created = forumService.get(identifireForum);
        assertEquals(NAME1, created.getName());
    }
}
