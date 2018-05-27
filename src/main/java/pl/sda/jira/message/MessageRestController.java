package pl.sda.jira.message;

public class MessageRestController {

    public Response add(Request request) {
        MessageDto messageDto = new MessageDtoFactory.createFrom(request);

        MessageDto result = new MessageService().add(messageDto);

        return new Response(HTTPStatus200, result.getId());
    }
}
