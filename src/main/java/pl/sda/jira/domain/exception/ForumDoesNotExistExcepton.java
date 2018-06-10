package pl.sda.jira.domain.exception;

public class ForumDoesNotExistExcepton extends Throwable {

    public ForumDoesNotExistExcepton(String identifier) {
        super("Forum with id: " + identifier + " does not exist");
    }
}
