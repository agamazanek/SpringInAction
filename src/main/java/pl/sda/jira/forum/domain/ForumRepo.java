package pl.sda.jira.forum.domain;

import java.util.List;

public class ForumRepo {
    private final List<Forum> forums;

    public ForumRepo(List<Forum> forums) {
        this.forums = forums;
    }

    public List<Forum> getAll() {
        return forums;
    }
}
