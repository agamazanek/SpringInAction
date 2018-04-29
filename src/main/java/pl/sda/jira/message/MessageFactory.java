package pl.sda.jira.message;

public class MessageFactory {

    public Message aMessage(String topic) {
        return new Message(topic);
    }

    public Message aMessageWithContent(String topic, String content) {
        Message message = aMessage(topic);
        message.setContect(content);
        return message;
    }
}
