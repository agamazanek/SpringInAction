package pl.sda.jira.forum.domain;

import java.util.UUID;

public class ForumService {

    private final ForumRepository forumRepository;

    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public ForumDto get(String forumId) {
        if (forumRepository.exists(forumId)) {
            return forumRepository.get(forumId).asDto();
        } else {
            throw new ForumDoesNotExistExcepton();
        }
    }

    public String add(ForumDto forumDto) {
        String forumId = UUID.randomUUID().toString();
        Forum forum = new Forum(forumId, forumDto.getName());
        forumRepository.add(forum);

        return forumId;
    }

    public String remove(String forumId) {
        forumRepository.remove(forumId);

        return forumId;
    }

    public boolean exist(String forumId) {
        if (forumRepository.exists(forumId)) {
            return true;
        } else {
            return false;
        }
    }
}