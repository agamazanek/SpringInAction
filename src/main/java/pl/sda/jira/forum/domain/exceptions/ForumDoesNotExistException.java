package pl.sda.jira.forum.domain.exceptions;

public class ForumDoesNotExistException extends RuntimeException {
    public ForumDoesNotExistException(long forumId) {
        super("Forum with id: " + forumId + " does not exist!");
    }
}
