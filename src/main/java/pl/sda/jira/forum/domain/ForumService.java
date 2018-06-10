package pl.sda.jira.forum.domain;

import pl.sda.jira.domain.ForumRepository;

public class ForumService{

    private final ForumRepository forumRepository;
    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public ForumDto get(int forumId) throws ForumDoesNotExistExcepton {

        if (forumRepository.exist(forumId)) {
            return forumRepository.get(forumId).asDto();
        } else {
            throw new ForumDoesNotExistExcepton();
        }
    }

}
