package pl.sda.jira.forum.domain;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ForumService {

    private final ForumRepository forumRepository;
    private String forumId = UUID.randomUUID().toString();

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
        Forum forum = new Forum(forumId, forumDto.getName());
        forumRepository.add(forum);
        return forumId;
    }

    public String remove(String forumId) {
        forumRepository.remove(forumId);
        return forumId;
    }

    public boolean exist(String forumId) {
        return forumRepository.exists(forumId);
    }

    public void update(String identifireForum, ForumDto forumDto) {
        Forum forum = forumRepository.get(identifireForum);
        forum.changeName(forumDto.getName());
        forumRepository.replace(forum);
    }
}