package pl.sda.jira.persistence.inmemory;

import pl.sda.jira.domain.UserRepository;
import pl.sda.jira.domain.model.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void add(User user) {
        users.put(user.identifier(), user);
    }

    @Override
    public void remove(String identifier) {
        users.remove(identifier);
    }

    @Override
    public void replace(User user) {
        users.replace(user.identifier(), user);
    }

    @Override
    public boolean exists(String identifier) {
        return users.containsKey(identifier);
    }

    @Override
    public User findBy(String identifier) {
        return users.get(identifier);
    }
}
