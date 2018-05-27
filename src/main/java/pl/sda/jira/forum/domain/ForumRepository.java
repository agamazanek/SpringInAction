package pl.sda.jira.forum.domain;

public interface ForumRepository {
    Forum get(int forumId);

    boolean exists(int forumId);

    void add(Forum forum);

}
