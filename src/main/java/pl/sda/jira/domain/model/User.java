package pl.sda.jira.domain.model;

public class User {
    private final String identifier;
    private final String login;

    public User(String identifier, String login) {
        this.identifier = identifier;
        this.login = login;
    }

    public String identifier() {
        return identifier;
    }

    public boolean hasSameLoginAs(String login) {
        return this.login.equals(login);
    }
}
