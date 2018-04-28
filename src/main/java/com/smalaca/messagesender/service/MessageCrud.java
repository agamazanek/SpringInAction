package com.smalaca.messagesender.service;

import com.smalaca.messagesender.domain.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageCrud {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageCrud(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public String createNew(String subject, String body, String from, String to) {
        messageRepository.add();
        return "1";
    }
}
