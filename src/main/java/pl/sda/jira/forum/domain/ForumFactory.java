package pl.sda.jira.forum.domain;

import java.util.List;

public class ForumFactory {

    public Forum aForum(String name, String spaceId){
        return new Forum(name, spaceId);
    }

    public Forum aForumWithTopic(String name, String spaceId, List<Topic> topics){
        Forum forum = aForum(name, spaceId);
        forum.setTopics(topics);
        return forum;
    }
}
