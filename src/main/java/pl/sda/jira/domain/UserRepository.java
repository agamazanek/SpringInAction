package pl.sda.jira.domain;

import pl.sda.jira.domain.model.User;

public interface UserRepository {
    boolean exists(String identifier);

    User findBy(String identifier);
}
