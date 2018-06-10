package pl.sda.jira.persistance.inmemory;

import pl.sda.jira.forum.domain.Forum;
import pl.sda.jira.domain.ForumRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryForumRepository implements ForumRepository {

    private final Map<Integer, Forum> forumMap = new HashMap<>();

    @Override
    public boolean exist(int forumId) {
        return forumMap.containsKey(forumId);
    }

    @Override
    public Forum get(int forumId) {
        return forumMap.get(forumId);
    }

    @Override
    public void add(Forum forum) {
        forumMap.put(forum.getId(), forum);
    }

}
