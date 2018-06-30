package pl.sda.jira.project.domain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sda.jira.documentation.domain.exception.DocumentDoestExist;
import pl.sda.jira.forum.domain.ForumDoesNotExistExcepton;
import pl.sda.jira.project.model.ProjectDoesntExistException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ProjectAlreadyExistsException.class)
    public ResponseEntity<String> projectAlreadyExists(ProjectAlreadyExistsException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({ProjectDoesntExistException.class, ForumDoesNotExistExcepton.class,DocumentDoestExist.class})
    public ResponseEntity<String>notFound(Exception exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }

}
