package pl.sda.jira.forum.domain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sda.jira.forum.domain.exceptions.ForumDoesNotExistExcepton;

@ControllerAdvice
public class ForumExceptionHandlerController {

    @ExceptionHandler(ForumDoesNotExistExcepton.class)
    public ResponseEntity<String> haveNoLuck(ForumDoesNotExistExcepton exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
}
