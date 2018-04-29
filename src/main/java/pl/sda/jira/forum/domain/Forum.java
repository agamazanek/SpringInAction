package pl.sda.jira.forum.domain;

import java.util.Collections;
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

    public String getName() {
        return name;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public List<Topic> getTopics() {
        if (topics == null) {
            return Collections.emptyList();
        }
        return topics;
    }
}

