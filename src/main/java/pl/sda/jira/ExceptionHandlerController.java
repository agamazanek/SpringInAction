package pl.sda.jira;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sda.jira.documentation.domain.exception.DocumentDoestExist;
import pl.sda.jira.documentation.domain.exception.ThisSameDocumentExist;
import pl.sda.jira.forum.domain.exceptions.ForumDoesNotExistException;
import pl.sda.jira.project.domain.ProjectAlreadyExistsException;
import pl.sda.jira.project.model.ProjectDoesntExistException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({ProjectAlreadyExistsException.class,ThisSameDocumentExist.class})
    public ResponseEntity<String> entityAlreadyExists(RuntimeException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({ProjectDoesntExistException.class,DocumentDoestExist.class,ForumDoesNotExistException.class})
    public ResponseEntity<String>notFound(RuntimeException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }
}
