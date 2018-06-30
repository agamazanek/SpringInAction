package pl.sda.jira.forum.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.sda.jira.forum.domain.exceptions.ForumDoesNotExistExcepton;
import pl.sda.jira.forum.dto.ForumDto;

import java.util.UUID;


@Service
public class ForumService {

    private final ForumRepository forumRepository;

    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public ForumDto get(String forumId) {
        if (forumRepository.exists(forumId)) {
            return forumRepository.get(forumId).asDto();
        } else {
            throw new ForumDoesNotExistExcepton(forumId);
        }
    }

    public String add(ForumDto forumDto) {
        Forum forum = new Forum(forumDto.getName());
        return forumRepository.add(forum).getForumId();
    }

    public void remove(String forumId) {
        if(forumRepository.exists(forumId)){
               forumRepository.remove(forumId);
        } else {
            throw new ForumDoesNotExistExcepton(forumId);
        }
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