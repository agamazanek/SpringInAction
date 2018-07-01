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
public class CrudJpaForumRepositoryMethodQueriesTest {
    @Autowired private CrudJpaForumRepository repository;

    private String forumId;

    @Before
    public void init(){
        Forum forum1 = new Forum("FirstForum");
        Forum forum2 = new Forum("SecondForum");
        Forum forum3 = new Forum("ThirdForum");
        Forum forum4 = new Forum("FirstForum");

        forumId = repository.save(forum1).getForumId();
        repository.save(forum2);
        repository.save(forum3);
        repository.save(forum4);
    }

    @After
    public void tearDown(){
        repository.deleteAll();
    }

    @Test
    public void shouldFindByName() {
        List<Forum> forum = repository.findByName("FirstForum");

        assertEquals(2, forum.size());
    }

    @Test
    public void shouldCountByName() {
        assertEquals(2, repository.countByName("FirstForum"));
    }

    @Test
    public void shouldFindByForumId() {
        Forum byForumId = repository.findByForumId(forumId);

        assertEquals("FirstForum "+ forumId, byForumId.toString());
    }
}
