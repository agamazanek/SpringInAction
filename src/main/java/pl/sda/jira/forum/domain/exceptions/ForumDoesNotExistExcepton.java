package pl.sda.jira.forum.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ForumDoesNotExistExcepton extends RuntimeException {
    public ForumDoesNotExistExcepton(String forumId) {
        super("Forum with id: " + forumId + " does not exist!");
    }
}
