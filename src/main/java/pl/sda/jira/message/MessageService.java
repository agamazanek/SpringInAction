package pl.sda.jira.message;

public class MessageService {
    public MessageDto add(MessageDto messageDto) {
        MessageRepository messageRepository = new MessageRepository();

        if (messageRepository.exists(messageDto.someUniqueInformation())) {
            throw new MessageAlreadyExistException(messageDto.someUniqueInformation());
        } else {
            Message message = new MessageFactory().createFrom(messageDto);
            messageRepository.add(message);
            return message.asDto();
        }
    }
}
