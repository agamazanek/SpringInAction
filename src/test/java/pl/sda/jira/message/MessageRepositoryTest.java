package pl.sda.jira.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/fake-message-repository.xml")
public class MessageRepositoryTest {
    @Autowired private MessageRepository messageRepository;

    @Test
    public void shouldContainThreeMessages() {
        assertEquals(3, messageRepository.getAll().size());
    }


}