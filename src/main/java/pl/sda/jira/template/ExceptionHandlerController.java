package pl.sda.jira.template;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(NotSoLuckyException.class)
    public ResponseEntity<String> haveNoLuck(NotSoLuckyException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> evenLessLuck(RuntimeException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
    }
}
