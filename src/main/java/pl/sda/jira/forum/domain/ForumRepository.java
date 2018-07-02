package pl.sda.jira.forum.domain;

public interface ForumRepository {
    Forum get(long forumId);

    boolean exists(long forumId);

    Forum add(Forum forum);

    void remove(long forumId);

    void replace(Forum forum);
}
