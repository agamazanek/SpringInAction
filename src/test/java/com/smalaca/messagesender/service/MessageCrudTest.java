package com.smalaca.messagesender.service;

import com.smalaca.messagesender.domain.MessageRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/message-sender.xml")
public class MessageCrudTest {
    @Autowired private MessageRepository messageRepository;
    @Autowired private MessageCrud yetAnotherMessageCrud;

    @Test
    public void shouldCreateNewMessage() {

        String subject = "subject";
        String body = "body";
        String from = "from";
        String to = "to";

        String id = yetAnotherMessageCrud.createNew(subject, body, from, to);

        Assert.assertThat(id, any(String.class));
        Assert.assertTrue(messageRepository.exists(id));
    }
}
