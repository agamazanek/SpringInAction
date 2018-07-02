package pl.sda.jira.forum.domain;

import org.springframework.stereotype.Service;
import pl.sda.jira.forum.domain.exceptions.ForumDoesNotExistException;
import pl.sda.jira.forum.dto.ForumDto;


@Service
public class ForumService {

    private final ForumRepository forumRepository;

    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public ForumDto get(long forumId) {
        if (forumRepository.exists(forumId)) {
            return forumRepository.get(forumId).asDto();
        } else {
            throw new ForumDoesNotExistException(forumId);
        }
    }

    public long add(ForumDto forumDto) {
        Forum forum = new Forum(forumDto.getName());
        return forumRepository.add(forum).getForumId();
    }

    public void remove(long forumId) {
        if(forumRepository.exists(forumId)){
               forumRepository.remove(forumId);
        } else {
            throw new ForumDoesNotExistException(forumId);
        }
    }

    public boolean exist(long forumId) {
        return forumRepository.exists(forumId);
    }

    public void update(long identifireForum, ForumDto forumDto) {
        Forum forum = forumRepository.get(identifireForum);
        forum.changeName(forumDto.getName());
        forumRepository.replace(forum);
    }
}