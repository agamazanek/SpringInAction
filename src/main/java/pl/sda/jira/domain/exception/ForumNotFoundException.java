package pl.sda.jira.domain.exception;

public class ForumNotFoundException extends Throwable {
    public ForumNotFoundException(String identifier) {
        super("Forum with id: " + identifier + " does not exist");
    }
}
