package pl.sda.jira.domain.dto;

public class UserDto {
    public final String login;

    private UserDto(String login) {
        this.login = login;
    }

    public static class Builder {
        private final String login;

        private Builder(String login) {
            this.login = login;
        }

        public static Builder aUser(String login) {
            return new Builder(login);
        }

        public UserDto build() {
            return new UserDto(login);
        }
    }
}
