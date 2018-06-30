package pl.sda.jira.documentation.domain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sda.jira.documentation.domain.exception.ThisSameDocumentExist;

@ControllerAdvice
public class DocumentExceptionHandlerController {

    @ExceptionHandler(ThisSameDocumentExist.class)
    public ResponseEntity<String> sameDocumentExist(ThisSameDocumentExist exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.CONFLICT);
    }

}
