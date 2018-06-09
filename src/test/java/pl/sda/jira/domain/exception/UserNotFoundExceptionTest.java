package pl.sda.jira.domain.exception;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class UserNotFoundExceptionTest {
    private static final String SOME_IDENTIFIER = UUID.randomUUID().toString();

    @Test
    public void shouldHaveAppropriateMessage() {
        UserNotFoundException exception = new UserNotFoundException(SOME_IDENTIFIER);

        assertEquals("User with id: " + SOME_IDENTIFIER + " does not exist", exception.getMessage());
    }
}