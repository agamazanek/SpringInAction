package pl.sda.jira.domain;

import pl.sda.jira.forum.domain.Forum;

public interface ForumRepository {

    boolean exists(String identifier);

    Forum findBy(String identifier);

    void add(Forum forum);

    void remove(String identifier);

    void replace(Forum forum);

}
