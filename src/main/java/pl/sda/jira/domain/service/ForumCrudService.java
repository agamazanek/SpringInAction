package pl.sda.jira.domain.service;

import pl.sda.jira.domain.exception.ForumNotFoundException;
import pl.sda.jira.forum.domain.Forum;

import pl.sda.jira.forum.domain.ForumDto;
import pl.sda.jira.domain.ForumRepository;

public class ForumCrudService {
    private final ForumRepository forumRepository;
    private final ForumIdentifier forumIdentifier;

    ForumCrudService(ForumRepository forumRepository, ForumIdentifier forumIdentifier) {
        this.forumRepository = forumRepository;
        this.forumIdentifier = forumIdentifier;
    }

    public Forum findBy(String identifier) throws ForumNotFoundException {
        if (forumRepository.exists(identifier)) {
            return forumRepository.findBy(identifier);
        }
        throw new ForumNotFoundException(identifier);
    }

    public String add(ForumDto forumDto) {
        String identifier = forumIdentifier.create();
        forumRepository.add(new Forum(identifier, forumDto.login));
        return identifier;
    }

    public void remove(String identifier) {
        forumRepository.remove(identifier);
    }

    public void update(String identifier, ForumDto forumDto) {
        Forum forum = forumRepository.findBy(identifier);
        forum.changeLogin(forumDto.login);
        forumRepository.replace(forum);
    }
}
