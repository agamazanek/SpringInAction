package pl.sda.jira.forum.domain;

import java.util.List;

public class Forum {
    private final String name;
    private final String spaceId;

    private List<Topic> topics;

    public Forum(String name, String spaceId) {
        this.name = name;
        this.spaceId = spaceId;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}

