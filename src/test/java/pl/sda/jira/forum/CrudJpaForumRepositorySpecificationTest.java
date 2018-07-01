package pl.sda.jira.forum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.jira.forum.domain.*;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest

public class CrudJpaForumRepositorySpecificationTest {
    @Autowired
    private CrudJpaForumRepository repository;
    private String forumId;
    private String forumId2;
    private String forumId0;

    Forum forum0 = new Forum("TheBestForum");
    Forum forum1 = new Forum("FirstForum");
    Forum forum2 = new Forum("SecondForum");
    Forum forum3 = new Forum("ThirdForum");
    Forum forum4 = new Forum("FirstForum");


    @Before
    public void init(){

        forumId0 = repository.save(forum0).getForumId();
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
    public void shouldFindByForumIdSpecification() {
        Forum byForumIdSpecification = repository.findOne(new ByForumIdForumSpecification(forum0.getForumId()));

        assertEquals("TheBestForum " + forumId0, byForumIdSpecification.toString());
    }

    @Test
    public void shouldFindByNameAndForumIdSpecification() {
        Forum byNameAndForumIdSpecification = repository.findOne(new ByNameForumSpecification(forum0.getName()));

        assertEquals(forum0.getName() + " " + forum0.getForumId(),byNameAndForumIdSpecification.toString());
    }

    @Test
    public void shouldFindByNameOrForumId() {
        Specification<Forum> specification = Specifications
                .where(ForumSpecifications.byName(forum1.getName()))
                .or(ForumSpecifications.byForumId(forum1.getForumId()));


    }

}
