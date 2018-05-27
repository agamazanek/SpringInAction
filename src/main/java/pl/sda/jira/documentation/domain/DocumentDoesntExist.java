package pl.sda.jira.documentation.domain;

public class DocumentDoesntExist extends RuntimeException {

    public DocumentDoesntExist(String message) {
        super(message);
    }
}
