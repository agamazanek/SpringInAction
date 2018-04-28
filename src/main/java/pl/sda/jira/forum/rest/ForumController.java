package pl.sda.jira.forum.rest;

import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.jira.forum.domain.ForumRepository;

public class ForumController {
    private final ForumRepository forumRepository;

    @Autowired
    public ForumController(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public boolean existsForSpace(String spaceId) {
        return forumRepository.existsFor(spaceId);
    }
}
