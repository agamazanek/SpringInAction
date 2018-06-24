package pl.sda.jira.template;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NotSoLuckyException extends RuntimeException {
    public NotSoLuckyException(String number) {
        super("This number: " + number + ", is not so lucky");
    }
}
