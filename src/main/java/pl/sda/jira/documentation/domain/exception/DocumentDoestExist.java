package pl.sda.jira.documentation.domain.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DocumentDoestExist extends RuntimeException {

    public DocumentDoestExist(Long documentationId ) {
        super("Document doest exist . About this id : " + documentationId);
    }
}

