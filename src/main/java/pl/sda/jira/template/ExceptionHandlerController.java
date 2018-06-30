package pl.sda.jira.template;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sda.jira.project.domain.ProjectAlreadyExistsException;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(NotSoLuckyException.class)
    public ResponseEntity<String> haveNoLuck(NotSoLuckyException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(ProjectAlreadyExistsException.class)
    public ResponseEntity<String> alreadyExist(ProjectAlreadyExistsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

}
