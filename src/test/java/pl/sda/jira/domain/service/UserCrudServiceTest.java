package pl.sda.jira.domain.service;

import org.junit.Test;
import pl.sda.jira.domain.exception.UserNotFoundException;
import pl.sda.jira.domain.model.User;
import pl.sda.jira.persistence.inmemory.InMemoryUserRepository;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class UserCrudServiceTest {
    private static final String SOME_LOGIN = "bruce banner";
    private final InMemoryUserRepository userRepository = new InMemoryUserRepository();
    private final UserCrudService service = new UserCrudService(userRepository);

    @Test(expected = UserNotFoundException.class)
    public void shouldThrowExceptionWhenUserDoesNotExist() {
        service.findBy(randomId());
    }

    @Test
    public void shouldFindUser() {
        String identifier = randomId();
        User user = new User(identifier, SOME_LOGIN);
        userRepository.add(user);

        User result = service.findBy(identifier);

        assertEquals(user, result);
    }

    private String randomId() {
        return UUID.randomUUID().toString();
    }
}
