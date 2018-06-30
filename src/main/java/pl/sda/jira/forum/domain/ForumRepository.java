package pl.sda.jira.forum.domain;

public interface ForumRepository {
    Forum get(String forumId);

    boolean exists(String forumId);

    Forum add(Forum forum);

    void remove(String forumId);

    void replace(Forum forum);
}
