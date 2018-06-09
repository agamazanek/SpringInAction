package pl.sda.jira.domain.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String identifier) {
        super("User with id: " + identifier + " does not exist");
    }
}
