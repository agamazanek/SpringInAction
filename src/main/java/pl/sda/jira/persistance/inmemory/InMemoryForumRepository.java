package pl.sda.jira.persistance.inmemory;


import pl.sda.jira.forum.domain.Forum;
import pl.sda.jira.forum.domain.ForumRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryForumRepository implements ForumRepository {

    private final Map<Long, Forum> forumMap = new HashMap<>();

    @Override
    public Forum get(long forumId) {
        return forumMap.get(forumId);
    }

    @Override
    public boolean exists(long forumId) {
        return forumMap.containsKey(forumId);
    }

    @Override
    public Forum add(Forum forum) {
        forumMap.put(forum.getForumId(), forum);
        return forum;
    }

    @Override
    public void replace(Forum forum) {
        forumMap.replace(forum.getForumId(), forum);
    }

    @Override
    public void remove(long forumId) {
        forumMap.remove(forumId);
    }

}