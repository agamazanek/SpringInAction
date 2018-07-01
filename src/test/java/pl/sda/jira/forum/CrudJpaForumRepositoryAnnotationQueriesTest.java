package pl.sda.jira.forum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.forum.domain.CrudJpaForumRepository;
import pl.sda.jira.forum.domain.Forum;

import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest

public class CrudJpaForumRepositoryAnnotationQueriesTest {
    @Autowired
    private CrudJpaForumRepository repository;
    private String forumId;
    private String forumId2;

    Forum forum = new Forum("TheBestForum");

    @Before
    public void init(){
        Forum forum1 = new Forum("FirstForum");
        Forum forum2 = new Forum("SecondForum");
        Forum forum3 = new Forum("ThirdForum");
        Forum forum4 = new Forum("FirstForum");

        repository.save(forum);
        forumId = repository.save(forum1).getForumId();
        repository.save(forum2);
        repository.save(forum3);
        forumId2 = repository.save(forum4).getForumId();
    }

    @After
    public void tearDown(){
        repository.deleteAll();
    }

    @Test
    public void shouldCountByNameQuery() {
        List<String> result = repository.countByNameQuery("FirstForum");

        assertEquals(2, result.size());
        assertEquals(forumId, result.get(0));
        assertEquals(forumId2, result.get(1));
    }

    @Test
    public void shouldFindByForumIdQuery() {
        Forum byForumIdQuery = repository.findByForumIdQuery(forumId);

        assertEquals("FirstForum " + forumId, byForumIdQuery.toString());
    }

    @Test
    public void shouldFindByNameAndForumId() {
        Forum byNameAndForumId = repository.findByNameAndForumId(forum.getName(), forum.getForumId());

        assertEquals(forum.getName() + " " + forum.getForumId(),byNameAndForumId.toString());
    }
}
