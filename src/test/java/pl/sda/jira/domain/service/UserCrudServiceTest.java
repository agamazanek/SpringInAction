package pl.sda.jira.domain.service;

import org.junit.Test;
import pl.sda.jira.domain.UserRepository;
import pl.sda.jira.domain.dto.UserDto;
import pl.sda.jira.domain.exception.UserNotFoundException;
import pl.sda.jira.domain.model.User;
import pl.sda.jira.persistence.inmemory.InMemoryUserRepository;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static pl.sda.jira.domain.dto.UserDto.Builder.aUser;

public class UserCrudServiceTest {
    private static final String SOME_LOGIN = "bruce banner";
    private static final String DIFFERENT_LOGIN = "natasha romanov";

    private final UserRepository userRepository = new InMemoryUserRepository();
    private final UserCrudService service = new UserCrudService(userRepository, new UserIdentifier());

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

    @Test
    public void shouldAddUser() {
        UserDto userDto = someUserDto();

        String identifier = service.add(userDto);

        User created = service.findBy(identifier);
        assertTrue(created.hasSameLoginAs(SOME_LOGIN));
    }

    @Test
    public void shouldRemoveUser() {
        String identifier = service.add(someUserDto());

        service.remove(identifier);

        assertUserDoesNotExist(identifier);
    }

    private void assertUserDoesNotExist(String identifier) {
        try {
            service.findBy(identifier);
            fail("User should be not found.");
        } catch (UserNotFoundException exception) {
            assertEquals("User with id: " + identifier + " does not exist", exception.getMessage());
        }
    }

    @Test
    public void shouldUpdateUser() {
        String identifier = service.add(someUserDto());

        service.update(identifier, aUserDtoWith(DIFFERENT_LOGIN));

        User created = service.findBy(identifier);
        assertTrue(created.hasSameLoginAs(DIFFERENT_LOGIN));
    }

    private UserDto someUserDto() {
        return aUserDtoWith(SOME_LOGIN);
    }

    private UserDto aUserDtoWith(String login) {
        return aUser(login).build();
    }

    private String randomId() {
        return UUID.randomUUID().toString();
    }
}
