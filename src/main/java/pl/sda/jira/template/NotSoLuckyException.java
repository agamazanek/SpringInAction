package pl.sda.jira.template;

public class NotSoLuckyException extends RuntimeException {
    public NotSoLuckyException(String number) {
        super("This number: " + number + ", is not so lucky");
    }
}
