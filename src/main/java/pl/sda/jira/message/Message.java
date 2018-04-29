package pl.sda.jira.message;

public class Message {
    private final String topic;

    private String contect;
    private String sender;
    private String recipient;

    Message(String topic) {
        this.topic = topic;
    }

    public void setContect(String contect) {
        this.contect = contect;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
